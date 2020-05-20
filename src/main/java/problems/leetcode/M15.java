package problems.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        HashMap<Integer, List<Integer>> sumIdx = new HashMap<Integer, List<Integer>>();
        List<Integer> tmp;
        List<Integer> tmpSumIdx;
        for (int i = 0; i < nums.length; i++) {
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
}