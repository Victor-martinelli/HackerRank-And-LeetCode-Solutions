
import java.util.Arrays;

/*
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
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
        int [] nums1 = {1,2,2,1};
        
        int [] nums2 = {2,2};
        
        
        print(intersect(nums1,nums2));
        
    }
    
     public static int[] intersect(int[] nums1, int[] nums2) {
        
        int size=0;
        
        int p1=0;
        
        int p2=0;
        
        int index=0;
        
        
        if(nums1.length>nums2.length)
        {
            size = nums2.length;
        }
        else
        {
            size=nums1.length;
        }
        
        int [] result = new int[size];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(p1<nums1.length && p2<nums2.length)
        {
            
            if(nums1[p1]<nums2[p2])
            {
                p1++;
            }
            else if(nums1[p1]>nums2[p2])
            {
                p2++;
            }
            else
            {
                result[index] = nums1[p1];
                index++;
                p1++;
                p2++;
            }
            
        }
       

        return Arrays.copyOf(result,index);
    }
     
     public static void print(int [] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}
