/*
 * Medium 133 - Clone Graph
 * https://leetcode.com/problems/clone-graph/
 */
package dsa.problems.leetcode;

import java.util.*;

public class M133 {
    Map<Node, Node> map = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map.computeIfAbsent(node, this::cloneNode);
        visited.add(node);
        node.neighbors
            .forEach(neighbor -> {
                map.computeIfAbsent(neighbor, this::cloneNode);
                map.get(node).neighbors.add(map.get(neighbor));
                if (!visited.contains(neighbor)) {
                    cloneGraph(neighbor);
                }
            });
        return map.get(node);
    }

    private Node cloneNode(Node node) {
        return new Node(node.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }
}
