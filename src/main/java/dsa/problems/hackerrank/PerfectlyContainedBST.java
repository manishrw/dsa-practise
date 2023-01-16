/*
 Problem: A list of BSTNode objects is called a perfectly contained BST if the following conditions are met:
    1. The nodes in the list belong to one and only one BST.
    2. All nodes in the list belong to the same BST.
    3. All nodes in the BST belong to the list.

    Implement the function findRoot, that given a list of BSTNode objects,
    returns the root value of the BST if the list is perfectly contained, otherwise returns -1.
 */
package dsa.problems.hackerrank;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class PerfectlyContainedBST {
    public static int findRoot(List<List<Integer>> nodes) {
        var nodeMap = new HashMap<Integer, List<Integer>>();
        var parentMap = new HashMap<Integer, Integer>();
        var invalid = new AtomicBoolean(false);
        nodes.forEach(node -> {
            var value = node.get(0);
            var left = node.get(1);
            var right = node.get(2);
            if (left != -1) {
                if (parentMap.containsKey(left)) {
                    invalid.set(true);
                    return;
                }
                parentMap.put(left, value);
            }
            if (right != -1) {
                if (parentMap.containsKey(right)) {
                    invalid.set(true);
                    return;
                }
                parentMap.put(right, value);
            }
            nodeMap.put(value, node);
        });
        if (invalid.get()) return -1;

        // Check all nodes are in the same tree
        var roots = nodes.stream()
            .map(node -> {
                var value = node.get(0);
                var left = node.get(1);
                var right = node.get(2);
                if (left != -1 && !nodeMap.containsKey(left) ||
                    right != -1 && !nodeMap.containsKey(right)) {
                    return -1;
                }
                return findRoot(value, parentMap);
            }).collect(Collectors.toSet());

        if (roots.contains(-1) || roots.size() != 1) return -1;
        return roots.iterator().next();
    }

    private static int findRoot(int value, Map<Integer, Integer> parentMap) {
        while (parentMap.containsKey(value)) {
            value = parentMap.get(value);
        }
        return value;
    }
}
