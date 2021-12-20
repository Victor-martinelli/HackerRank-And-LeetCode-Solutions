/*
 * You are given a perfect binary tree where all leaves are on the same level, 
and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        
        n1.left=n2;
        n1.right=n3;
        
        n2.left=n4;
        n2.right=n5;
        
        n3.left=n6;
        n3.right=n7;
        
        
        nodesPrint(connect(n1));
    }
    
      public static Node connect(Node root) {
        
          //We first go through the tree Horizontaly (nodes in the same level)
          //Once we reach the end, then we go to the next level
          
        Node start = root;
        while(start!=null)
        {
            
            Node current = start;
            while(current!=null)
            {
                
                if(current.left!=null)
                    current.left.next=current.right;
                
                if(current.right!=null && current.next!=null)
                    current.right.next=current.next.left;
                
                current=current.next;
                
            }
            
            start=start.left;
            
        }
        
        return root;
        
    }
      
    public static void nodesPrint(Node current)
    {
        
        if(current!=null)
        {
            
            System.out.print("Node value: "+current.val+" ");
            
            if(current.next!=null)
                System.out.println("Next Node value: "+current.next.val);
            else
                System.out.println("Next Node value: NULL");
            
            nodesPrint(current.left);
            nodesPrint(current.right);
            
        }
        
    }
    
}
