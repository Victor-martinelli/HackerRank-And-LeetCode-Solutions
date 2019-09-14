
import java.util.LinkedList;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find 
the kth smallest frequently? How would you optimize the kthSmallest routine?

Time complexity : {O}(H + k), where H is a tree height. This complexity is 
defined by the stack, which contains at least H + k elements, since before 
starting to pop out one has to go down to a leaf. This results in O(logN+k) 
for the balanced tree and O(N+k) for completely unbalanced tree 
with all the nodes in the left subtree.

Space complexity : O(H+k), the same as for time complexity, O(N+k) 
in the worst case, and O(logN+k) in the average case.

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
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(17);
        TreeNode n8 = new TreeNode(10);
        TreeNode n9 = new TreeNode(20);
        
        n1.left=n2;
        n1.right=n6;
        
        n2.left=n3;
        n2.right=n5;
        
        n3.left=n4;
        
        n6.right=n7;
        
        n7.left=n8;
        n7.right=n9;
        
        System.out.println("Current Tree: ");
        
        nodesPrint(n1);
        
        System.out.println("");
        
        int test1=7;
        
        int test2 = 3;
        
        int test3 = 1;
        
        int test4=9;
        
        System.out.println("The "+test1+"th smallest element in the tree is: "+kthSmallest(n1,test1));
        
        System.out.println("The "+test2+"th smallest element in the tree is: "+kthSmallest(n1,test2));
        
        System.out.println("The "+test3+"th smallest element in the tree is: "+kthSmallest(n1,test3));
        
        System.out.println("The "+test4+"th smallest element in the tree is: "+kthSmallest(n1,test4));
        
    }
    
     public static int kthSmallest(TreeNode root, int k) {
       
        LinkedList<TreeNode> cola = new LinkedList();
        
        boolean finished=false;
        
        int result=0;
        
        while(!finished)
        {
            
            
            //We traverse throught the left leaf until the end
            while(root!=null)
            {
                cola.add(root);
                root=root.left;
            }
            
            //Once we are done, we remove the last element from the linked list
            //We decrement the k count since every time we are going through an
            //element of the tree
            root = cola.removeLast();
            
            k--;
            
            //If we have reached the desired node
            if(k==0)
            {
                finished=true;
                result=root.val;
            }
            root=root.right;
            
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
