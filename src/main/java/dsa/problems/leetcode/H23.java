/*
 * Hard 23: https://leetcode.com/problems/merge-k-sorted-lists/
 */
package dsa.problems.leetcode;

import dsa.utils.ListNode;

import java.util.*;

public class H23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> listNodeComparator = Comparator.comparingInt(l -> l.val);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listNodeComparator);
        Arrays.stream(lists)
            .filter(l -> !Objects.isNull(l))
            .forEach(minHeap::add);
        ListNode head = null, current, prev = null;
        while (!minHeap.isEmpty()) {
            current = minHeap.poll();
            if (Objects.isNull(head)) head = current;
            if (!Objects.isNull(current.next)) {
                minHeap.add(current.next);
            }
            current.next = null;
            if (!Objects.isNull(prev)) {
                prev.next = current;
            }
            prev = current;
        }
        return head;
    }
}
