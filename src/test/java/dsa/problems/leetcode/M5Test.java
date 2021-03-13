package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M5Test {
    M5 solution = new M5();

    @Test
    public void test1()
    {
        String s1 = "bababd";
        assertEquals("babab", solution.longestPalindrome(s1));
    }

    @Test
    public void test2()
    {
        String s1 = "";
        assertEquals("", solution.longestPalindrome(s1));
    }

    @Test
    public void test3()
    {
        String s1 = "abc";
        assertEquals("a", solution.longestPalindrome(s1));
    }

    @Test
    public void test4()
    {
        String s1 = "bababddba";
        assertEquals("abddba", solution.longestPalindrome(s1));
    }

    @Test
    public void test5()
    {
        String s1 = "bababdasdba";
        assertEquals("babab", solution.longestPalindrome(s1));
    }

    @Test
    public void test6() {
        String s1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        assertEquals("ranynar", solution.longestPalindrome(s1));
    }
}