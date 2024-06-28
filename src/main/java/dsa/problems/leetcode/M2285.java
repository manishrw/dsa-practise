/*
 * Medium Problem 2285. Maximum Total Importance of Roads
 * https://leetcode.com/problems/maximum-total-importance-of-roads/description/
 */
package dsa.problems.leetcode;

import dsa.utils.ArrayUtils;

public class M2285 {
    public long maximumImportance(int n, int[][] roads) {
        int[] roadCount = new int[n];
        for (int[] road : roads) {
            int ai = road[0];
            int bi = road[1];
            roadCount[ai]++;
            roadCount[bi]++;
        }
//        Arrays.sort(roadCount);
        roadCount = ArrayUtils.CountingSort(roadCount);

        long importance = 0;
        long value = 1;
        for (long cnt: roadCount) {
            importance += cnt * value;
            value++;
        }
        return importance;
    }
}
