import java.util.stream.Stream;

class ResistorColor {

    public enum COLORS {
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

        int value;

        COLORS(int i) {
            this.value = i;

        }
    }


    int colorCode(String color) {
        return COLORS.valueOf(color.toUpperCase()).getValue();
    }

    String[] colors() {
        return Stream.of(COLORS.values()).map(v -> v.name().toLowerCase()).toArray(String[]::new);
    }

}

