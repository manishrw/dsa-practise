/*
 * Medium 49. Group Anagrams
 * Problem: https://leetcode.com/problems/group-anagrams/
 */
package dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<CharMap, List<String>>();
        for (var str :
                strs) {
            var charMap = new CharMap(str);
            map.computeIfAbsent(charMap, k -> new ArrayList<>());
            map.get(charMap).add(str);
        }
        return new ArrayList<>(map.values());
    }

    static class CharMap {
        int[] map = new int[26];

        public CharMap(String s) {
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
            }
        }

        @Override
        public boolean equals(Object obj ) {
            if (obj instanceof CharMap) {
                CharMap other = (CharMap) obj;
                for (int i = 0; i < 26; i++) {
                    if (map[i] != other.map[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            for (int i = 0; i < 26; i++) {
                hash += map[i] * (i + 1);
            }
            return hash;
        }
    }
}
