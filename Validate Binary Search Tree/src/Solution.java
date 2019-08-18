/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
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
       TreeNode head = new TreeNode(5);
       TreeNode n1 = new TreeNode(1);
       TreeNode n2 = new TreeNode(4);
       TreeNode n3 = new TreeNode(3);
       TreeNode n4 = new TreeNode(6);
       
       head.left=n1;
       head.right=n2;
       n2.left=n3;
       n2.right=n4;
       
       //isValidBSTOriginal(head);
       
       System.out.println("Is the tree a valid BST Tree?: "+isValidBST(head));
       
    }
    
    public static boolean isValidBST(TreeNode root) {
        
        return traverseTree(root,null,null);
    }
    
   
    public static boolean traverseTree(TreeNode current, Integer min,Integer max)
    {
        if(current==null)
        {    
            return true;
        }
        if((min!=null && current.val<=min) || (max!=null && current.val>=max))
        {
            return false;
        }
        if(!traverseTree(current.right,current.val,max) || !traverseTree(current.left,min,current.val))
        {
            return false;
        }
        return true;
    }
    
    public static boolean isValidBSTOriginal(TreeNode root) {
        
        return checkValidBST(root,true)!=null;
    }
    
    public static TreeNode checkValidBST(TreeNode current, boolean whichSide)
    {
        
        
        
        if(current==null)
        {
            return null;
        }
        else
        {
            System.out.println("current: "+current.val);
            TreeNode left = checkValidBST(current.left,true);
            
            TreeNode result;
            
            TreeNode right = checkValidBST(current.right,false);
            
            //One of the children threw an error
            if((left==null && current.left!=null) || (right==null && current.right!=null))
            {
                result=null;
            }
            else if(right!=null && left!=null) // There are two children
            {
                if(current.val>left.val && current.val<right.val)
                {
                    
                    if(whichSide==true)
                    {
                        result = left;
                    }
                    else
                    {
                        result=right;
                    }
                    
                }
                else
                {
                    result = null;
                }
            }
            else if(right!=null) //Only right children
            {
                
                if(current.val<right.val)
                {
                    if(whichSide==true)
                    {
                        result = current;
                    }
                    else
                    {
                        result=right;
                    }
                }
                else
                {
                    result = null;
                }
                
            }
            else if(left!=null)//Only left children
            {
                
                 if(current.val>left.val)
                {
                    if(whichSide==true)
                    {
                        result = left;
                    }
                    else
                    {
                        result=current;
                    }
                }
                else
                {
                    result = null;
                }
                
            }
            else //Both children are really null
            {
                result=current;
            }
            
             System.out.println("current: "+current.val+" - Result: "+result);
            
            return result;
            
        }
        
    }
    
    
}
