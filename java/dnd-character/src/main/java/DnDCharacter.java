import java.util.Arrays;
import java.util.Random;

class DnDCharacter {

    int[] abilityScores;

    DnDCharacter() {
        int[] abilityScores = new int[6];
        for (int i = 0; i < 6; i++) {
            abilityScores[i] = ability();
        }
        Arrays.sort(abilityScores);
        this.abilityScores = abilityScores;
    }

    int ability() {
        Random random = new Random();
        int[] fourDiceScore = new int[4];
        for (int i = 0; i < 4; i++) {
            fourDiceScore[i] = random.nextInt(6) + 1;
        }
        Arrays.sort(fourDiceScore);
        return fourDiceScore[1] + fourDiceScore[2] + fourDiceScore[3];
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
