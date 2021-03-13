package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class H149Test {

    H149 solution = new H149();

    @Test
    public void test1() {
        int[][] points = {{1,1},{2,2},{3,3}};
        assertEquals(3, solution.maxPoints(points));
    }

    @Test
    public void test2() {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        assertEquals(4, solution.maxPoints(points));
    }

    @Test
    public void test3() {
        int[][] points = {{0,1}};
        assertEquals(1, solution.maxPoints(points));
    }

    @Test
    public void test4() {
        int[][] points = {};
        assertEquals(0, solution.maxPoints(points));
    }

    @Test
    public void test5() {
        int[][] points = {{0,0},{1,1},{0,0}};
        assertEquals(3, solution.maxPoints(points));
    }
}