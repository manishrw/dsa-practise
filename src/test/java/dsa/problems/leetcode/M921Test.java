package dsa.problems.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class M921Test {

    private M921 solution;

    @BeforeEach
    void setUp() {
        solution = new M921();
    }

    @Test
    void testMinAddToMakeValid() {
        assert solution.minAddToMakeValid("())") == 1;
        assert solution.minAddToMakeValid("(((") == 3;
        assert solution.minAddToMakeValid("()") == 0;
        assert solution.minAddToMakeValid("()))((") == 4;
    }
}
