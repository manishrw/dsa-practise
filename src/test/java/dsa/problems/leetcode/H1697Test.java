package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class H1697Test {
    H1697 solution = new H1697();

    @Test
    void test1() {
        int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] queries = {{0,1,2},{0,2,5}};

        var actual = solution.distanceLimitedPathsExist(n, edgeList, queries);
        var expected = new boolean[]{false, true};
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int n = 5;
        int[][] edgeList = {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] queries = {{0,4,14}, {1,4,13}};

        var actual = solution.distanceLimitedPathsExist(n, edgeList, queries);
        var expected = new boolean[]{true, false};
        assertArrayEquals(expected, actual);
    }
}