/*
 * Easy 724 : https://leetcode.com/problems/find-pivot-index/
 */

package dsa.problems.leetcode;

public class E724 {
    public int pivotInteger(int n) {
        int ans = (n * n + n ) / 2;
        int sq = (int) Math.sqrt(ans);
        return (sq * sq == ans) ? sq : -1;
    }
}
