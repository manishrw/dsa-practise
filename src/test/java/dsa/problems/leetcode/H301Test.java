package dsa.problems.leetcode;

import dsa.problems.leetcode.H301;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class H301Test {

    H301 solution;

    public H301Test() {
        this.solution = new H301();
    }

    @Test
    void removeInvalidParentheses() {
        String in = "()())()";
        List<String> out = solution.removeInvalidParentheses(in);
        assertEquals(2, out.size());
        assertTrue(out.contains("(())()"));
        assertTrue(out.contains("()()()"));

        in = "(a)())()";
        out = solution.removeInvalidParentheses(in);
        assertEquals(2, out.size());
        assertTrue(out.contains("(a())()"));
        assertTrue(out.contains("(a)()()"));

        in = ")(";
        out = solution.removeInvalidParentheses(in);
        assertEquals(   1, out.size());
        assertEquals("", out.get(0));
    }
}