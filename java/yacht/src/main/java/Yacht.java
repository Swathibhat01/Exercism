import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;
    private final Map<Integer, Long> diceCountMap;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.yachtCategory = yachtCategory;
        this.dice = dice;
        diceCountMap = Arrays.stream(dice).boxed()
            .collect(Collectors.groupingBy(k -> k, Collectors.counting()));

    }

    int score() {
        switch (yachtCategory) {
            case ONES:
                return calculateOneToSix(1);
            case TWOS:
                return calculateOneToSix(2);
            case THREES:
                return calculateOneToSix(3);
            case FOURS:
                return calculateOneToSix(4);
            case FIVES:
                return calculateOneToSix(5);
            case SIXES:
                return calculateOneToSix(6);
            case FULL_HOUSE:
                return calculateScoreOfFullHouse();
            case FOUR_OF_A_KIND:
                return calculateScoreIfFourOfAKind();
            case LITTLE_STRAIGHT:
                return calculateScoreOfLittleAndBigStraight(6);
            case BIG_STRAIGHT:
                return calculateScoreOfLittleAndBigStraight(1);
            case CHOICE:
                return calculateScoreOfChoice();
            case YACHT:
                return calculateScoreOfYacht();
        }
        return 0;
    }

    private int calculateScoreOfYacht() {
        return diceCountMap.size() == 1 ? 50 : 0;
    }

    private int calculateScoreOfChoice() {
        return Arrays.stream(dice).sum();
    }

    private int calculateScoreOfLittleAndBigStraight(int i) {
        return diceCountMap.size() == 5 && !diceCountMap.containsKey(i) ? 30 : 0;
    }

    private int calculateScoreIfFourOfAKind() {
        return diceCountMap.keySet().stream()
            .filter(k -> diceCountMap.get(k) >= 4)
            .map(k -> k * 4).findAny().orElse(0);
    }

    private int calculateScoreOfFullHouse() {
        if ((diceCountMap.size() == 2) && diceCountMap.containsValue(3L)) {
            return Arrays.stream(dice).sum();
        }
        return 0;
    }

    private int calculateOneToSix(int i) {
        return Arrays.stream(dice).filter(v -> v == i).sum();
    }
}