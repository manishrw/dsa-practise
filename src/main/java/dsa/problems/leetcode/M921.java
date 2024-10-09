/*
 * LeetCode: Medium 921. Minimum Add to Make Parentheses Valid
 * Url: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
package dsa.problems.leetcode;

public class M921 {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                close++;
            }
        }
        return open + close;
    }
}
