import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
        if ((!inputNumber.isEmpty()) && !inputNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException(
                "Series length must be less than or equal to the length of the string to search.");
        }
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (numberOfDigits == 0) {
            return 1;
        }
        return IntStream.range(0, inputNumber.length() - numberOfDigits + 1)
            .mapToObj(i -> getProduct(i, i + numberOfDigits - 1))
            .max(Long::compareTo).orElse(0L);
    }

    private long getProduct(int start, int end) {
        return IntStream.rangeClosed(start, end)
            .mapToLong(i -> Character.getNumericValue(inputNumber.charAt(i)))
            .reduce(1, (a, b) -> (a * b));
    }
}