package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

public class E1640Test {
    E1640 solution = new E1640();

    @Test
    public void test1() {
        int[] arr = {85, 18};
        int[][] pieces = {{18}, {85}};
        assert solution.canFormArray(arr, pieces);
    }

    @Test
    public void test2() {
        int[] arr = {49,18,16};
        int[][] pieces = {{16,18,49}};
        assert !solution.canFormArray(arr, pieces);
    }

    @Test
    public void test3() {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        assert solution.canFormArray(arr, pieces);
    }
}
