/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
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
        
        int[] arr = {-1,-100,3,99};
        
        print(arr);
        
        arr = rotate(arr,2);
        
        print(arr);
    }
    
    /*
    This approach is based on the fact that when we rotate the array k times, 
    k%nk elements from the back end of the array come to the front and the rest 
    of the elements from the front shift backwards.

    In this approach, we firstly reverse all the elements of the array. 
    Then, reversing the first k elements followed by reversing the rest n-kn−k 
    elements gives us the required result.

    Let n=7n=7 and k=3k=3.

    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
    
    Time complexity : O(n). n elements are reversed a total of three times.

    Space complexity : O(1). No extra space is used.
    */
    
    public static int[] rotate(int[] nums,int k)
    {
        //This is just in case the number of rotations is greater than the number of elements in the array
        k%=nums.length;
        
        nums = reverse(nums,0,nums.length-1);
        
        nums = reverse(nums,0,k-1);
        
        nums = reverse(nums,k,nums.length-1);
        
        return nums;
    }
    
    public static int[] reverse(int [] arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            
            arr[start] = arr[end];
            
            arr[end] = temp;
            
            start++;
            
            end--;
        }
        
        return arr;
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
