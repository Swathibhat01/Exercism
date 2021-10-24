import java.math.BigInteger;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum =0;
        for(int i=1;i<=input;i++){
            sum = sum +i;
        }
        return BigInteger.valueOf(sum).pow(2).intValue();
    }

    int computeSumOfSquaresTo(int input) {
        int sum = 0;
        for (int i =1 ; i<=input ;i++){
            sum = sum + BigInteger.valueOf(i).pow(2).intValue();
        }
        return sum;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
