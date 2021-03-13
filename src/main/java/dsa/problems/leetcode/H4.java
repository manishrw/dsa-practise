package dsa.problems.leetcode;

public class H4 {
    public boolean debug = false;

    public H4() {}

    public H4(final boolean debug) {
        this.debug = debug;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1_len = nums1.length;
        int nums2_len = nums2.length;
        int nums3_len = nums1_len + nums2_len;
        int[] nums3 = new int[nums3_len];
        int nums1_idx = 0, nums2_idx = 0, nums3_idx = 0;

        while (nums1_idx < nums1_len && nums2_idx < nums2_len) { // merge nums1 and nums2
            if (nums1[nums1_idx] < nums2[nums2_idx]) {
                nums3[nums3_idx++] = nums1[nums1_idx++];
            } else {
                nums3[nums3_idx++] = nums2[nums2_idx++];
            }
        }
        if (nums1_idx == nums1_len) { // nums2 to be copied after nums1 is full
            while (nums2_idx < nums2_len) {
                nums3[nums3_idx++] = nums2[nums2_idx++];
            }
        } else { // nums1 to be copied after nums2 is full
            while (nums1_idx < nums1_len) {
                nums3[nums3_idx++] = nums1[nums1_idx++];
            }
        }

        int median_idx = nums3_len / 2;
        if (nums3_len % 2 == 0) { // len is even
            return ((double) nums3[median_idx] + nums3[median_idx - 1]) / 2;
        } else { // len is odd
            return (double) nums3[median_idx];
        }
    }

    public double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        int nums1_len = nums1.length;
        int nums2_len = nums2.length;
        int nums3_len = nums1_len + nums2_len;
        int median_idx = nums3_len / 2;
        int nums1_idx = nums1_len - 1, nums2_idx = nums2_len - 1;
        if (nums3_len % 2 == 0) { // total count is even
            while (nums1_idx + nums2_idx != median_idx) {
                if (nums1_idx + nums2_idx > median_idx) {
                    if (nums1[nums1_idx] < nums2[nums2_idx]) {
                        nums2_idx /= 2;
                    } else {
                        nums1_idx /= 2;
                    }
                } else {
                    if (nums1[nums1_idx] < nums2[nums2_idx]) {
                        nums1_idx *= 2;
                    } else {
                        nums2_idx *= 2;
                    }
                }
                if (this.debug) {
                    System.out.println(nums1_idx + " " + nums2_idx + " " + median_idx);
                }
            }
        } else { // total count is odd
        
        }
        return 0.0;
    }
}