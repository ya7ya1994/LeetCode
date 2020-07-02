/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Cell {
        int level;
        TreeNode node;
        int nodeId;
        public Cell() {
            
        }
        public Cell(int level, TreeNode node, int nodeId) {
            this.level = level;
            this.node = node;
            this.nodeId = nodeId;
        }
        
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0, levelWidth = 0, start = 0;
        int cl = 0;
        Queue<Cell> nodes = new LinkedList<>();
        
        nodes.add(new Cell(0,root,1));
        
        while (!nodes.isEmpty()) {
            Cell current = nodes.poll();
            
            if(cl != current.level || nodes.isEmpty()) {
                levelWidth = levelWidth - start + 1;
                result = Math.max(result,levelWidth);
                levelWidth = 0;
                cl = current.level;
                start = 0;
            } 
            
            if (current.node == null) {
                continue;
            }
            
            if (start == 0) start = current.nodeId;
            
            nodes.add(new Cell(current.level+1,current.node.left,(current.nodeId*2) - 1));
            nodes.add(new Cell(current.level+1,current.node.right,(current.nodeId*2)));
            
            levelWidth = current.nodeId;
        }
        
        return result;
        
        
    }
    
    
}
