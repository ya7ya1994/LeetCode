package Leetcode.challenge.Algorithms;

public class InandPostTreeBuild {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return builder(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }

    public TreeNode builder(int postEnd, int inStart, int inEnd, int[] postOrder, int[] inOrder) {
        if (postEnd < 0 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);

        int index = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == root.val)
                index = i;
        }
        root.left = builder(postEnd + index - 1 - inEnd, inStart, index - 1, postOrder, inOrder);
        root.right = builder(postEnd - 1, index + 1, inEnd, postOrder, inOrder);
        return root;
    }
}

