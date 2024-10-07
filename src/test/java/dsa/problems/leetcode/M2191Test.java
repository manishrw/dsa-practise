package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class M2191Test {
    private final M2191 solution = new M2191();

    @Test
    @Timeout(3)
    public void test1() {
        int[] mapping = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] nums = {123, 456, 789};
        int[] expected = {123, 456, 789};
        assertArrayEquals(expected, solution.sortJumbled(mapping, nums));
    }

    @Test
    @Timeout(3)
    public void test2() {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};
        int[] expected = {338,38,991};
        assertArrayEquals(expected, solution.sortJumbled(mapping, nums));
    }

    @Test
    @Timeout(3)
    public void test3() {
        int[] mapping = {9,8,7,6,5,4,3,2,1,0};
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        int[] expected = {9,8,7,6,5,4,3,2,1,0};
        assertArrayEquals(expected, solution.sortJumbled(mapping, nums));
    }

}