/*
 * Medium 1657. Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
package dsa.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M1657 {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        word1.chars().forEach(c -> map1.put((char) c, map1.getOrDefault((char) c, 0) + 1));
        word2.chars().forEach(c -> map2.put((char) c, map2.getOrDefault((char) c, 0) + 1));
        if (!map1.keySet().equals(map2.keySet())) return false;
        var freq1 = map1.values().stream().sorted().toArray();
        var freq2 = map2.values().stream().sorted().toArray();
        return Arrays.equals(freq1, freq2);
    }
}
