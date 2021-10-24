import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private static final Map<Integer, Integer> valuesOfLetters = new HashMap<>(26);

    static {
        "AEIOULNRST".chars().forEach(c -> valuesOfLetters.put(c, 1));
        "DG".chars().forEach(c -> valuesOfLetters.put(c, 2));
        "BCMP".chars().forEach(c -> valuesOfLetters.put(c, 3));
        "FHVWY".chars().forEach(c -> valuesOfLetters.put(c, 4));
        "K".chars().forEach(c -> valuesOfLetters.put(c, 5));
        "JX".chars().forEach(c -> valuesOfLetters.put(c, 8));
        "QZ".chars().forEach(c -> valuesOfLetters.put(c, 10));
    }

    private int sum;

    Scrabble(String word) {
        sum = calculateScore(word.toUpperCase());
    }

    private int calculateScore(String word) {
        return word.chars().reduce(0, (c, b) -> c + valuesOfLetters.get(b));
    }

    int getScore() {
        return sum;
    }

}
