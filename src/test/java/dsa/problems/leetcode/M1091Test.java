package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class M1091Test {
    M1091 instance = new M1091();

    @Test
    void test1() {
        int[][] grid = {
            {0, 1},
            {1, 0}
        };
        int expected = 2;
        int actual = instance.shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        int expected = 4;
        int actual = instance.shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 1}
        };
        int expected = -1;
        int actual = instance.shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[][] grid = {
                {0, 1, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        int expected = -1;
        int actual = instance.shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }

}