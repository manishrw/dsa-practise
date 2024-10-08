package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

class M79Test {
    M79 solution = new M79();

    @Test
    public void test1() {
        char[][] board = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        var word = "ABCCED";
        assert solution.exist(board, word);
    }
    
    @Test
    public void test2() {
        char[][] board = {
            {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        var word = "ABCB";
        assert !solution.exist(board, word);
    }

    @Test
    public void test3() {
        char[][] board = {
                {'A','B'}
        };
        var word = "BA";
        assert solution.exist(board, word);
    }
}