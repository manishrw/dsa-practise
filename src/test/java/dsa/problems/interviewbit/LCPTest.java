package dsa.problems.interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCPTest {
    LCP solution = new LCP();

    @Test
    public void test_1() {
        String[] input = new String[] {"abcdefgh", "aefghijk", "abcefgh"};
        String result = solution.longestCommonPrefix(input);
        assertEquals("a", result);
    }

    @Test
    public void test_2() {
        String[] input = new String[] {"abab", "ab", "abcd"};
        String result = solution.longestCommonPrefix(input);
        assertEquals("ab", result);
    }

    @Test
    public void test_3() {
        String[] input = new String[] {"abcd", "abcd", "efgh"};
        String result = solution.longestCommonPrefix(input);
        assertEquals("", result);
    }
}