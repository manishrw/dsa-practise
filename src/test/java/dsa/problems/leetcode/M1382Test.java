package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import dsa.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M1382Test {

    @Test
    void balanceBST() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode actual = new M1382().balanceBST(root);
        assertEquals(2, actual.val);
        assertEquals(1, actual.left.val);
        assertEquals(3, actual.right.val);
        assertEquals(4, actual.right.right.val);
    }

    @Test
    void balanceBST2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        TreeNode actual = new M1382().balanceBST(root);
        assertEquals(3, actual.val);
        assertEquals(1, actual.left.val);
        assertEquals(4, actual.right.val);
        assertEquals(2, actual.left.right.val);
        assertEquals(5, actual.right.right.val);
    }
}