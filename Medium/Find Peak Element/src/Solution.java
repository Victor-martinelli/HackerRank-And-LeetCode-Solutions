/*
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
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
        int[] nums = {1,2,1,3,5,6,4};
        
        System.out.println("Array to find peak: ");
        
        printArr(nums);
        
        System.out.println("Index of the peak element: "+findPeakElement(nums));
        
    }
    
    public static int findPeakElement(int[] nums) {
        
        //Set up the individual elements of the binary search
        
        int left = 0;
        
        int right = nums.length-1;
        
        while(left<right)
        {
            int mid = left + (right -left) /2;//Avoid overflow
                
            //If the current element is larger than it's consecutive neighbour
            if(nums[mid]>nums[mid+1])
                right = mid; // We can remove all the element from the right and keep the mid since it may be a peak
            else //If the current element is smaller than the consecutive neighbour
                left = mid+1; //The current element might be a neighbour of a peak so we discard all the elements to the left and the current element too
        }
        
        return left;
    }
    
    public int findPeakElementRegularSolution(int[] nums) {
        
        int result=-1;
        
        int i=0;
        
        while(result==-1 && i<nums.length)
        {
            int current = nums[i];
            
            //If we can check the element to our left
            if(i-1>=0)
                current = Math.max(nums[i-1],current); // We store which one is larger
            
            //If we can check the element to our right and the number hasn't changed already
            if(i+1<nums.length && current==nums[i])
                current = Math.max(nums[i+1],current);
            
            //If current still is the same, that means that current is larger than it's neighbours
            if(current==nums[i])
                result=i;
            else
                i++; //If not, one of the neighbours is still larger
            
        }
        
        return result;
    }
    
    public static void printArr(int [] arr)
    {
        for(int el : arr)
        {
            System.out.print(el+" ");
        }
        System.out.println("");
    }
    
}
