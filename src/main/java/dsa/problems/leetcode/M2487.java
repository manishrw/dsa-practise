/*
 * Medium 2487 : https://leetcode.com/problems/remove-nodes-from-linked-list/
 */
package dsa.problems.leetcode;

import dsa.utils.ListNode;

public class M2487 {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}
