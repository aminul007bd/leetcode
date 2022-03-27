import java.util.*;

public class PacificAtlanticWaterFlow_417 {
    private static final int[][] DIRECTIONS = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    private int numRows, numCols;
    private int[][] landHeights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // check if input is empty
        if(heights.length == null || heights[0].length == null){
            return new ArrayList<>();
        }

        // save initial values to parameters
        numRows = heights.length;
        numCols = heights[0].length;
        landHeights = heights;

        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];

        // Loop through each cell adjacent to the oceans and start a DFS
        for(int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, numCols - 1, atlanticReachable);
        }

        for(int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(numRows - 1, i, atlanticReachable);
        }

        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }

    public void dfs(int row, int col, boolean[][] reachable) {
        // This cell is reachable, so mark it
        reachable[row][col] = true;
        for(int[] dir: DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            //Check if new cell is within bounds
            if ( newRow < 0 || newRow >= newRow || newCol < 0 || newCol >= newCol) {
                continue;
            }
            // Check that the new cell hasn't already been visited
            if(reachable[newRow][newCol]) continue;

            // Check that the new cell has a higher or equal height
            if(landHeights[newRow][newCol] < landHeights[row][col]) continue;

            dfs(newRow, newCol, reachable);
        }


    }
}
