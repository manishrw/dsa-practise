package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class M15Test {

    @Test
    void threeSumTest1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        var actual = new M15().threeSum(nums);
        var expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void threeSumTest2() {
        int[] nums = {0, 1, 1};
        var actual = new M15().threeSum(nums);
        var expected = new int[][]{};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void threeSumTest3() {
        int[] nums = {0, 0, 0};
        var actual = new M15().threeSum(nums);
        var expected = List.of(
                Arrays.asList(0, 0, 0)
        );
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}