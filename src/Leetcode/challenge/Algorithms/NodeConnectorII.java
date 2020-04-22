package Leetcode.challenge.Algorithms;

public class NodeConnectorII {
    public Node connect(Node root) {
        Node leftNode = root;
        while (leftNode != null) {
            connector(leftNode);
            if (leftNode.left != null)
                leftNode = leftNode.left;
            else
                leftNode = leftNode.right;
        }
        return root;
    }

    public void connector(Node leftNode) {
        Node move = leftNode;
        while (move != null) {

            if (move.left != null) {
                if (move.right != null) {
                    move.left.next = move.right;
                    if (move.next != null)
                        if (move.next.left != null)
                            move.right.next = move.next.left;
                        else
                            move.right.next = move.next.right;
                } else {
                    Node temp = move;
                    while (temp.next != null) {
                        if (temp.next.left != null) {
                            move.left.next = temp.next.left;
                            break;
                        } else if (temp.next.right != null)
                        {
                            move.left.next = temp.next.right;
                            break;
                        }
                        temp = temp.next;
                    }
                }
            } else if (move.right != null) {
                if (move.next != null && (move.next.right != null || move.next.left != null)) {
                    if (move.next.left != null)
                        move.right.next = move.next.left;
                    else
                        move.right.next = move.next.right;
                }
            }



            move = move.next;
        }
    }
}


