/*
 * LeetCode Hard 149: https://leetcode.com/problems/max-points-on-a-line/
 */
package dsa.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class H149 {
    private boolean debug = false;

    public H149() {
    }

    public H149(final boolean debug) {
        this.debug = debug;
    }

    public int maxPoints(final int[][] points) {
        Map<Double, Integer> mCnt;
        double m = 0;
        int result = Math.min(2, points.length);
        for (int i = 0; i < points.length; i++) {
            mCnt = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                if (this.debug) System.out.print("[" + points[i][0] + "," + points[i][1] + "], [" + points[j][0] + "," + points[j][1] + "] : ");
                
                m = (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                if (mCnt.containsKey(m)) {
                    mCnt.put(m, mCnt.get(m) + 1);
                } else {
                    mCnt.put(m, 2);
                }
                result = result >= mCnt.get(m) ? result : mCnt.get(m);
                
                if (this.debug) System.out.println(m +  ", " + mCnt.get(m));
            }
        }
        return result;
    }
}