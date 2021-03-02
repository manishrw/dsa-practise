package problems.leetcode;

// import java.util.Collections;
import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.lang.Integer;

class M8 {
    private boolean debug = false;

    public M8() {
    }

    public M8(boolean debug) {
        this.debug = debug;
    }

    public int myAtoi(final String str) {
        final Deque<Integer> stack = new ArrayDeque<Integer>();
        int charValue = 0;
        boolean signCheck = true;
        boolean isNegative = false;
        boolean isLeadingZero = true;
        for (final char ch : str.trim().toCharArray()) {
            if (signCheck) {
                if (ch == '-' || ch == '+') {
                    isNegative = ch == '-' ? true : false;
                    signCheck = false;
                    continue;
                }
                signCheck = false;
            }
            charValue = (int) ch - 48;
            if (charValue < 0 || charValue > 9) {
                break;
            }
            if (charValue != 0 || !isLeadingZero)
            {
                stack.push(charValue);
                isLeadingZero = false;
            }
        }
        if (stack.isEmpty()) {return 0;}
        if (stack.size() > 10) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (this.debug) System.out.println(new ArrayList<Integer>(stack));
        long result = 0;
        long exponent = 1;
        while (stack.size() > 0) {
            result += stack.pop() * exponent;
            if (this.debug) System.out.println(result + "\t\t" + exponent);
            exponent *= 10;
            if (-result < Integer.MIN_VALUE && isNegative) return Integer.MIN_VALUE;
            if (result > Integer.MAX_VALUE && !isNegative) return Integer.MAX_VALUE;
        }
        if (isNegative) {
            result = -result;
            if (this.debug) System.out.println("isNeagtive: " + isNegative);
        }
        return (int) result;
    }
}