package dsa.problems.leetcode;

import java.util.*;

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        HashMap<Integer, List<Integer>> sumIdx = new HashMap<Integer, List<Integer>>();
        List<Integer> tmp;
        List<Integer> tmpSumIdx;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (sumIdx.containsKey(-nums[j])) { // threeSum == 0
                    tmpSumIdx = sumIdx.get(-nums[j]);
                    // for (int idx = 0; idx < tmpSumIdx.size();) {
                    //     tmp = new ArrayList<Integer>(3);
                    //     tmp.add(nums[tmpSumIdx.get(idx)]);
                    //     tmp.add(nums[tmpSumIdx.get(idx + 1)]);
                    //     tmp.add(nums[j]);
                    //     Collections.sort(tmp);
                    //     result.add(tmp);
                    //     idx += 2;
                    // }
                    tmp = new ArrayList<Integer>(3);
                    tmp.add(nums[tmpSumIdx.get(0)]);
                    tmp.add(nums[tmpSumIdx.get(1)]);
                    tmp.add(nums[j]);
                    Collections.sort(tmp);
                    result.add(tmp);
                } else {
                    int sum = nums[i] + nums[j];
                    if (!sumIdx.containsKey(sum)) {
                        tmpSumIdx = new ArrayList<Integer>();
                        sumIdx.put(sum, tmpSumIdx);
                    } else {
                        // tmpSumIdx = sumIdx.get(sum);
                        continue;
                    }
                    tmpSumIdx.add(i);
                    tmpSumIdx.add(j);
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j]));
                }
            }
        }
        return result;
    }
}