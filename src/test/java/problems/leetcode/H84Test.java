package problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class H84Test {
    H84 solution = new H84();

    @Test
    public void test1() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        assertEquals(10, solution.largestRectangleArea(heights));
    }

    @Test
    public void test2() {
        int[] heights = {1, 2, 3, 4, 5, 6};
        assertEquals(12, solution.largestRectangleArea(heights));
    }

    @Test
    public void test3() {
        int[] heights = {6, 0, 6};
        assertEquals(6, solution.largestRectangleArea(heights));
    }

    @Test
    public void test4() {
        int[] heights = {};
        assertEquals(0, solution.largestRectangleArea(heights));
    }
}