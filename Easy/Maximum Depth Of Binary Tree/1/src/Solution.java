/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7


return its depth = 3.
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
        TreeNode head = new TreeNode(3);
        
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        
        head.left=n1;
        head.right=n2;
        
        n2.left=n3;
        n2.right=n4;
        
        System.out.println("The max depth of the tree is: "+maxDepth(head));
        
    }
    
    
    public static int maxDepth(TreeNode root) {
        
        if(root == null)
            return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
    
    
      public int maxDepthOriginal(TreeNode root) {

        if(root!=null)
            return traverseTree(root,0);
        else
            return 0;
    }
    
    public int traverseTree(TreeNode current,int currentDepth)
    {
        
        //System.out.println("Current: "+current.val);
        
        currentDepth++;
        
        int result=0;
        
        int leftDepth=0;
        
        int rightDepth=0;
        
        if(current.left!=null)
        {
            leftDepth = traverseTree(current.left,currentDepth);
            
            //System.out.println("Current: "+current.val+" - Left: "+leftDepth);
        }
        
        if(current.right!=null)
        {
            rightDepth = traverseTree(current.right,currentDepth);
            
            //System.out.println("Current: "+current.val+" - Right: "+rightDepth);
        }
        
        if(leftDepth>rightDepth)
        {
            //System.out.println("Current: "+current.val+" - Left: "+leftDepth+" Greater than: "+rightDepth);
            result = leftDepth;
        }
        else if(rightDepth>leftDepth)
        {
            //System.out.println("Current: "+current.val+" - Left: "+leftDepth+" less than: "+rightDepth);
            result =  rightDepth;
        }
        else if(rightDepth==0 && leftDepth==0)
        {
            //System.out.println("Current: "+current.val+" - Returning current depth: "+currentDepth);
            result=currentDepth;
        }
        else 
            result=leftDepth;
        

        return result;
        
    }
    
}
