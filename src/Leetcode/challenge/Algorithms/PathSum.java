package Leetcode.challenge.Algorithms;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        else if( root.right==null && root.left==null && sum==root.val )
            return true;
        else
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
