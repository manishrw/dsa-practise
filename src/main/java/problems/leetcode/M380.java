package problems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class M380 {
    
    private List<Integer> list;
    private Map<Integer, Integer> map;
    Random rand;

    /** Initialize your data structure here. */
    public M380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isPresent = map.containsKey(val);
        if (!isPresent) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean isPresent = map.containsKey(val);
        if (isPresent) {
            int lastValIdx = list.size() - 1;
            int valIdx = map.get(val);
            int lastVal = list.get(lastValIdx);
            list.set(valIdx, lastVal);
            map.put(lastVal, valIdx);
            list.remove(lastValIdx);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
