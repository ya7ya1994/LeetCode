package Leetcode.challenge.Algorithms;

public class NodeConnector {


    public Node connect(Node root) {
        Node leftNode = root;
        while (leftNode != null && leftNode.left != null) {
            connector(leftNode);
            leftNode = leftNode.left;
        }
        return root;
    }

    public void connector(Node leftNode) {
        Node move = leftNode;
        while (move != null) {
            move.left.next = move.right;
            if (move.next != null)
                move.right.next = move.next.left;
            move = move.next;
        }
    }
}

