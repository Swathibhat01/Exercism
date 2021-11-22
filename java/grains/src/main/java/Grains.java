import java.math.BigInteger;

class Grains {

    private BigInteger total = new BigInteger("1");

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.TWO.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        for (int i = 2; i <= 64; i++) {
            total = total.add(grainsOnSquare(i));
        }
        return total;
    }

}
