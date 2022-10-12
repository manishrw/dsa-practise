/*
* Medium 513 -  Find Bottom Left Tree Value
*/
package dsa.problems.leetcode;

import dsa.utils.Pair;

import java.util.*;

public class M513 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int distance = 0, minDistance = 0, maxDistance = 0;
        queue.add(new Pair<>(root, distance));
        map.putIfAbsent(distance, root.val);
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.removeFirst();
            TreeNode node = pair.getKey();
            distance = pair.getValue();
            if (node.left != null) {
                queue.add(new Pair<>(node.left, distance - 1));
                map.putIfAbsent(distance - 1, node.left.val);
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, distance + 1));
                map.putIfAbsent(distance + 1, node.right.val);
            }
            minDistance = Math.min(minDistance, distance);
            maxDistance = Math.max(maxDistance, distance);
        }

        List<Integer> list = new ArrayList<>();
        for (int key = minDistance; key <= maxDistance; key++) {
            if (map.containsKey(key)) {
                list.add(map.get(key));
            }
        }

        return list.get(0);
    }
}
