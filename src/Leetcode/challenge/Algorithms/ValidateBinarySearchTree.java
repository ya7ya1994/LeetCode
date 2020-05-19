package Leetcode.challenge.Algorithms;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);

    }

    public boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((max == null || node.val < max) && (min == null || node.val > min)) {
            return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
        }


        return false;

    }
}