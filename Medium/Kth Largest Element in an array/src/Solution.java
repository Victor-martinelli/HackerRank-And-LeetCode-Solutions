
import java.util.Arrays;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 <= k <= array's length.
 */

/**
 *
 * @author victormartinelli
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] nums = {6,2,2,4,1,4,5,5,3,3,6};
        
        System.out.println("Original array: ");
        
        printArray(nums);
        
        int k =2;
        
        int k2=1;
        
        int k3 = 3;
        
        System.out.println("The "+k+"th largest element in the array (in sorted order) is: "+findKthLargest(nums,k));
        
        System.out.println("The "+k2+"th largest element in the array (in sorted order) is: "+findKthLargest(nums,k2));
        
        System.out.println("The "+k3+"th largest element in the array (in sorted order) is: "+findKthLargest(nums,k3));
        
    }
    
     public static int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0 || k>nums.length || k<1)
            return -1;
            
        Arrays.sort(nums);
        
        return nums[nums.length-k];
    }
     
     public static void printArray(int [] arr)
     {
         for(int el : arr)
             System.out.print(el+" ");
         
         System.out.println();
     }
    
}
