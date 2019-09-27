/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
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
        // TODO code application logic here
    }
    
     public static int search(int[] nums, int target) {
        
        //If the array is not valid
        if(nums==null || nums.length==0)
            return -1;
        
        //We first do a binary search to find the pivot point 
        
        int left=0;
        int right=nums.length-1;
        
        while(left<right)
        {
            int mid = left + (right - left) /2;
            
            //Pivot must be to the right
            if(nums[mid]>nums[right])
            {
                left = mid+1;
            }
            else //Pivot must be to the left
            {
                right = mid;
            }
            
        }
        
        //We now have to figure out both points to peform another binary search
        
        int pivot = left;
        
        left=0;
        right=nums.length-1;
        
        //If the target is greater than our pivot and the target is smaller than the element furthest to the right
        if(target>=nums[pivot] && target<=nums[right])
        {
            left = pivot; //Element to be found must be to the right of the pivot
        }
        else
        {
            right = pivot; //Element to be found must be to the left of the pivot
        }
        
        
        //We peform another binary search
        
        while(left<=right)
        {
            int mid = left + (right - left) / 2;
            
            if(target == nums[mid]) // We found the element
            {
                return mid;
            }
            else if(nums[mid]<target) // Target must be to the right
            {
                left=mid+1;
            }
            else
            {
                right=mid-1; //Target must be to the left
            }
            
        }
        
        
        return -1; //This is in  case that we don't find the desired element        
    }
    
}
