package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M1382Test {

    @Test
    void balanceBST() {
        M1382.TreeNode root = new M1382.TreeNode(1);
        root.right = new M1382.TreeNode(2);
        root.right.right = new M1382.TreeNode(3);
        root.right.right.right = new M1382.TreeNode(4);
        M1382.TreeNode actual = new M1382().balanceBST(root);
        assertEquals(2, actual.val);
        assertEquals(1, actual.left.val);
        assertEquals(3, actual.right.val);
        assertEquals(4, actual.right.right.val);
    }

    @Test
    void balanceBST2() {
        M1382.TreeNode root = new M1382.TreeNode(1);
        root.right = new M1382.TreeNode(2);
        root.right.right = new M1382.TreeNode(3);
        root.right.right.right = new M1382.TreeNode(4);
        root.right.right.right.right = new M1382.TreeNode(5);
        M1382.TreeNode actual = new M1382().balanceBST(root);
        assertEquals(3, actual.val);
        assertEquals(1, actual.left.val);
        assertEquals(4, actual.right.val);
        assertEquals(2, actual.left.right.val);
        assertEquals(5, actual.right.right.val);
    }
}