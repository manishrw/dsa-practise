package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

public class H51Test {
    H51 solution = new H51();

    @Test
    public void testOdd() {
        int n = 4;
        System.out.println(solution.solveNQueens(n));
    }
}