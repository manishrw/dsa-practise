package problems.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E53Test {
    E53 solution = new E53();

    @Test
    public void test1() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, solution.maxSubArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = {};
        assertEquals(0, solution.maxSubArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = {-1, -2, -3};
        assertEquals(-1, solution.maxSubArray(nums));
    }

    @Test
    public void test4() {
        int[] nums = {-3, -2, -1};
        assertEquals(-1, solution.maxSubArray(nums));
    }
}