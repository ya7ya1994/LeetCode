package Leetcode.challenge.Algorithms;


public class ConstructStringFromBinaryTree {

    // Definition for a binary tree node.

    public class TreeNode {
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


    public String tree2str(TreeNode t) {

        return printPreorder(t);
    }

    public String printPreorder(TreeNode t) {
        StringBuilder result = new StringBuilder();
        if (t == null) {
            return result.toString();
        }

        /* first print data of node */
        result.append(String.valueOf(t.val));

        /* then recur on left subtree */
        if (t.left != null) {
            result.append("(");
            result.append(printPreorder(t.left));
            result.append(")");
        }
        /* add () for a null node*/
        if (t.left == null && t.right != null) {
            result.append("()");
        }
        /* now recur on right subtree */
        if (t.right != null) {
            result.append("(");
            result.append(printPreorder(t.right));
            result.append(")");
        }

        return result.toString();
    }
}

