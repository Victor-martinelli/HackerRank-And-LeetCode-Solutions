
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        
        root.left=n1;
        root.right=n2;
        
        n1.left=n3;
        n1.right=n4;
        
        n2.left=n5;
        
        System.out.print("Result of traversing a binary tree inorder: ");
        
        printResult(inorderTraversal(root));
        
    }
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        
        Stack<TreeNode> pila = new Stack();
        
        TreeNode current = root;
        
        while(current!=null || !pila.empty())
        {
            
            //If its not null, we store it in the stack and go to its left child
            while(current!=null)
            {
                pila.push(current);
                current=current.left;
            }
            
            //If its null, we pop the node from the stack, store its value in the solution and go to it's right child
            current = pila.pop();
            result.add(current.val);
            current=current.right;
        }
        
        
        return result;
    }
    
    public static void printResult(List<Integer> lista)
    {
        for(Integer i: lista)
        {
            System.out.print(i+" ");
        }
        System.out.println("");
    }
    
}
