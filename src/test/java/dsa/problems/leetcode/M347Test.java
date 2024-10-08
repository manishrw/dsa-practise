package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class M347Test {

    @Test
    void topKFrequent() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1,2};
        int[] actual = new M347().topKFrequent(nums, k);
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
    }
}