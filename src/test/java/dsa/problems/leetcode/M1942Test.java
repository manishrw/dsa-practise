package dsa.problems.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class M1942Test {

    private M1942 solution = new M1942();;

    @Test
    void testSmallestChair() {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;
        int expected = 1;

        int result = solution.smallestChair(times, targetFriend);
        assertEquals(expected, result);

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        targetFriend = 0;
        expected = 2;

        result = solution.smallestChair(times, targetFriend);
        assertEquals(expected, result);
    }

    @Test
    @Timeout(3)
    void testSmallestChairV2() {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;
        int expected = 1;

        int result = solution.smallestChairV2(times, targetFriend);
        assertEquals(expected, result);

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        targetFriend = 0;
        expected = 2;

        result = solution.smallestChairV2(times, targetFriend);
        assertEquals(expected, result);
    }
}
