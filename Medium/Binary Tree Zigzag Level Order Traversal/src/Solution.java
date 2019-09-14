
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        
        n1.left=n2;
        n1.right=n3;
        
        n2.left=n4;
        n2.right=n5;
        
        n3.left=n6;
        n3.right=n7;
        
        n6.left=n8;
        n6.right=n9;
        
        System.out.println("ZigZag Tree Level Order Traversal: ");
        
        printList(zigzagLevelOrder(n1));
    }
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        
        Queue<TreeNode> cola = new LinkedList();
        
        //This is to toggle the different behaviours
        int count=1;
        
        if(root!=null)
        {
            
            cola.offer(root);
            
            while(!cola.isEmpty())
            {
                
                List<Integer> currentList = new ArrayList();
                
                int size = cola.size();

                 for(int i=0;i<size;i++)
                 {
    
                    TreeNode current = cola.poll();
                        
                    currentList.add(current.val);
                        
                    if(current.right!=null)
                        cola.offer(current.right);
                        
                    if(current.left!=null)
                        cola.offer(current.left);

                 }
                
                if(count%2!=0)
                    Collections.reverse(currentList);
                
                result.add(currentList);
                
                count++;
                
            }
            
        }
        
        return result;
        
    }
    
    public static void printList(List<List<Integer>> lista)
    {
        for(List<Integer> temp : lista)
        {
            for(Integer el : temp)
            {
                System.out.print(el+" ");
            }
            System.out.println("");
        }
    }
    
}
