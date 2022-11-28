package dsa.utils;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " -> " + (Objects.isNull(this.next) ? "Null" : this.next.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public static ListNode CreateList(int... values) {
        ListNode head = null, current = null;
        for (int value : values) {
            if (Objects.isNull(head)) {
                head = new ListNode(value);
                current = head;
            } else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode[] CreateListNodeArray(int[][] values) {
        ListNode[] listNodes = new ListNode[values.length];
        int index = 0;
        for (int[] list1D : values) {
            listNodes[index++] = CreateList(list1D);
        }
        return listNodes;
    }
}

