/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
        Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
*/
public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        int n = board.length;  // Get the number of rows in the board (height).
        int m = board[0].length;  // Get the number of columns in the board (width).

        for (int i = 0; i < n; i++) {  // Iterate through each row.
            for (int j = 0; j < m; j++) {  // Iterate through each column.
                // If the current cell is on the boundary (first row, last row, first column, or last column)
                // and is 'O', we run a depth-first search (DFS) starting from this cell.
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);  // Mark all 'O's connected to this boundary cell.
                }
            }
        }

        // After DFS, we now iterate through the entire board.
        // We'll convert any remaining 'O' to 'X' (as they are surrounded by 'X'),
        // and any 'a' (which was temporarily used for marking during DFS) back to 'O'.
        for (int i = 0; i < n; i++) {  // Iterate through each row.
            for (int j = 0; j < m; j++) {  // Iterate through each column.
                if (board[i][j] == 'O') {  // If cell is 'O', it is surrounded, so convert to 'X'.
                    board[i][j] = 'X';
                } else if (board[i][j] == 'a') {  // If cell is 'a', it was connected to a boundary, so revert it back to 'O'.
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'a') { // Base case: if the current cell is out of bounds or is already 'X' or 'a', stop the DFS.
            return;
        }
        if (board[i][j] == 'O') {// If the current cell is 'O', mark it as 'a' to indicate it's visited and connected to the boundary.
            board[i][j] = 'a';
        }
        // Continue DFS in four directions: down, up, right, and left.
        dfs(board, i + 1, j);  // Move down.
        dfs(board, i - 1, j);  // Move up.
        dfs(board, i, j + 1);  // Move right.
        dfs(board, i, j - 1);  // Move left.
    }

}
