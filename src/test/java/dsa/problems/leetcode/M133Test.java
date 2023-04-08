package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class M133Test {
    M133 solution = new M133();

    @Test
    void cloneGraph() {
        List<List<Integer>> adjList = List.of(
                List.of(2, 4),
                List.of(1, 3),
                List.of(2, 4),
                List.of(1, 3)
        );
        M133.Node node = createGraph(adjList);
        M133.Node clone = solution.cloneGraph(node);
        var visited = new HashSet<Integer>();
        visited.add(node.val);
        assert verifyClone(node, clone, visited);
    }

    @Test
    void cloneEmptyGraph() {
        assert  solution.cloneGraph(null) == null;
    }

    private boolean verifyClone(M133.Node node, M133.Node clone, Set<Integer> visited) {
        if (node.val != clone.val) return false;
        if (node.neighbors.size() != clone.neighbors.size()) return false;
        for (int i = 0; i < node.neighbors.size(); i++) {
            if (node.neighbors.get(i).val != clone.neighbors.get(i).val) return false;
            if (!visited.contains(node.neighbors.get(i).val)) {
                visited.add(node.neighbors.get(i).val);
                if (!verifyClone(node.neighbors.get(i), clone.neighbors.get(i), visited)) return false;
            }
        }
        return true;
    }

    private M133.Node createGraph(List<List<Integer>> adjList) {
        M133.Node[] nodes = new M133.Node[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            nodes[i] = new M133.Node(i);
        }
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                nodes[i].neighbors.add(nodes[adjList.get(i).get(j) - 1]);
            }
        }
        return nodes[0];
    }
}