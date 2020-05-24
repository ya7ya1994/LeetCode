package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderTraversalOptimized {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.left.left = new TreeNode(12);
        root.left.right.left.right = new TreeNode(13);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(11);
        ZigZagLevelOrderTraversalOptimized zt = new ZigZagLevelOrderTraversalOptimized();
        zt.printZigzag(root);
    }

    class Wrapper {
        TreeNode node;
        int level;

        public Wrapper() {
        }

        public Wrapper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void printZigzag(TreeNode root) {
        /*List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }*/
        Stack<Wrapper> stack1 = new Stack<>();
        Stack<Wrapper> stack2 = new Stack<>();
        stack1.push(new Wrapper(root, 0));
        // Start by letting Stack 1 go first
        int thread = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // when stack1 is empty we switch to thread N1 and let stack 2 print all its elements while pushing it s children in stack1
            // and once stack2 goes empty we flip the switch and let stack 1 go so on and so forth.
            thread = switchThread(stack1, stack2, thread);
            Wrapper current = thread == 0 ? stack1.pop() : stack2.pop();
            if (current.level != 0 && current.level % 2 == 0 && thread == 0) {
                stack2.push(current);
            } else {
                /*List<Integer> elements = new ArrayList<>();
                if (results.size() == current.level) {
                    elements.add(current.node.val);
                    results.add(elements);
                } else {
                    elements = results.get(current.level);
                    elements.add(current.node.val);
                }*/
                System.out.println(current.node.val);
                if (current.node.left != null) {
                    stack1.push(new Wrapper(current.node.left, current.level + 1));
                }
                if (current.node.right != null) {
                    stack1.push(new Wrapper(current.node.right, current.level + 1));
                }
            }

        }
    }

    int switchThread(Stack<Wrapper> stack1, Stack<Wrapper> stack2, int thread) {
        if (stack1.isEmpty() && !stack2.isEmpty()) {
            return 1;
        } else if (!stack1.isEmpty() && stack2.isEmpty()) {
            return 0;
        }
        return thread;
    }
}
