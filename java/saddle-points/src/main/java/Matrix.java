import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private final List<List<Integer>> matrix;


    Matrix(List<List<Integer>> values) {
        matrix = values;
    }

    List<List<Integer>> rotateArray() {
        List<List<Integer>> rotatedMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.get(0).size(); i++) {
            List<Integer> rotatedRows = new ArrayList<>();
            for (int j = 0; j < matrix.size(); j++) {
                rotatedRows.add(matrix.get(j).get(i));
            }
            rotatedMatrix.add(rotatedRows);
        }
        return rotatedMatrix;
    }


    Set<MatrixCoordinate> getSaddlePoints() {
        if (matrix.isEmpty()) {
            return Collections.emptySet();
        }

        Set<MatrixCoordinate> maxCoordinate= getMaxCoOrdinates();
        List<List<Integer>> rotatedMatrix = rotateArray();
        Set<MatrixCoordinate> minCoordinate=getMinCoOrdinates(rotatedMatrix);

        maxCoordinate.retainAll(minCoordinate);
        return maxCoordinate;
    }

    private Set<MatrixCoordinate> getMinCoOrdinates(List<List<Integer>> rotatedMatrix) {
        Set<MatrixCoordinate> minCoordinate = new HashSet<>();

        for (int i = 0; i < rotatedMatrix.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < rotatedMatrix.get(0).size(); j++) {
                if (rotatedMatrix.get(i).get(j) <= min) {
                    min = rotatedMatrix.get(i).get(j);
                }
            }
            for (int j = 0; j < rotatedMatrix.get(0).size(); j++) {
                if (rotatedMatrix.get(i).get(j) == min) {
                    minCoordinate.add(new MatrixCoordinate(j + 1, i + 1));
                }
            }
        }
        return minCoordinate;
    }

    private Set<MatrixCoordinate> getMaxCoOrdinates() {
        Set<MatrixCoordinate> maxCoordinate = new HashSet<>();
        for (int i = 0; i < matrix.size(); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) >= max) {
                    max = matrix.get(i).get(j);
                }
            }
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == max) {
                    maxCoordinate.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }
        return maxCoordinate;
    }
}
