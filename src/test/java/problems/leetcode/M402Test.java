package problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class M402Test {

    private final M402 solution = new M402();

    @Test
    void test1() {
        String  num = "1432219";
        int k = 3;
        String expected = "1219";
        String actual = solution.removeKDigits(num, k);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String  num = "10200";
        int k = 1;
        String expected = "200";
        String actual = solution.removeKDigits(num, k);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String  num = "10";
        int k = 2;
        String expected = "0";
        String actual = solution.removeKDigits(num, k);
        assertEquals(expected, actual);
    }

}