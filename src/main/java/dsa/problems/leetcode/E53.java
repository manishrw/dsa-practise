/*
* Easy 53 - Maximum Subarray
*/
package dsa.problems.leetcode;

public class E53 {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSum = 0;
        boolean maxSumSet = false;
        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (!maxSumSet) {
                maxSum = currentSum;
                maxSumSet = true;
            }else if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}