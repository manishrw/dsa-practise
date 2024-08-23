/*
 * Problem: E339. Nested List Weight Sum
 * Link: https://leetcode.com/problems/nested-list-weight-sum/
 */
package dsa.problems.leetcode;

import java.util.List;

public class E339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int totalSum = 0;
        for (var nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                totalSum += nestedInteger.value * depth;
            } else {
                totalSum += depthSum(nestedInteger.list, depth + 1);
            }
        }
        return totalSum;
    }

    public static class NestedInteger {
        public int value;
        public List<NestedInteger> list;
        public boolean isInteger() {
            return list == null;
        }
        public NestedInteger(int value) {
            this.value = value;
        }
        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }
    }
}
