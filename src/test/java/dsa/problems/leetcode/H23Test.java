package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Objects;

class H23Test {
    H23 solution = new H23();

    @Test
    public void Test1() {
        var listsAs2DArray = new int[][] {
                {1,4,5},
                {1,3,4},
                {2,6}
        };
        var lists = ConvertToListNodeArray(listsAs2DArray);
        var expected = new int[] {1,1,2,3,4,4,5,6};
        var output = solution.mergeKLists(lists);
        AssertH23Solution(expected, output);
    }

    @Test
    public void Test2() {
        var listAs2DArray = new int[][] {{}};
        var lists = ConvertToListNodeArray(listAs2DArray);
        var expected = new int[] {};
        var output = solution.mergeKLists(lists);
        AssertH23Solution(expected, output);
    }

    private void AssertH23Solution(int[] expected, H23.ListNode output) {
        int index = 0;
        while (output!= null && index < expected.length) {
            assert output.val == expected[index];
            output =  output.next;
            index++;
        }
        assert output == null;
        assert index == expected.length;
    }

    private H23.ListNode[] ConvertToListNodeArray(int[][] listsAs2DArray) {
        H23.ListNode[] listNodes = new H23.ListNode[listsAs2DArray.length];
        int index = 0;
        for (int[] list1D : listsAs2DArray) {
            listNodes[index++] = ConvertToListNode(list1D);
        }
        return listNodes;
    }

    private H23.ListNode ConvertToListNode(int[] list1D) {
        H23.ListNode head = null, current, prev = null;
        for (int num: list1D) {
            current = new H23.ListNode(num);
            if (Objects.isNull(head)) {
                head = current;
            }
            if (!Objects.isNull(prev)) {
                prev.next = current;
            }
            prev = current;
        }
        return head;
    }
}