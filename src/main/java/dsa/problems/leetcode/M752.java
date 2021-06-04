/*
* Medium 752 - Open locks
* https://leetcode.com/problems/open-the-lock/
*/
package dsa.problems.leetcode;

import java.util.*;
import java.util.function.Function;

public class M752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Function<Character, Character> incFunction = c -> Character.forDigit(((Character.getNumericValue(c) + 1) % 10), 10);
        Function<Character, Character> decFunction = c -> Character.forDigit(((Character.getNumericValue(c) + 9) % 10), 10);
        q.add("0000");
        visited.add("0000");
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String s = q.remove();
                if (dead.contains(s)) {
                    size--;
                    continue;
                }
                if (s.equals(target)) return level;

                char[] arr = s.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char c = arr[i];
                    arr[i] = incFunction.apply(c);
                    String s1 = String.valueOf(arr);
                    arr[i] = decFunction.apply(c);
                    String s2 = String.valueOf(arr);
                    arr[i] = c;

                    if (!visited.contains(s1) && !dead.contains(s1)) {
                        q.add(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !dead.contains(s2)) {
                        q.add(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
