import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private int sum = 0;

    private static final Map<Integer,Integer> valuesOfLetters = new HashMap<>(26);
    static{
        "AEIOULNRST".chars().forEach(c -> valuesOfLetters.put(c,1));
        "DG".chars().forEach(c->valuesOfLetters.put(c,2));
        "BCMP".chars().forEach(c->valuesOfLetters.put(c,3));
        "FHVWY".chars().forEach(c->valuesOfLetters.put(c,4));
        "K".chars().forEach(c->valuesOfLetters.put(c,5));
        "JX".chars().forEach(c->valuesOfLetters.put(c,8));
        "QZ".chars().forEach(c->valuesOfLetters.put(c,10));

    }


    enum ValuesOfLetters {

        ONE(new Character[]{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'}, 1),
        TWO(new Character[]{'D', 'G'}, 2),
        THREE(new Character[]{'B', 'C', 'M', 'P'}, 3),
        FOUR(new Character[]{'F', 'H', 'V', 'W', 'Y'}, 4),
        FIVE(new Character[]{'K'}, 5),
        EIGHT(new Character[]{'J', 'X'}, 8),
        TEN(new Character[]{'Q', 'Z'}, 10),

        ;


        Character[] characters;
        int number;

        ValuesOfLetters(Character[] characters, int number) {
            this.characters = characters;
            this.number = number;
        }


    }


    Scrabble(String word) {
        word = word.toUpperCase();
        calculateScore(word);

    }

    private void calculateScore(String word){
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < ValuesOfLetters.ONE.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.ONE.characters[j]) {
                    sum = sum + ValuesOfLetters.ONE.number;
                    break;
                }
            }
            for (int j = 0; j < ValuesOfLetters.TWO.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.TWO.characters[j]) {
                    sum = sum + ValuesOfLetters.TWO.number;
                    break;
                }
            }
            for (int j = 0; j < ValuesOfLetters.THREE.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.THREE.characters[j]) {
                    sum = sum + ValuesOfLetters.THREE.number;
                    break;
                }
            }
            for (int j = 0; j < ValuesOfLetters.FOUR.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.FOUR.characters[j]) {
                    sum = sum + ValuesOfLetters.FOUR.number;
                    break;
                }

            }

            for (int j = 0; j < ValuesOfLetters.FIVE.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.FIVE.characters[j]) {
                    sum = sum + ValuesOfLetters.FIVE.number;
                    break;
                }

            }

            for (int j = 0; j < ValuesOfLetters.EIGHT.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.EIGHT.characters[j]) {
                    sum = sum + ValuesOfLetters.EIGHT.number;
                    break;
                }

            }

            for (int j = 0; j < ValuesOfLetters.TEN.characters.length; j++) {
                if (word.charAt(i) == ValuesOfLetters.TEN.characters[j]) {
                    sum = sum + ValuesOfLetters.TEN.number;
                    break;
                }

            }

        }

    }


    int getScore() {
        return sum;
    }

}
