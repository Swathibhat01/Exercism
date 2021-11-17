import java.util.Arrays;

class Matrix {

    int[][] matrix;

    Matrix(String matrixAsString) {
        matrix =  Arrays.stream(matrixAsString.split("\n")).map(r ->
        {
            return Arrays.stream(r.split(" ")).mapToInt(Integer::parseInt).toArray();

        }).toArray(int[][]::new);

    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(m -> m[columnNumber - 1]).toArray();
    }
}
