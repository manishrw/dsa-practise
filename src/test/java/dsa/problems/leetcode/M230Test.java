package dsa.problems.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class M230Test {

    M230 solution = new M230();

    @Test
    void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(1, solution.kthSmallest(root, 1));
    }

    @Test 
    void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        assertEquals(3, solution.kthSmallest(root, 3));
    }

    @Test
    void test3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.kthSmallest(root, 1));
    }
}
