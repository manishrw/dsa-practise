package dsa.problems.leetcode;

import static java.util.stream.IntStream.range;

public class E1051 {
    public int heightChecker(int[] heights) {
        return range(0, heights.length)
                .filter(i -> heights[i] == i)
                .map(i -> 1)
                .sum();
    }
}
