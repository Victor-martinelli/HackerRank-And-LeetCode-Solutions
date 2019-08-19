
import java.util.Stack;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
Bonus points if you could solve it both recursively and iteratively.
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
       TreeNode n2 = new TreeNode(2);
       TreeNode n3 = new TreeNode(3);
       TreeNode n4 = new TreeNode(4);
       TreeNode n5 = new TreeNode(4);
       TreeNode n6 = new TreeNode(3);
       
       root.left=n1;
       root.right=n2;
       
       n1.left=n3;
       n1.right=n4;
       
       n2.left=n5;
       n2.right=n6;
       
       System.out.println("Is the Tree Symmetric?: "+isSymmetricIterative(root));
       
    }

    public static boolean isSymmetricIterative(TreeNode root) {

        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;

    }

    public static boolean isSymmetricRecursive(TreeNode root) {

        if (root != null) {
            return isSymmetricAux(root.left, root.right);
        } else {
            return true;
        }
    }

    public static boolean isSymmetricAux(TreeNode candidateA, TreeNode candidateB) {

        boolean result = true;

        //Both nodes are not null
        if (candidateA != null && candidateB != null) {

            //Both elements need to have the same value
            if (candidateA.val == candidateB.val) {
                //Check the children

                result = isSymmetricAux(candidateA.right, candidateB.left);

                if (result) {
                    result = isSymmetricAux(candidateA.left, candidateB.right);
                }

            } else {
                result = false;
            }

        } else if ((candidateA != null && candidateB == null) || (candidateB != null && candidateA == null)) //One of the elements is null but not the other one
        {
            result = false;
        }

        return result;
    }

}
