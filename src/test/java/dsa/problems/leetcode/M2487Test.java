package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static dsa.utils.ListNode.CreateList;

class M2487Test {
    M2487 solution = new M2487();

    @Test
    public void test1() {
        var head = CreateList(5, 2, 13, 3, 8);
        var expected = CreateList(13, 8);
        var actual = solution.removeNodes(head);
        assert Objects.equals(expected, actual);
    }

    @Test
    public void test2() {
        var head = CreateList(1, 1, 1, 1);
        var actual = solution.removeNodes(head);
        assert Objects.equals(actual, head);
    }
}