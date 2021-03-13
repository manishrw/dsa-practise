package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M8Test 
{
    M8 solution = new M8();

    @Test
    public void testWithWords()
    {
        String s1 = "4193 with words";
        assertEquals(4193, solution.myAtoi(s1));
    }

    @Test
    public void testWithPlusMinus()
    {
        String s1 = "+-2";
        assertEquals(0, solution.myAtoi(s1));
    }

    @Test
    public void testWithExceedsIntMin()
    {
        String s1 = "-91283472332";
        assertEquals(Integer.MIN_VALUE, solution.myAtoi(s1));
    }

    @Test
    public void testWithExceedsIntMax()
    {
        String s1 = "9223372036854775808";
        assertEquals(Integer.MAX_VALUE, solution.myAtoi(s1));
    }

    @Test
    public void testWithIntMin()
    {
        String s1 = new Integer(Integer.MIN_VALUE).toString();
        assertEquals(Integer.MIN_VALUE, solution.myAtoi(s1));
    }

    @Test
    public void testWithIntMax()
    {
        String s1 = new Integer(Integer.MAX_VALUE).toString();
        assertEquals(Integer.MAX_VALUE, solution.myAtoi(s1));
    }

    @Test
    public void testWithMinusSignAtSecondPosition()
    {
        String s1 = "0-1";
        assertEquals(0, solution.myAtoi(s1));
    }

    @Test
    public void testWithLargeNumber()
    {
        String s1 = "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459";
        assertEquals(2147483647, solution.myAtoi(s1));
    }

    @Test
    public void testWithLeadingZeros()
    {
        String s1 = "  0000000000012345678";
        assertEquals(12345678, solution.myAtoi(s1));
    }
}
