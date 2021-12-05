import java.util.Map;
import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        String finalCandidate = candidate.replaceAll(" ", "");
        int length = finalCandidate.length();
        if (length <= 1) {
            return false;
        }
        if (finalCandidate.matches(".*[^\\d]+.*")) {
            return false;
        }
        return IntStream.iterate(length - 1, i -> i >= 0, i -> i - 1)
            .mapToObj(i -> Map.entry(i, Character.getNumericValue(finalCandidate.charAt(i))))
            .map(e -> (length - e.getKey()) % 2 == 0 ? e.getValue() * 2
                : e.getValue())
            .mapToInt(d -> d > 9 ? d - 9 : d)
            .sum() % 10 == 0;

    }

}
