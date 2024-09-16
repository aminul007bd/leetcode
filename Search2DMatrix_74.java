public class Search2DMatrix_74 {
/*    Example:
    int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
    };
    int target = 9;
    Initial state:
    rows = 3, cols = 3
    left = 0, right = 8 (since 3 * 3 - 1 = 8)
    First iteration:

    mid = (0 + 8) / 2 = 4
    row = 4 / 3 = 1, col = 4 % 3 = 1
    guess = matrix[1][1] = 9
    Since guess == target, the function returns true.
    Thus, the algorithm finds the target 9 in the matrix.

    Time Complexity: O(log(rows * cols)): This is equivalent to binary search on a flattened array of rows * cols size.
    Space Complexity: O(1): Only a constant amount of extra space is used.
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // Stores the number of columns in the matrix.
        int left = 0;
        int right = rows * cols - 1; //Right pointer starts at the last element of the "flattened" matrix.

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols; //Calculates the row of the matrix for the current mid index by dividing mid by the number of columns.
            int col = mid % cols; // Calculates the column of the matrix for the current mid index by taking the remainder when dividing mid by the number of columns.
            int guess = matrix[row][col]; // The value in the matrix at position (row, col), which corresponds to the current mid index.

            if (guess == target) {
                return true;
            } else if (guess < target) {
                left = mid + 1; // move the left pointer to mid + 1, as the target must be in the second half.
            } else {
                right = mid - 1; // as the target must be in the first half.
            }
        }

        return false;
    }
}
