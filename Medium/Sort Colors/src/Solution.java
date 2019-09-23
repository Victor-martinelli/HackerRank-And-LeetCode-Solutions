/*
 * Given an array with n objects colored red, white or blue, sort them in-place 
so that objects of the same color are adjacent, with the colors in the order red, 
white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite 
array with total number of 0's, then 1's and followed by 2's.

Could you come up with a one-pass algorithm using only constant space?
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
        int[] color = {2,0,2,1,1,0};
        
        System.out.print("Color Array: ");
        
        printArr(color);
        
        
        System.out.print("Sorted Color Array: ");
        
        printArr(sortColors(color));
        
    }
    
     public static int[] sortColors(int[] nums) {
        //Three Pointers 
        int start =0;
        int end=nums.length-1;
        int index=0;
        
        while(index<=end)
        {
            if(nums[index]==1) 
            {
                index++;
            }
            else if(nums[index]==0)
            {
                swap(nums,start,index);
                index++;
                start++;
            }
            else
            {
                swap(nums,index,end);
                end--;
            }
        }
        return nums;
    }
    
    public static void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        
        nums[i] = nums[j];
        
        nums[j] = temp;
    }
    
     public static int[] sortColorsOriginal(int[] nums) {
        
        //Array that will store every count of each color
        
        int[] count = new int[3];
        
        //Count the color count
        for(int i=0;i<nums.length;i++)
        {
            count[nums[i]]++;
        }
        
        //We now change the values of the array depending on the values of count, starting from the beggining
        
        int j=0;
        
        for(int i=0;i<nums.length;i++)
        {
            
            if(count[j]==0)
            {
                j++;
                i--;
            }
            else
            {
                nums[i]=j;

                count[j]-=1;
            }
            
        }
        
        return nums;
    }
    
    public static void printArr(int[] arr)
    {
        for(int el : arr)
        {
            System.out.print(el+" ");
        }
        System.out.println("");
    }
     
}
