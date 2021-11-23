class ResistorColorDuo {

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

        private int value;

        COLORS(int i) {
            this.value = i;
        }

        int getValue() {
            return value;
        }
    }

    int value(String[] colors) {
        return (COLORS.valueOf(colors[0].toUpperCase()).getValue()) * 10 + COLORS
            .valueOf(colors[1].toUpperCase()).getValue();
    }
}
