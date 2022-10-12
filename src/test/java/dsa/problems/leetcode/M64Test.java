package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M64Test {
    M64 solution = new M64();

    @Test
    public void test1() {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        assertEquals(7, solution.minPathSum(grid));
    }
}