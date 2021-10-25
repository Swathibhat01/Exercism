import java.util.stream.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {

        int sum = Stream.iterate(0, n -> n + 1)
            .limit(input + 1)
            .reduce(0, Integer::sum);

        return (int) Math.pow(sum, 2);

    }

    int computeSumOfSquaresTo(int input) {

        return Stream.iterate(0, n -> n + 1)
            .limit(input + 1)
            .map(n -> (int)Math.pow(n,2))
            .reduce(0, Integer::sum);
    }

    int computeDifferenceOfSquares (int input){
            return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
        }

    }

