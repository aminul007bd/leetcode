/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/


import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // Initialize arrays of HashSets to keep track of numbers in each row, column, and 3x3 subgrid
            HashSet<Character>[] rows = new HashSet[9]; // Array to store sets for each row
            HashSet<Character>[] cols = new HashSet[9]; // Array to store sets for each column
            HashSet<Character>[] boxes = new HashSet[9]; // Array to store sets for each 3x3 subgrid

            for (int i = 0; i < 9; i++) {
                rows[i] = new HashSet<>(); // Initialize HashSet for row i
                cols[i] = new HashSet<>(); // Initialize HashSet for column i
                boxes[i] = new HashSet<>(); // Initialize HashSet for subgrid i
            }

            for (int r = 0; r < 9; r++) { // Loop over each row
                for (int c = 0; c < 9; c++) { // Loop over each column
                    if (board[r][c] == '.') { // Skip cells that are empty (denoted by '.')
                        continue; // Move to the next cell
                    }

                    char value = board[r][c];// Get the current number from the cell
                    int boxIndex = (r / 3) * 3 + (c / 3); // Calculate the index of the 3x3 subgrid where the current cell is located

                    if (rows[r].contains(value) || cols[c].contains(value) || boxes[boxIndex].contains(value)) { // Check if the current number already exists in the same row, column, or subgrid
                        return false; // Duplicate found, Sudoku is invalid
                    }

                    // Add the current number to the corresponding row, column, and subgrid sets
                    rows[r].add(value); // Add number to row set
                    cols[c].add(value); // Add number to column set
                    boxes[boxIndex].add(value); // Add number to subgrid set
                }
            }

            return true;  // If no duplicates are found, Sudoku is valid
        }
    }


    public boolean isValidSudoku1(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; ++i) { // Iterate through each cell in the 9x9 Sudoku board
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') { // Check if the current cell contains a number (not a dot)
                    String b = "(" + board[i][j] + ")";  // Create a string representation of the current number with parentheses

                    // Check if the number already exists in the same row, column, or subgrid
                    // "b + i" checks the number in the current row
                    // "j + b" checks the number in the current column
                    // "i / 3 + b + j / 3" checks the number in the current 3x3 subgrid
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3)) {
                        return false; // If any of these checks fail, a duplicate is found; return false
                    }
                }
            }
        }

        return true; // If no duplicates are found throughout the board, return true
    }

}
/*
Input: board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]

Iteration Steps
Cell (0, 0):

Value: 5
Check: b + i is "(5)0", j + b is "0(5)", i / 3 + b + j / 3 is "0(5)0".
Add to seen: "(5)0", "0(5)", "0(5)0".
Result: All added successfully.

Cell (0, 1):
Value: 3
Check: b + i is "(3)0", j + b is "1(3)", i / 3 + b + j / 3 is "0(3)0".
Add to seen: "(3)0", "1(3)", "0(3)0".
Result: All added successfully.

Cell (0, 4):
Value: 7
Check: b + i is "(7)0", j + b is "4(7)", i / 3 + b + j / 3 is "0(7)1".
Add to seen: "(7)0", "4(7)", "0(7)1".
Result: All added successfully.

Cell (1, 3):
Value: 1
Check: b + i is "(1)1", j + b is "3(1)", i / 3 + b + j / 3 is "0(1)1".
Add to seen: "(1)1", "3(1)", "0(1)1".
Result: All added successfully.

Cell (4, 4):
Value: 6
Check: b + i is "(6)4", j + b is "4(6)", i / 3 + b + j / 3 is "1(6)1".
Add to seen: "(6)4", "4(6)", "1(6)1".
Result: All added successfully.

Cell (8, 8):
Value: 9
Check: b + i is "(9)8", j + b is "8(9)", i / 3 + b + j / 3 is "2(9)2".
Add to seen: "(9)8", "8(9)", "2(9)2".
Result: All added successfully.

*/
