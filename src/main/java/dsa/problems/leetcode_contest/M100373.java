package dsa.problems.leetcode_contest;

import java.util.ArrayList;
import java.util.List;
import dsa.utils.Pair;
import dsa.utils.TreeNode;

public class M100373 {
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        list.sort((a, b) -> b - a);
        System.out.println(list);
        return list.get(k - 1);
    }

    private Pair<Integer, Boolean> helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return new Pair<Integer,Boolean>(0, true);
        }

        if (root.left == null && root.right == null) {
            list.add(1);
            return new Pair<Integer,Boolean>(1, true);
        }

        var left = helper(root.left, list);
        var right = helper(root.right, list);

        boolean isLeftBalanced = left.getRight();
        boolean isRightBalanced = right.getRight();
        int leftHeight = left.getLeft();
        int rightHeight = right.getLeft();
        var isBalanced = isLeftBalanced && isRightBalanced && leftHeight == rightHeight;
        if (isBalanced) {
            var height = leftHeight * 2 + 1;
            list.add(height);
            return new Pair<Integer,Boolean>(height, true);
        }

        return new Pair<Integer,Boolean>(0, false);
    }
}
