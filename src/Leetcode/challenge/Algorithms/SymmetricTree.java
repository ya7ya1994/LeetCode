package Leetcode.challenge.Algorithms;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        else
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

