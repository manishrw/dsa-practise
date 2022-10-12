package dsa.problems.leetcode;

public class M200 {
    private final boolean debug = false;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int numOfIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (debug) System.out.printf("Explore: [%d][%d], NumOfIslands: %d%n", i, j, numOfIslands + 1);
                    explore(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private void explore(char[][] grid, int i, int j) {
        if (debug) System.out.printf("\tExploring: [%d][%d]%n", i, j);
        grid[i][j] = '.';
        int n = grid.length;
        int m = grid[0].length;

        // visit north
        if (i > 0 && grid[i - 1][j] == '1') explore(grid, i - 1, j);
        // visit left
        if (j > 0 && grid[i][j - 1] == '1') explore(grid, i, j - 1);
        // visit south
        if (i < n - 1 && grid[i + 1][j] == '1') explore(grid, i + 1, j);
        // visit right
        if (j < m - 1 && grid[i][j + 1] == '1') explore(grid, i, j + 1);
    }
}