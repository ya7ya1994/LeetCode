package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ZigZagLevelOrderTraversal zt = new ZigZagLevelOrderTraversal();
        for (Integer a : zt.zigzagTraversal(root)) {
            System.out.print(a+" ");
        }


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

    public List<Integer> zigzagTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<Wrapper> nodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        nodes.add(new Wrapper(root, 0));
        while (!nodes.isEmpty()) {
            Wrapper current = nodes.poll();
            List<Integer> elements = new ArrayList<>();
            if (result.size() == current.level) {
                elements.add(current.node.val);
                result.add(elements);
            } else {
                elements = result.get(current.level);
                elements.add(current.node.val);
            }
            if (current.node.left != null) {
                nodes.add(new Wrapper(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {
                nodes.add(new Wrapper(current.node.right, current.level + 1));
            }
        }
        int index = 0;
        List<Integer> elements = new ArrayList<>();
        while (index < result.size()) {
            if ((index + 1) % 2 != 0) {
                for (int i = 0; i < result.get(index).size(); i++) {
                    elements.add(result.get(index).get(i));
                }
            } else {
                for (int i = result.get(index).size() - 1; i >= 0; i--) {
                    elements.add(result.get(index).get(i));
                }
            }
            index++;
        }

        return elements;
    }

}
