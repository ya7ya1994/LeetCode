package Leetcode.challenge.Algorithms;

public class InAndPreTreeBuild {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode builder(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preStart > preOrder.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preStart]);

        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inOrder[i] == root.val)
                index = i;
        }
        root.left = builder(preStart + 1, inStart, index - 1, preOrder, inOrder);
        root.right = builder(preStart + index - inStart + 1, index + 1, inEnd, preOrder, inOrder);
        return root;
    }
}

