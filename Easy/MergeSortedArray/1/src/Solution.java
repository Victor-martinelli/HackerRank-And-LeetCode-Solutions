
import java.util.Arrays;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
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
       int [] nums1 = {1,2,3,0,0,0,0};
       int [] nums2 = {2,5,6};
       
       System.out.println("First Array");
       
       printArray(nums1);
       
       System.out.println("Second Array");
       
       printArray(nums2);
       
       int m=3;
       int n=3;
       
       nums1 = merge(nums1,m,nums2,n);
       
       System.out.println("Merged Array");
       
       printArray(nums1);
    }
    
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        
        int j=m;
        
        for(int i=0;i<nums2.length;i++)
        {
            nums1[j] = nums2[i];
            j++;
        }
        
        nums1 = Arrays.copyOf(nums1,m+n);
        
        Arrays.sort(nums1);
        
        
        return nums1;
    }
    
    
    public static void printArray(int [] arr)
    {
        for(int num : arr)
        {
            System.out.print(num+" ");
        }
        
        System.out.println();
    }
    
}
