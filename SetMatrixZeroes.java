public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        // Reference
        // https://www.youtube.com/watch?v=TtQD176-uRM&ab_channel=NareshGupta
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // first col
        for(int i = 0; i< m ; i++)
            if(matrix[i][0] == 0) firstCol = true;

        // first row
        for (int j = 0; j < n; j++)
            if(matrix[0][j] == 0) firstRow = true;


        for(int i = 1; i< m; i++) {
            for(int j= 1; j< n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j< n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstCol)
            for (int i= 0; i< m; i++)
                matrix[i][0] = 0;

        if(firstRow)
            for(int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }

}
