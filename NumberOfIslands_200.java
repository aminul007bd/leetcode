/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
Output: 1
*/
public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0; // If the grid is null or empty, return 0 as there are no islands.

        int numIslands = 0; // Initialize the number of islands as 0.

        for (int i = 0; i < grid.length; i++) { // Iterate over every cell in the grid.
            for (int j = 0; j < grid[i].length; j++) { // If the current cell contains '1', it means it's part of an island.
                if (grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j); // Use DFS to mark the whole island as visited and increment the number of islands.
                }
            }
        }

        return numIslands; // Return the total number of islands found.
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') { // If the current cell is out of bounds or contains '0', stop the DFS search.
            return 0;
        }

        grid[i][j] = '0'; // Mark the current cell as visited by setting it to '0'.
        // Explore all four adjacent cells (up, down, left, right).
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left

        return 1; // Return 1 because this DFS call marks the whole island, counting it as one island.
    }
}
/*

Walkthrough Example
Consider the following grid:
grid = [  ['1', '1', '0', '0', '0'],
        ['1', '1', '0', '0', '0'],
        ['0', '0', '1', '0', '0'],
        ['0', '0', '0', '1', '1']
        ]

Here, '1' represents land, and '0' represents water. Our goal is to find how many distinct islands are present in this grid.

1. Initialization:
numIslands is initialized to 0.
We start iterating over the grid with two nested loops.

2. First Island:
At grid[0][0], we encounter '1', which indicates the start of an island. We call dfs(grid, 0, 0).
In the dfs function, the current cell grid[0][0] is marked as visited by setting it to '0',
and we proceed to explore its neighboring cells.

Moving down: dfs(grid, 1, 0) encounters '1', marks it as visited, and continues exploring.
Moving down again: dfs(grid, 2, 0) encounters '0', so it stops.
Moving up: dfs(grid, -1, 0) is out of bounds, so it stops.
Moving right: dfs(grid, 0, 1) encounters '1', marks it as visited, and continues exploring.
Moving right again: dfs(grid, 0, 2) encounters '0', so it stops.
Moving left and exploring all directions from each cell ensures the whole island is visited.
After exploring this entire connected region of '1's, the dfs returns 1 and we increment numIslands to 1.

3. Second Island:
Continue iterating. At grid[2][2], we find another '1', which indicates the start of a second island.
We call dfs(grid, 2, 2) and mark the whole island as visited (just this single cell).
After this, numIslands is incremented to 2.

4. Third Island:
At grid[3][3], we find '1', indicating the start of the third island. We call dfs(grid, 3, 3)
and mark the connected '1's at grid[3][4] as visited.
After this, numIslands is incremented to 3.

Final Output:
The iteration over the grid completes, and the total number of islands is 3.
*/
