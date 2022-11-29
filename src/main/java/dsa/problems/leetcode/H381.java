/*
 * Hard 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
package dsa.problems.leetcode;

import java.util.*;

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class H381 {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;

    public H381() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) return false;

        // Get the idx of val in the list to be removed
        var it = map.get(val).iterator();
        var valIdx = it.next();
        it.remove();

        // Swap the last element with the element to be removed
        var lastVal = list.get(list.size() - 1);
        list.set(valIdx, lastVal);
        map.get(lastVal).add(valIdx);
        map.get(lastVal).remove(list.size() - 1);

        // Remove the last element
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}