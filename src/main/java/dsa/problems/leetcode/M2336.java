/*
 * Medium 2336 - Smallest Number in Infinite Set
 * https://leetcode.com/problems/smallest-number-in-infinite-set/
 */
package dsa.problems.leetcode;

import java.util.TreeSet;

public class M2336 {
    private static final boolean DEBUG = false;
    TreeSet<Integer> minSet;
    int popCount;

    public M2336() {
        if (DEBUG) System.out.println(popCount);
        minSet = new TreeSet<>();
        popCount = 1;
    }

    public int popSmallest() {
        if (DEBUG) System.out.println("-> " + popCount + "\tHeap: " + minSet);
        if (!minSet.isEmpty()) {
            return minSet.pollFirst();
        }
        return popCount++;
    }

    public void addBack(int num) {
        if (DEBUG) System.out.println(popCount);
        if (num < popCount)
            minSet.add(num);
    }
}
