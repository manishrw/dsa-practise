package dsa.utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                (left != null ? ", left=" + left : "") +
                (right != null ? ", right=" + right : "") +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof TreeNode) {
            TreeNode other = (TreeNode) obj;
            return this.val == other.val;
        }
        return false;
    }    
}