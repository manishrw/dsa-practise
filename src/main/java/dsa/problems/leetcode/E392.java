/*
 * Easy 392 - Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */
package dsa.problems.leetcode;

public class E392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int sIdx = 0, tIdx = 0;
        while (sIdx < sLength && tIdx < tLength) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
                tIdx++;
            } else {
                tIdx++;
            }
        }
        return sIdx == sLength;
    }
}
