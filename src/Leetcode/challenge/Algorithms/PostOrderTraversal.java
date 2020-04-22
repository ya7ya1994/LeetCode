package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if (root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.pop();
            returnList.add(0, current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }

        }
        return returnList;
    }


}
