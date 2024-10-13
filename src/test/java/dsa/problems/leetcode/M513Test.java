package dsa.problems.leetcode;

import dsa.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M513Test {

    private M513 solution = new M513();

    @Test
    void testPositiveCase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        var result = solution.findBottomLeftValue(root);
        assertEquals(4, result);
    }

    @Test
    void testNullRoot() {
        var result = solution.findBottomLeftValue(null);
        assertEquals(0, result);
    }
}