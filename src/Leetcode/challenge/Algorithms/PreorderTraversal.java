package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if (root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;


        while (!stack.empty() || current != null) {
            while (current != null) {
                stack.push(current);
                returnList.add(current.val);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return returnList;
    }
}
