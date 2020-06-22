package problems.interviewbit;

import org.junit.Assert;
import org.junit.Test;

public class LCPTest {
    LCP solution = new LCP();

    @Test
    public void test_1() {
        String[] input = new String[] {"abcdefgh", "aefghijk", "abcefgh"};
        String result = solution.longestCommonPrefix(input);
        Assert.assertEquals("a", result);
    }

    @Test
    public void test_2() {
        String[] input = new String[] {"abab", "ab", "abcd"};
        String result = solution.longestCommonPrefix(input);
        Assert.assertEquals("ab", result);
    }

    @Test
    public void test_3() {
        String[] input = new String[] {"abcd", "abcd", "efgh"};
        String result = solution.longestCommonPrefix(input);
        Assert.assertEquals("", result);
    }
}