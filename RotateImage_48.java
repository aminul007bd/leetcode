public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        // Reference https://www.youtube.com/watch?v=SA867FvqHrM&ab_channel=NickWhite
        int n = matrix.length;
        for(int i =0; i<n; i++){
            for(int j = i; i<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // Other option with while loop
        // https://www.youtube.com/watch?v=gCciKhaK2v8&ab_channel=FisherCoder
        for(int i = 0; i< n; i++) {
            int start = 0, end = n-1;
            while (start < end) {
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }


    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i< n; i++) {
            for(int j = i; j< n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
