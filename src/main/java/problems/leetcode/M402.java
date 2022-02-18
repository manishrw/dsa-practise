/*
 * Medium 402 - Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 */

package problems.leetcode;

import java.util.Stack;

public class M402 {
    public String removeKDigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0";

        // Remove a digit which is greater than the previous digit using stack
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
            i++;
        }

        // Remove remaining digits for corner cases with same digits
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Convert stack to string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
