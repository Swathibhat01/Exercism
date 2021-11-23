import java.util.stream.Stream;

class ResistorColor {

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

        public int getValue() {
            return value;
        }

        private final int value;

        Colors(int i) {
            this.value = i;

        }
    }

    int colorCode(String color) {
        return Colors.valueOf(color.toUpperCase()).getValue();
    }

    String[] colors() {
        return Stream.of(Colors.values()).map(v -> v.name().toLowerCase()).toArray(String[]::new);
    }

}

