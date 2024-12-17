package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class H460Test {

    @Test
    public void test1() {
        H460 h460 = new H460(2);
        h460.put(1, 1);
        h460.put(2, 2);
        assertEquals(1, h460.get(1));
        h460.put(3, 3);
        assertEquals(-1, h460.get(2));
        assertEquals(3, h460.get(3));
        h460.put(4, 4);
        assertEquals(-1, h460.get(1));
        assertEquals(3, h460.get(3));
        h460.put(5,5);
        assertEquals(4, h460.get(-1));
    }

}