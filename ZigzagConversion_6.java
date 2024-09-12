import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion_6 {

/*    Example with s = "PAYPALISHIRING" and numRows = 3:

    Initially: idx = 0, d = 1
    Add P to rows[0]
    Move down: idx = 1, add A to rows[1]
    Move down: idx = 2, add Y to rows[2]
    Move up: idx = 1, add P to rows[1]
    Move up: idx = 0, add A to rows[0]

    rows[0] = ['P', 'A', 'H', 'N']
    rows[1] = ['A', 'P', 'L', 'S', 'I', 'I', 'G']
    rows[2] = ['Y', 'I', 'R']
    */

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) { // Base case: If there's only one row or the number of rows is greater than or equal to the string length,
            return s;// there's no zigzagging, so we can return the string as is.
        }

        int idx = 0; //  is used to track the current row index where the character will be placed.
        int d = 1; //  is used to control the direction of traversal (1 for downwards, -1 for upwards).
        List<Character>[] rows = new ArrayList[numRows]; // Create an array of lists where each list will represent a row in the zigzag pattern.
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>(); // when numRows = 3 then rows[0] = [] rows[1] = [] rows[2] = []
        }

        for (char c : s.toCharArray()) {
            rows[idx].add(c); // Add the current character to the current row.
            if (idx == 0) {  // When we reach the top row (idx == 0), we need to move down, so set direction `d = 1`.
                d = 1;
            } else if (idx == numRows - 1) { // When we reach the bottom row (idx == numRows - 1), we need to move up, so set direction `d = -1`.
                d = -1;
            }
            idx += d; // Move to the next row according to the direction `d`.
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();
    }

}
