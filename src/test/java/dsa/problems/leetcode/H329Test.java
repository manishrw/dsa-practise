package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class H329Test {
    @Test
    void longestIncreasingPath() {
        H329 solution = new H329();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        assertEquals(4, solution.longestIncreasingPath(matrix));
    }

    @Test
    void longestIncreasingPath2() {
        H329 solution = new H329();
        int[][] matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        assertEquals(4, solution.longestIncreasingPath(matrix));
    }
}