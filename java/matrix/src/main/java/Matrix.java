class Matrix {

    int[][]  matrix;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        matrix = new int[rows.length][rows[0].split(" ").length];

        for(int i =0 ; i<rows.length;i++){
            String[] columns = rows[i].split(" ");
            for(int j =0 ; j<columns.length ; j++){
                matrix[i][j] = Integer.parseInt(columns[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber-1];
    }

    int[] getColumn(int columnNumber) {
        int[] requiredColumn = new int[matrix.length];
        for(int i = 0 ; i<matrix.length ; i++){
            requiredColumn[i] = matrix[i][columnNumber-1];
        }
        return requiredColumn;
    }
}
