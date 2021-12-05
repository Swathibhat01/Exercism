class BeerSong {

    private final String firstLine;
    private final String secondLine;
    private final String lastLine;

    BeerSong() {
        this.firstLine = "%s %s of beer on the wall, %s %s of beer.";
        this.secondLine = "Take %s down and pass it around, %s %s of beer on the wall.";
        this.lastLine = "Go to the store and buy some more, 99 bottles of beer on the wall.";
    }

    String sing(int bottlesOfBeer, int verse) {
        StringBuilder poemBuilder = new StringBuilder();
        for (int i = 1; i <= verse && bottlesOfBeer >= 0; i++, bottlesOfBeer--) {
            poemBuilder.append(firstLine(bottlesOfBeer)).append("\n")
                .append(secondLine(bottlesOfBeer)).append("\n")
                .append("\n");
        }
        return poemBuilder.toString();
    }

    private String firstLine(int bottlesOfBeer) {
        return String
            .format(firstLine,
                bottleCount(bottlesOfBeer, "No more"),
                bottleString(bottlesOfBeer),
                bottleCount(bottlesOfBeer, "no more"),
                bottleString(bottlesOfBeer));
    }

    private String secondLine(int bottlesOfBeer) {
        if (bottlesOfBeer == 0) {
            return lastLine;
        }
        return String.format(secondLine,
            (bottlesOfBeer == 1 ? "it" : "one"),
            bottleCount(bottlesOfBeer - 1, "no more"),
            bottleString(bottlesOfBeer - 1));
    }

    private String bottleCount(int bottlesOfBeer, String noBottleString) {
        return bottlesOfBeer == 0 ? noBottleString : bottlesOfBeer + "";
    }

    private String bottleString(int bottlesOfBeer) {
        return bottlesOfBeer == 1 ? "bottle" : "bottles";
    }

    public String singSong() {
        return sing(99, 100);
    }
}
