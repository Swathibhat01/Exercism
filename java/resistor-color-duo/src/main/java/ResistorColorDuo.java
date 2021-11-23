import java.util.Arrays;

class ResistorColorDuo {

    public enum Colors {
        BLACK(0),
        BROWN(1),
        RED(2),
        ORANGE(3),
        YELLOW(4),
        GREEN(5),
        BLUE(6),
        VIOLET(7),
        GREY(8),
        WHITE(9);

        private final int value;

        Colors(int i) {
            this.value = i;
        }

        int getValue() {
            return value;
        }
    }

    int value(String[] colors) {
        if (colors.length < 2) {
            return 0;
        }
        return Arrays.stream(colors).limit(2)
            .map(String::toUpperCase)
            .map(Colors::valueOf)
            .map(Colors::getValue)
            .reduce(0, (acc, value) -> acc * 10 + value);

    }
}
