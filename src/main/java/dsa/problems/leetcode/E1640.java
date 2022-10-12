/*
 * Easy 1640: Check Array Formation Through Concatenation
 * Reference: https://leetcode.com/problems/check-array-formation-through-concatenation/
 */
package dsa.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class E1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        int arrIdx = 0;
        while (arrIdx < arr.length) {
            if (!map.containsKey(arr[arrIdx])) return false;
            int piecesOuterIdx = map.get(arr[arrIdx]);
            int piecesInnerIdx = 0;
            while (piecesInnerIdx < pieces[piecesOuterIdx].length) {
                if (arr[arrIdx] != pieces[piecesOuterIdx][piecesInnerIdx]) return false;
                piecesInnerIdx++;
                arrIdx++;
            }
        }
        return true;
    }
}
