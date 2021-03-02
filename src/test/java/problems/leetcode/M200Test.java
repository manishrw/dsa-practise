package problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M200Test {

    private final M200 solution = new M200();

    @Test
    void testNumIslands() {
        char[][] grid = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int numIslands = solution.numIslands(grid);
        assertEquals(3, numIslands);
    }

    @Test
    void testNumIslands2() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int numIslands = solution.numIslands(grid);
        assertEquals(3, numIslands);
    }

    @Test
    void testNumIslandsWithEmptyGrid() {
        char[][] grid = new char[][] {};
        int numIslands = solution.numIslands(grid);
        assertEquals(0, numIslands);
    }
}