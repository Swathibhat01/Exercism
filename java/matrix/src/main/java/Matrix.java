import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Matrix {

    List<List<String>> matrix = new ArrayList<>();

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        for (String row : rows) {
            String[] split = row.split(" ");
            matrix.add(Arrays.asList(split));
        }
    }

    int[] getRow(int rowNumber) {
        List<String> rowAsList = matrix.get(rowNumber - 1);
        int[] arrayOfRow = new int[rowAsList.size()];
        for (int i = 0; i < rowAsList.size(); i++) {
            arrayOfRow[i] = Integer.parseInt(rowAsList.get(i));
        }
        return arrayOfRow;
    }

    int[] getColumn(int columnNumber) {
        int sizeOfTheMatrix = matrix.size();
        int[] column = new int[sizeOfTheMatrix];
        for (int i = 0; i < sizeOfTheMatrix; i++) {
            column[i] = Integer.parseInt((matrix.get(i).get(columnNumber - 1)));
        }
        return column;
    }
}
