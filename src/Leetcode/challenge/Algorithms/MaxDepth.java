package Leetcode.challenge.Algorithms;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        int right_depth=maxDepth(root.right);
        int left_depth=maxDepth(root.left);
        return Math.max(right_depth,left_depth)+1;
    }
}
