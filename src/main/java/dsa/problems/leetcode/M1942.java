/*
 * Leetcode Medium: 1942. The Number of the Smallest Unoccupied Chair
 * https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
 */

package dsa.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class M1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] time : times) {
            while (!occupied.isEmpty() && occupied.peek()[1] <= time[0]) {
                available.offer(occupied.poll()[0]);
            }
            if (time[0] == targetArrival) break;
            occupied.offer(new int[]{available.poll(), time[1]});
        }
        return available.poll();
    }

    public int smallestChairV2(int[][] times, int targetFriend) {
        int n = times.length;
        int targetArrival = times[targetFriend][0];
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        TreeMap<TimeStatus, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(new TimeStatus(times[i][0], true), i);
            map.put(new TimeStatus(times[i][1], false), i);
        }

        Map<Integer, Integer> occupied = new HashMap<>();
        for (var entry : map.entrySet()) {
            TimeStatus timeStatus = entry.getKey();
            int friend = entry.getValue();
            if (timeStatus.isArrival) {
                int chair = available.poll();
                if (times[friend][0] == targetArrival) return chair;
                occupied.put(friend, chair);
            } else {
                available.offer(occupied.remove(friend));
            }
        }

        return 0;
    }

    class TimeStatus implements Comparable<TimeStatus> {
        int time;
        boolean isArrival;

        public TimeStatus(int time, boolean isArrival) {
            this.time = time;
            this.isArrival = isArrival;
        }

        @Override
        public int hashCode() {
            // Use a prime number and combine fields for a good hash code distribution
            int result = Integer.hashCode(time);
            result = 31 * result + Boolean.hashCode(isArrival);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TimeStatus that = (TimeStatus) obj;
            return this.time == that.time && this.isArrival == that.isArrival;
        }

        @Override
        public int compareTo(TimeStatus that) {
            if (this.time != that.time) return this.time - that.time;
            return this.isArrival ? -1 : 1;
        }
    }
}