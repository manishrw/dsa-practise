/*
* Hard 51: N-Queens
* Reference: https://leetcode.com/problems/n-queens/
*/
package dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class H51 {
    private boolean debug = false;

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }
    
    private boolean backtrack(boolean[][] board, int row, List<List<String>> result) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            board[row][i] = true;
            if (debug) System.out.println("-> Trying Row: " + row + ", Col: " + i + ", Board: " + getBoard(board));
            if (isValidBoard(board)) {
                if (debug) System.out.println("Valid Row: " + row + ", Col: " + i);
                if (row == n - 1) { // last row
                    if (debug) printBoard(board);
                    result.add(getBoard(board));
                    board[row][i] = false;
                    return true;
                } else
                    backtrack(board, row + 1, result);
            }
            board[row][i] = false;
        }
        return false;
    }

    private void printBoard(boolean[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                if (board[i][j])
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println("]");
        }
        System.out.println();
    }
    
    private List<String> getBoard(boolean[][] board) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                if (board[i][j])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            result.add(sb.toString());
        }
        return result;
    }
    
    private boolean isValidBoard(boolean[][] board) {
        int cnt, n = board.length;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j])
                    cnt++;
                if (cnt > 1)
                    return false;
            }
            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (board[j][i])
                    cnt++;
                if (cnt > 1)
                    return false;
            }
            cnt = 0;
            if (debug) System.out.print("--> Checking ");
            for (int j = 0; j < n; j++) {
                if (debug) System.out.print("(" + j + "," + ((j + i) % n) + ") ");
                if (board[j][(j + i) % n])
                    cnt++;
                if (cnt > 1) {
                    if (debug) System.out.println(" NV");
                    return false;
                }
                if (((j + i) % n) == n - 1) {
                    if (debug) System.out.print("RST ");
                    cnt = 0;
                }
            }
            if (debug) System.out.println();
            cnt = 0;
            if (debug) System.out.print("--> Checking ");
            for (int j = 0; j < n; j++) {
                if (debug) System.out.print("(" + j + "," + ((n - 1 - i -j + n) % n) + ") ");
                if (board[j][(n - 1 - i -j + n) % n])
                    cnt++;
                if (cnt > 1) {
                    if (debug) System.out.println(" NV");
                    return false;
                }
                if ((n - 1 - i - j) % n == 0) {
                    if (debug) System.out.print("RST ");
                    cnt = 0;
                }
            }
            if (debug) System.out.println();
        }
        return true;
    }
}