
import java.util.Arrays;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
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
       int [] test = {-10,0,8,30,50,100,120};
       
       
       sortedArrayToBST(test);
    }
    
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) {
            return null;
        }
        return toBst(nums, 0, nums.length - 1);
    }
    
    
    public static TreeNode toBst(int[] nums, int start, int end) {
 
        
        if(start > end) {
            return null;
        }

            int middle = (start + end  + 1)/2;
            TreeNode parent = new TreeNode(nums[middle]);
            parent.left = toBst(nums, start, middle -1);
            parent.right = toBst(nums, middle + 1, end);
       
            return parent;


    }
    
    
    public static TreeNode sortedArrayToBSTOriginal(int[] nums) {
        
        return sortedArrayAux(nums);
    }
    
    public static TreeNode sortedArrayAux(int[] nums)
    {
        
        TreeNode current = null;
        //System.out.println("Start: "+start+" - End: "+end);
        if(nums.length>0)
        {
            int middle = (int)Math.ceil((nums.length-1)/2.0);
            
            //System.out.println("Middle: "+middle);

            current = new TreeNode(nums[middle]);

            if(middle-1>=0)
                current.left = sortedArrayAux(Arrays.copyOfRange(nums,0,middle));

            if(middle+1<nums.length)
            current.right = sortedArrayAux(Arrays.copyOfRange(nums,middle+1,nums.length));
        }
        
        return current;
    }
    
}
