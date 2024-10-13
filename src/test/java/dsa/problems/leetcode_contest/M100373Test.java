package dsa.problems.leetcode_contest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dsa.utils.TreeNode;

public class M100373Test {
    private M100373 solution = new M100373();

    @Test
    void testKthLargestPerfectSubtree() {
        // Build the tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(8);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);


        int k = 2;
        int expected = 3;

        int result = solution.kthLargestPerfectSubtree(root, k);
        assertEquals(expected, result);

        k = 3;
        expected = 1;

        result = solution.kthLargestPerfectSubtree(root, k);
        assertEquals(expected, result);
    }

}
