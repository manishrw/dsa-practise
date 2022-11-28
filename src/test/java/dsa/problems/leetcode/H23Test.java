package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static dsa.utils.ListNode.CreateList;
import static dsa.utils.ListNode.CreateListNodeArray;

class H23Test {
    H23 solution = new H23();

    @Test
    public void Test1() {
        var listsAs2DArray = new int[][] {
                {1,4,5},
                {1,3,4},
                {2,6}
        };
        var lists = CreateListNodeArray(listsAs2DArray);
        var expected = CreateList(1,1,2,3,4,4,5,6);
        var actual = solution.mergeKLists(lists);
        assert Objects.equals(expected, actual);
    }

    @Test
    public void Test2() {
        var listAs2DArray = new int[][] {{}};
        var lists = CreateListNodeArray(listAs2DArray);
        var expected = CreateList();
        var actual = solution.mergeKLists(lists);
        assert Objects.equals(expected, actual);
    }
}