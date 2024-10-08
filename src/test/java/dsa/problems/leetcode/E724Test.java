package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class E724Test {
    E724 solution = new E724();

    @Test
    public void test1() {
        int[][] nArray = new int[][] {
            { 8, 6 },
            { 1, 1 },
            { 4, -1},
            { 1000, -1}
        };
        Arrays.stream(nArray)
        .forEach(arr -> {
            int n = arr[0];
            int expected = arr[1];
            int pivot = solution.pivotInteger(n);
            // System.out.printf("Pivot for %d is %d%n", n, pivot);
            assert pivot == expected;
        });
    }
}