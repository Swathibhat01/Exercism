class Darts {

    private double x;
    private double y;
    private int score;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        double sqrt = Math.sqrt((x * x) + (y * y));
        if (sqrt > 10) {
            score = 0;
        } else if (sqrt > 5) {
            score = 1;
        } else if (sqrt > 1) {
            score = 5;
        } else {
            score = 10;
        }
        return score;
    }

}
