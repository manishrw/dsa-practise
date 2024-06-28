package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class M2284Test {
    private final M2284 solution = new M2284();

    @Test
    public void test1() {
        String[] messages = {"hi", "hello", "world"};
        String[] senders = {"Bob", "Alice", "Bob"};
        assertEquals("Bob", solution.largestWordCount(messages, senders));
    }

    @Test
public void test2() {
        String[] messages = {"Hello user Two","Hi userThree","Wonderful day Alice","Nice day userThree"};
        String[] senders = {"Bob", "Alice", "Alice", "Bob"};
        assertEquals("Bob", solution.largestWordCount(messages, senders));
    }
}