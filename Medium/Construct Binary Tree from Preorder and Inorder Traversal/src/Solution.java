
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
/**
 *
 * @author Portatil
 */
public class Solution {

    //Index in the preorder array
        static int preIndex=0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] preorder1 = {3,9,20,15,7};
        int [] inorder1 = {9,3,15,20,7};
        
        System.out.print("Preorder: ");
        printList(preorder1);
        System.out.print("Inorder: ");
        printList(inorder1);
        
        System.out.println("Result Tree: ");
        nodesPrint(buildTreeRecursive(preorder1,inorder1));
    }

    public static TreeNode buildTreeIterative(int[] preorder, int[] inorder) {

        if (preorder.length != 0) {
            Stack<TreeNode> pila = new Stack();
            HashMap<Integer, Integer> map = new HashMap();

            //We first store the positions of each node in the tree (their number in the inOrder array)
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            //We set up the root node (it's the first number in the preorder array)
            TreeNode root = new TreeNode(preorder[0]);

            //We push it into the stack
            pila.push(root);

            //Rest of the nodes
            for (int i = 1; i < preorder.length; i++) {

                TreeNode current = new TreeNode(preorder[i]);

                //If the node is to the left of the current node
                if (map.get(current.val) < map.get(pila.peek().val)) {
                    pila.peek().left = current;
                } else {

                    //Node is to the right of the current node, which means 
                    //It's the right child of the current node or the right child
                    //Of a parent node
                    TreeNode parent = null;

                    //While the stack isn't empty and the current node is to the right of the current node
                    while (!pila.isEmpty() && map.get(current.val) > map.get(pila.peek().val)) {
                        parent = pila.pop();
                    }

                    //We found the parent because there isnt any other node to look at or because 
                    //this node was to the right of the parent node
                    parent.right = current;

                }

                pila.push(current);

            }

            return root;
        } else {
            return null;
        }

    }
    
     public static TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        
        //Number and position in Inorder
       HashMap<Integer,Integer> map = new HashMap();
        
        //We store the position for each of the nodes as the appear in the tree
       for(int i=0;i<inorder.length;i++)
       {
           map.put(inorder[i],i);
       }
        
        return auxBuildTree(preorder,inorder,map,0,inorder.length-1);
        
    }
    
    public static TreeNode auxBuildTree(int[] preorder, int[] inorder,HashMap<Integer,Integer> map,int start,int end)
    {
        
        if(start>end)
            return null;
        else
        {
            
            TreeNode current = new TreeNode(preorder[preIndex]);
            
            //Go to the next number in the tree
            preIndex++;
            
            //Position of the current element in inorder
            int index = map.get(current.val);
            
            //We adjust the indices for each of the future children
            current.left= auxBuildTree(preorder,inorder,map,start,index-1); //Everything from the start to the index must be to the left of the current
                                                                            //node, as by definition of inorder
            
            current.right = auxBuildTree(preorder,inorder,map,index+1,end);  //Everything from the start to the index must be to the right of the current
                                                                            //node, as by definition of inorder
            
            
            return current;
        }
        
        
    }
    

    public static void printList(int[] lista) {
        for (int el : lista) {
            System.out.print(el + " ");
        }
        System.out.println("");
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
