package dsa.problems.interviewbit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPathTest {

    private final ValidPath solution = new ValidPath(false);

    @Test
    void testNegativeCase() {
        int A = 2, B = 3, C = 1, D = 1;
        var E = Arrays.asList(2);
        var F = Arrays.asList(3);

        var result = solution.solve(A, B, C, D, E, F);

        assertEquals("NO", result);
    }

    @Test
    void testNegativeCase1() {
        int A = 3, B = 3, C = 2, D = 1;
        var E = Arrays.asList(2, 2);
        var F = Arrays.asList(2, 1);

        var result = solution.solve(A, B, C, D, E, F);

        assertEquals("NO", result);
    }

    @Test
    void testPositiveCase() {
        int A = 2, B = 3, C = 1, D = 1;
        var E = Arrays.asList(4);
        var F = Arrays.asList(4);

        var result = solution.solve(A, B, C, D, E, F);

        assertEquals("YES", result);
    }

    @Test
    void testPositiveCase1() {
        int A = 3, B = 3, C = 1, D = 1;
        var E = Arrays.asList(2);
        var F = Arrays.asList(1);

        var result = solution.solve(A, B, C, D, E, F);

        assertEquals("YES", result);
    }

    @Test
    void testPositiveCase2() {
        int A = 4, B = 3, C = 1, D = 1;
        var E = Arrays.asList(2);
        var F = Arrays.asList(1);

        var result = solution.solve(A, B, C, D, E, F);

        assertEquals("YES", result);
    }

    /*
        A : 58
        B : 91
        C : 6
        D : 8
        E : [ 40, 6, 36, 38, 23, 54 ]
        F : [ 88, 14, 50, 10, 15, 5 ]
    */
    @Test
    void testPositiveCase3() {
        int A = 58, B = 91, C = 6, D = 8;
        var E = Arrays.asList(40, 6, 36, 38, 23, 54);
        var F = Arrays.asList(88, 14, 50, 10, 15, 5);

        var result = solution.solve(A, B, C, D, E, F);

        assertEquals("YES", result);
    }
}