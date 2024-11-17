/**
 * Medium 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
package dsa.problems.leetcode;

import java.util.Arrays;

public class H329 {

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxPath = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(0, this.dfs(matrix, n, m, dp, i, j) + 1);
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int n, int m, int[][] dp, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxPath = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                maxPath = Math.max(maxPath, this.dfs(matrix, n, m, dp, x, y) + 1);
            }
        }
        return dp[i][j] = maxPath;
    }
}
