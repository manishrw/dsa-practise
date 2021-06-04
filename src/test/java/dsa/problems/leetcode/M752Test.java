package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;



class M752Test {
    M752 soln = new M752();

    @Test
    @Timeout(1)
    void test1() {
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int result = soln.openLock(deadends, target);
        assertEquals(6, result);
    }

    @Test
    void test2() {
        String[] deadends = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        int result = soln.openLock(deadends, target);
        assert result == -1;
    }

}