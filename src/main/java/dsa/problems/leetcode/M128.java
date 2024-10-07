/*
 * Medium 128. Longest Consecutive Sequence
 * Problem: https://leetcode.com/problems/longest-consecutive-sequence/
 */
package dsa.problems.leetcode;

import java.util.HashMap;

public class M128 {
    public int longestConsecutive(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int count = 1;
                int num = nums[i];
                while (map.containsKey(num + 1)) {
                    count++;
                    visited[map.get(num + 1)] = true;
                    num++;
                }
                num = nums[i];
                while (map.containsKey(num - 1)) {
                    count++;
                    visited[map.get(num - 1)] = true;
                    num--;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
