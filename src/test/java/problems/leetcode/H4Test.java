package problems.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class H4Test {
    H4 solution = new H4();

    @Test
    public void testOdd() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), 0.001);
    }

    @Test
    public void testEven() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        solution.findMedianSortedArraysOptimized(nums1, nums2);
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.001);
    }
}