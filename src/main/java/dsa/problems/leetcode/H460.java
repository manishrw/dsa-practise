/**
 * Leetcode Medium: 460 - LFU Cache.
 * Link - https://leetcode.com/problems/lfu-cache/
 */
package dsa.problems.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class H460 {

    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, Set<Integer>> lists;
    final int CAPACITY;
    int minCount;

    public H460(int capacity) {
        CAPACITY = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
        minCount = -1;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        int count = counts.get(key);
        lists.get(count).remove(key);
        if (count == minCount && lists.get(count).isEmpty()) {
            minCount++;
        }
        count++;
        counts.put(key, count);
        if (!lists.containsKey(count)) {
            lists.put(count, new LinkedHashSet<>());
        }
        lists.get(count).add(key);
        System.out.println(this);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (this.CAPACITY <= 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= this.CAPACITY) {
            var list = lists.get(minCount);
            int evictKey = list.iterator().next();
            list.remove(evictKey);
            vals.remove(evictKey);
            counts.remove(evictKey);
        }
        vals.put(key, value);
        counts.put(key, 1);
        lists.get(1).add(key);
        minCount = 1;

        System.out.println(this);
    }

    @Override
    public String toString() {
        return "H460{" +
                "vals=" + vals +
                ", counts=" + counts +
                ", lists=" + lists +
                ", CAPACITY=" + CAPACITY +
                ", minCount=" + minCount +
                "}";
    }
}
