/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
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
        int [] nums1 = {1,1,2};
        
        int [] nums2 = {1,1,1,2,3,3,4};
        
        int [] nums3 = {1,1,2,3,4};
        
        int [] nums4 = {1};
        
        int [] nums5 = {};
        
        int [] nums6 = {1,2};
        
        print(removeDuplicates(nums1),nums1);
        
        print(removeDuplicates(nums2),nums2);
        
        print(removeDuplicates(nums3),nums3);
        
        print(removeDuplicates(nums4),nums4);
        
        print(removeDuplicates(nums5),nums5);
        
        print(removeDuplicates(nums6),nums6);
    }
    
     public static int removeDuplicates(int[] nums) {
        
            int size=nums.length;
        
            int i=0;

            int j=0;

            while(i<nums.length && j<nums.length)
            {
                j++;

                boolean found=false;

                while(j<nums.length && !found)
                {
                    
                    //Duplicate number
                    if(nums[i]==nums[j])
                    {
                        j++;
                        size--;
                    }
                    else
                    {
                        //We change the following number to i
                        i++;
                        nums[i] = nums[j];
                        found=true;
                    }
                }

            }
        
        
        return size;
    }
    
     
     public static void print(int len, int[] nums)
     {
         for(int i=0;i<len;i++)
         {
             System.out.print(nums[i]);
         }
         
         System.out.println();
     }
     
}
