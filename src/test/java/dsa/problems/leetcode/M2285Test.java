package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class M2285Test {
    private final M2285 solution = new M2285();

    @Test
    public void test1() {
        int n = 5;
        int[][] roads = {{1, 3}, {4, 2}, {3, 0}};
        assertEquals(20, solution.maximumImportance(n, roads));
    }

    @Test
    public void test2() {
        int n = 6;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        assertEquals(39, solution.maximumImportance(n, roads));
    }

    @Test
    public void test3() {
        int n = 5;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        assertEquals(43, solution.maximumImportance(n, roads));
    }
}