import java.util.Arrays;

class Matrix {

    private int[][] matrix;

    Matrix(String matrixAsString) {
        matrix =  Arrays.stream(matrixAsString.split("\n"))
                        .map(this::splitColumns)
                        .toArray(int[][]::new);

    }

    private int[] splitColumns(String r) {
        return Arrays.stream(r.split(" "))
                         .mapToInt(Integer::parseInt)
                         .toArray();
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(m -> m[columnNumber - 1]).toArray();
    }
}
