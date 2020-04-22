package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelorderTraversal {
    
    
        public List<List<Integer>> levelOrderTraversal(TreeNode root) {
            List<List<Integer>> results= new ArrayList<>();
            if (root==null)
                return results;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty())
            {
                int size=queue.size();
                ArrayList<Integer> currentvalues=new ArrayList<Integer>();
                for(int i=0;i<size;i++)
                {
                    TreeNode current=queue.remove();
                    currentvalues.add(current.val);
                    if(current.left!=null)
                        queue.add(current.left);
                    if(current.right!=null)
                        queue.add(current.right);

                }
                results.add(currentvalues);
            }

            return results;
        }
    
}
