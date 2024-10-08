/*
 * Leetcode: 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

package dsa.problems.leetcode;

import dsa.utils.Pair;

import java.util.LinkedList;

public class M1091 {

    private final int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    private final int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return -1;
        }
        int m = grid[0].length;
        if (m == 0) {
            return -1;
        }
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        int[][] dp = new int[n][m];
        // dp[n - 1][m - 1] = -1;
        bfs(grid, dp, n, m);
        return dp[n - 1][m - 1] == 0 ? -1 : dp[n - 1][m - 1];
    }

    private void bfs(int[][] grid, int[][] dp, int n, int m) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        dp[0][0] = 1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            if (x == n - 1 && y == m - 1) {
                return;
            }

            // add all neighbours if they are valid
            for (int i = 0; i < dx.length; i++) {
                var x1 = x + dx[i];
                var y1 = y + dy[i];
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && grid[x1][y1] == 0) {
                    if (dp[x1][y1] == 0 || dp[x1][y1] > dp[x][y] + 1) {
                        dp[x1][y1] = dp[x][y] + 1;
                        queue.add(new Pair<>(x1, y1));
                    }
                }
            }
            grid[x][y] = 1;
        }
    }
}
