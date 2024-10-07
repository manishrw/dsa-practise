/*
 * Problem: https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
package dsa.problems.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        for (var key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else {
                var heapMin = heap.peek();
                if (map.get(key) > map.get(heapMin)) {
                    heap.poll();
                    heap.add(key);
                }
            }
        }
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }
}
