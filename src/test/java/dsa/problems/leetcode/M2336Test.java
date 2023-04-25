package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class M2336Test {

    @Test
    void test1() {
        M2336 m2336 = new M2336();
        assertEquals(1, m2336.popSmallest());
        assertEquals(2, m2336.popSmallest());
        m2336.addBack(1);
        assertEquals(1, m2336.popSmallest());
        assertEquals(3, m2336.popSmallest());
        assertEquals(4, m2336.popSmallest());
        m2336.addBack(2);
        m2336.addBack(3);
        assertEquals(2, m2336.popSmallest());
        assertEquals(3, m2336.popSmallest());
        assertEquals(5, m2336.popSmallest());
    }

}