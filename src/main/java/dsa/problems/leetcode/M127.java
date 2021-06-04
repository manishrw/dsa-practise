/*
* Leetcode M127: Word ladder
* Reference: https://leetcode.com/problems/word-ladder/
*/
package dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dsa.utils.Pair;

public class M127 {
    private boolean debug = false;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Remove duplicates and create vertex list
        Set<String> vertexSet = new HashSet<>(wordList);
        if (!vertexSet.contains(endWord))
            return 0;
        vertexSet.add(beginWord);
        List<String> vertex = new ArrayList<>(vertexSet);
        
        // Create edge matrix
        int n = vertex.size();
        boolean[][] edgeMatrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            edgeMatrix[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (isDistance1(vertex.get(i), vertex.get(j))) {
                    edgeMatrix[i][j] = true;
                    edgeMatrix[j][i] = true;
                }
            }
        }
        
        // Print graph using edge matrix
        if (debug) System.out.println(vertex);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(debug) System.out.print(edgeMatrix[i][j] ? "1 " : "0 ");
            }
            if(debug) System.out.println();
        }
        
        // Graph search to check if dst is reachable from src and find length
        // Get src and dst vertex
        int src = 0, dst = 0;
        for (int i = 0; i < n; i++) {
            if (vertex.get(i).equals(beginWord))
                src = i;
            if (vertex.get(i).equals(endWord))
                dst = i;
        }
        if(debug) System.out.println("Src: " + src + ", Dst: " + dst);
        
        // BFS to check the path
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new Pair<>(src, 1));
        visited.add(src);
        while (!queue.isEmpty()) {
            var p = queue.remove();
            int node = p.getKey();
            int len = p.getValue();
            if(debug) System.out.println("Node: " + node + ", Len: " + len);
            if (node == dst)
                return len;
            for (int i = 0; i < n; i++) {
                if (visited.contains(i) || i == node) continue;
                if (edgeMatrix[node][i]) {
                    queue.add(new Pair<>(i, len + 1));
                    visited.add(i);
                }
            }
        }
        return 0;
    }
    
    private boolean isDistance1(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length() && dist < 2; i++)
            if (a.charAt(i) != b.charAt(i))
                dist++;
        return dist <= 1;
    }
}