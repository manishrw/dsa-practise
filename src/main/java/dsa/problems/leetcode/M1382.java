/*
 * Medium Problem: https://leetcode.com/problems/balance-a-binary-search-tree/
 */
package dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class M1382 {
    public TreeNode balanceBST(TreeNode root) {
        // Preorder traversal
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        // Construct a balanced BST
        return constructBalancedBST(nodes, 0, nodes.size() - 1);
    }

    private TreeNode constructBalancedBST(List<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nodes.get(start));
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = constructBalancedBST(nodes, start, mid - 1);
        root.right = constructBalancedBST(nodes, mid + 1, end);
        return root;
    }

    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
