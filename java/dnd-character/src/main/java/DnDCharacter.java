import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DnDCharacter {

    private int[] abilityScores;

    DnDCharacter() {
        int[] abilityScores = new int[6];
        for (int i = 0; i < 6; i++) {
            abilityScores[i] = ability();
        }
        this.abilityScores = abilityScores;
    }

    int ability() {
        Random random = new Random();
        List<Integer> fourDiceScore = IntStream.range(0, 4)
            .mapToObj(i -> random.nextInt(6) + 1)
            .sorted()
            .collect(Collectors.toList());
        return fourDiceScore.get(1) + fourDiceScore.get(2) + fourDiceScore.get(3);
    }

    int modifier(int input) {
        double modifier = (input - 10) / 2.0;
        return (int) Math.floor(modifier);
    }

    int getStrength() {
        return abilityScores[2];
    }

    int getDexterity() {
        return abilityScores[1];
    }

    int getConstitution() {
        return abilityScores[0];
    }

    int getIntelligence() {
        return abilityScores[3];
    }

    int getWisdom() {
        return abilityScores[4];
    }

    int getCharisma() {
        return abilityScores[5];
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }

}
