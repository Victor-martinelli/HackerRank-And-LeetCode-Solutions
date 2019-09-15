
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(12);
        TreeNode n5 = new TreeNode(10);
        TreeNode n6 = new TreeNode(14);
        TreeNode n7 = new TreeNode(22);
        
        n1.left=n2;
        n1.right=n7;
        
        n2.left=n3;
        n2.right=n4;
        
        n4.left=n5;
        n4.right=n6;
        
        System.out.println("Current Tree: ");
        nodesPrint(n1);
        
        System.out.println("The successor to the node "+n2.val+" is: "+getParentInOrder(n1,n2).val);
        
        System.out.println("The successor to the node "+n4.val+" is: "+getParentInOrder(n1,n4).val);
        
        System.out.println("The successor to the node "+n3.val+" is: "+getParentInOrder(n1,n3).val);
    }
    
    public static TreeNode getParentInOrder(TreeNode root, TreeNode p)
    {
        //If the current node has a right child, then the successor is the minimum in that branch
        
        TreeNode result=null;
        
        if(p.right!=null)
        {
            result = findMinNode(p.right);
        }
        else //If the current node has no right child, then the successor is the node's parent
        {
            
            //We look for the node's parent through the tree
            
            boolean finished=false;
            
            while(!finished && root!=null)
            {
                
                //If the current element is greater than the target, then the parent must be on the left side of the current node
                
                if(root.val>p.val)
                {
                    result=root;
                    root=root.left;
                }
                else if(root.val<p.val) //If the current element is smaller than the target, then the parent must be on the right side of the current node
                {
                    root=root.right;
                }
                else //We found the target node
                    finished=true;
                
            }
            
        }
        
        
        return result;
        
    }
    
    
    public static TreeNode findMinNode(TreeNode current)
    {
        
        while(current.left!=null)
            current=current.left;
        
        return current;
        
    }
    
    //O(n) --> n= number of nodes in the tree
    public static TreeNode getParentInOrderOne(TreeNode current,TreeNode target)
    {
        
        LinkedList<TreeNode> queue = new LinkedList();
        
        TreeNode result=null;
        
        //This indicates if we should return the current node as the result
        boolean nextIsSuccessor=false;
        
        boolean finished=false;
        
        while(!finished)
        {
            
            while(current!=null)
            {
                queue.offer(current);
                current=current.left;
            }
            
            current=queue.removeLast();
            
            //If we found the target element
            if(current.val==target.val)
            {
                nextIsSuccessor=true;
            }
            else if(nextIsSuccessor) //The current node is the successor
            {
                finished=true;
                result=new TreeNode(current.val);
            }
            
            current=current.right;
            
        }
        
        
        return result;
    }
    
    
    public static void nodesPrint(TreeNode current)
    {
        
        if(current!=null)
        {
            
            System.out.print(current.val+" ");
            
            nodesPrint(current.left);
            nodesPrint(current.right);
            
        }
        
    }
    
}
