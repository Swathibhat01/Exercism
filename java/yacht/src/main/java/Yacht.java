import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.yachtCategory = yachtCategory;
        this.dice = dice;
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
                return calculateScoreOfYatch();
        }
        return 0;
    }

    private int calculateScoreOfYatch() {
        Set<Integer> collect = Arrays.stream(dice).boxed().collect(Collectors.toSet());
        if (collect.size() == 1) {
            return 50;
        }
        return 0;
    }

    private int calculateScoreOfChoice() {
        return Arrays.stream(dice).sum();
    }

    private int calculateScoreOfLittleAndBigStraight(int i) {
        //Set<Integer> collect = new HashSet<>(dice);
        Set<Integer> collect = Arrays.stream(dice).boxed().collect(Collectors.toSet());
        if (collect.size() == 5 && !collect.contains(i)) {
            return 30;
        }
        return 0;

    }

    private int calculateScoreIfFourOfAKind() {
        Map<Integer, Long> collect = Arrays.stream(dice).boxed()
            .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        if (collect.size() == 1) {
            return collect.keySet().iterator().next() * 4;
        }
        if ((collect.size() == 2) && collect.containsValue((long) 4)) {
            for (Integer value : collect.keySet()) {
                if (collect.get(value) == 4) {
                    return 4 * value;
                }
            }
        }
        return 0;
    }

    private int calculateScoreOfFullHouse() {
        Map<Integer, Long> collect = Arrays.stream(dice).boxed()
            .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        if ((collect.size() == 2) && collect.containsValue((long) 3)) {
            return Arrays.stream(dice).sum();
        }
        return 0;
    }

    private int calculateOneToSix(int i) {
       return Arrays.stream(dice).filter(v -> v==i).sum();
    }

}
