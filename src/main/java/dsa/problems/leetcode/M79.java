/*
 * Medium 79. Word Search
 * https://leetcode.com/problems/word-search/
 */
package dsa.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

public class M79 {
    private static final boolean DEBUG_MODE = false;
    private static final int[][] DELTA = new int[][] {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        Set<Integer> visited = new HashSet<>();
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (DEBUG_MODE) System.out.println("\nStarting from " + i + ", " + j);
                if (exist(board, i, j, visited, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, Set<Integer> visited, String word, int wordIdx) {
        int n = board.length, m = board[0].length;
        visited.add(x * m + y);
        var subWord = word.substring(0, wordIdx + 1);
        if (DEBUG_MODE) System.out.println("Substring word: " + subWord + " ; Idx: " + wordIdx + " ; Char: " + board[x][y]);

        if (wordIdx == word.length() - 1) {
            if (word.charAt(wordIdx) == board[x][y]) {
                return true;
            } else {
                visited.remove(x * m + y);
                return false;
            }
        }
        if (word.charAt(wordIdx) != board[x][y]) {
            visited.remove(x * m + y);
            return false;
        }

        for (int[] ints : DELTA) {
            int dx = ints[0], dy = ints[1];
            int x1 = x + dx;
            int y1 = y + dy;
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m) if (DEBUG_MODE) System.out.println("-> " + x1 + ", " + y1);
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && !visited.contains(x1 * m + y1) && exist(board, x1, y1, visited, word, wordIdx + 1))
                return true;
        }
        visited.remove(x * m + y);
        return false;
    }
}
