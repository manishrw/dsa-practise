/*
 * Leetcode 1697. Checking Existence of Edge Length Limited Paths
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 */
package dsa.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class H1697 {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        boolean[] result = new boolean[queries.length];

        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            Map<Integer, Integer> uMap = map.getOrDefault(u, new HashMap<>());
            Map<Integer, Integer> vMap = map.getOrDefault(v, new HashMap<>());

            uMap.put(v, Math.min(uMap.getOrDefault(v, Integer.MAX_VALUE), w));
            vMap.put(u, Math.min(vMap.getOrDefault(u, Integer.MAX_VALUE), w));

            map.put(u, uMap);
            map.put(v, vMap);
        }

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int limit = queries[i][2];

            if (u == v) {
                result[i] = true;
                continue;
            }

            if (!map.containsKey(u) || !map.containsKey(v)) {
                result[i] = false;
                continue;
            }

            boolean[] visited = new boolean[n];
            visited[u] = true;
            result[i] = dfs(u, v, limit, map, visited);
        }

        return result;
    }

    private boolean dfs(int u, int v, int limit, Map<Integer, Map<Integer, Integer>> map, boolean[] visited) {
        if (u == v) return true;
        if (!map.containsKey(u)) return false;
        var uMap = map.get(u);
        for (var entry : uMap.entrySet()) {
            int next = entry.getKey();
            int weight = entry.getValue();
            if (weight >= limit || visited[next]) continue;
            visited[next] = true;
            if (dfs(next, v, limit, map, visited)) return true;
        }
        return false;
    }
}
