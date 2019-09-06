
import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

/**
 *
 * @author Portatil
 */
public class Solution {

     public static List<List<Integer>> result = new ArrayList();
    
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
        
        n2.left = n3;
        n2.right = n4;
        
        
        levelOrder(head);
    }
    
    public static void levelOrder(TreeNode root) 
    {
        levelOrderTraverse(root,0);
    }
    
    public static void levelOrderTraverse(TreeNode current,int level)
    {
        
        if(current!=null)
        {
            
            if(result.size()==level)
            {
                List<Integer> temp = new ArrayList();
                
                temp.add(current.val);
                
                result.add(temp);
                
            }
            else
                result.get(level).add(current.val);
            
            
            levelOrderTraverse(current.left,level+1);
            
            levelOrderTraverse(current.right,level+1);
            
        }
        
    }

      public static List<List<Integer>> levelOrderAnother(TreeNode root) {
        
        Queue<TreeNode> cola = new LinkedList();
        
        List<List<Integer>> result = new ArrayList();
        
        if(root!=null)
        {
            
            cola.offer(root);
            
            while(!cola.isEmpty())
            {
                
                List<Integer> current = new ArrayList();
                
                //This initializes the different levels of the tree
                int size = cola.size();
                
                for(int i=0;i<size;i++)
                {
                    TreeNode currentElement = cola.poll();
                    
                    current.add(currentElement.val);
                    
                    if(currentElement.left!=null)
                        cola.offer(currentElement.left);
                    
                    if(currentElement.right!=null)
                        cola.offer(currentElement.right);
                    
                }
                
                result.add(current);
                
            }
            
        }
        
        
        return result;
    }
    
     public static List<List<Integer>> levelOrderOriginal(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        
        if(root!=null)
        {
            List<List<Integer>> left = levelOrderOriginal(root.left);
            
            List<List<Integer>> right = levelOrderOriginal(root.right);
            
            List<Integer> aux = new ArrayList();
            
            aux.add(root.val);
            
            result.add(aux);
            
            int i=0;
            
            while(left.size()!=0 && i<left.size() && right.size()!=0 && i<right.size())
            {
                aux = new ArrayList();
                
                aux.addAll(left.get(i));
                aux.addAll(right.get(i));
                
                i++;
                
                result.add(aux);
            }
            
            List<List<Integer>> finalList=null;
            
            if(left.size()!=0 && i<left.size())
            {
                finalList=left;
            }
            else if(right.size()!=0 && i<right.size())
            {
                finalList=right;
            }
            
            
            if(finalList!=null)
            {
                
                while(i<finalList.size())
                {
                    
                    aux = new ArrayList();
                    
                    aux.addAll(finalList.get(i));
                    
                    result.add(aux);
                    
                    i++;
                }
                
            }
        }
        
        return result;
        
    }
    
}
