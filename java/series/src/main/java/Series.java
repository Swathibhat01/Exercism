import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Series {

    private String string;

    Series(String string) {
        this.string = string;
    }

    List<String> slices(int sliceLength) {
        if (sliceLength > string.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        }
        if (sliceLength <= 0) {
            throw new IllegalArgumentException("Slice size is too small.");
        }
        return IntStream.rangeClosed(0, string.length() - sliceLength)
            .mapToObj(i -> makeSlice(i, i + sliceLength - 1))
            .collect(Collectors.toList());
    }

    private String makeSlice(int start, int end) {
        return string.substring(start, end + 1);
    }
}