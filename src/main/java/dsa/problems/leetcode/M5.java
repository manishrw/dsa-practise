/*
    Medium 5 - Longest Palindromic Substring
*/
package dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

class M5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int len = s.length();
        char[] sArray = s.toCharArray();
        List<List<Integer>> DP = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                tmp.add(i == j ? 1 : 0);
            }
            DP.add(tmp);
        }

        DP.forEach((list) -> {
            list.forEach((i) -> {
                System.out.print(i + " ");
            });
            System.out.println();
        });

        int maxLP = 1;
        int maxI = 0, maxJ = 0;
        for(int w = 1; w < len; w++) {
            for (int idx = 0; idx < len - w; idx++) {
                int curLP = 0;
                if (sArray[idx] == sArray[idx + w]) {
                    int prevLP = w == 1 ? 0 : DP.get(idx + 1).get(idx + w - 1);
                    if (prevLP > 0 || w == 1) curLP = 2 + prevLP;
                    DP.get(idx).set(idx + w, curLP);
                }
                if (curLP > maxLP) {
                    maxLP = curLP;
                    maxI = idx;
                    maxJ = idx + w;
                }
            }
        }

        System.out.println();
        DP.forEach((list) -> {
            list.forEach((i) -> {
                System.out.print(i + " ");
            });
            System.out.println();
        });
        
        return s.substring(maxI, maxJ + 1);
    }
}