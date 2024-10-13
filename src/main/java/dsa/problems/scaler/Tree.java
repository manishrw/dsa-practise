package dsa.problems.scaler;


import java.util.HashMap;

import dsa.utils.TreeNode;

public class Tree {
    public TreeNode root;

    public static TreeNode BuildTree(int[] preorder, int[] inorder) {
        var inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return BuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode BuildTree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd, HashMap<Integer, Integer> inorderMap) {
        // Base Case
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        int rootInorderIndex = inorderMap.get(rootVal);
        int leftSubTreeSize = rootInorderIndex - inorderStart;
        int rightSubTreeSize = inorderEnd - rootInorderIndex;
        TreeNode root = new TreeNode(rootVal);
        if (leftSubTreeSize > 0) {
            root.left = BuildTree(preorder, inorder, preorderStart + 1, preorderStart + leftSubTreeSize, inorderStart, rootInorderIndex - 1, inorderMap);
        }
        if (rightSubTreeSize > 0) {
            root.right = BuildTree(preorder, inorder, preorderStart + leftSubTreeSize + 1, preorderEnd, rootInorderIndex + 1, inorderEnd, inorderMap);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {2,1,3};
        System.out.println(BuildTree(preorder, inorder));

        preorder = new int[]{1,2,4,5,3,6,7};
        inorder = new int[]{4,2,5,1,6,3,7};
        System.out.println(BuildTree(preorder, inorder));
    }
}
