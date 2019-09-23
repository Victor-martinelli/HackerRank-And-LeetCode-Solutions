/*
 * Given an array of integers nums sorted in ascending order, find the starting 
and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
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
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        
        System.out.println("Initial Srray: ");
        
        printArr(nums);
        
        int[] result = searchRange(nums,target);
        
        System.out.println("Initial and end positions for the target "+target+" : "+result[0]+" "+result[1]);
        
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int [] result = {-1,-1};
        
        int leftIndex = findLeftOrRightmostIndex(nums,target,true);
        
        //If the index is not valid
        if(leftIndex==nums.length || nums[leftIndex]!=target)
            return result;
        
        int rightIndex = findLeftOrRightmostIndex(nums,target,false)-1;
        
        result[0]=leftIndex;
        result[1]=rightIndex;
        
        return result;
    }
    
    //Boolean indicates is we are searching for the furtherst right or left
    public static int findLeftOrRightmostIndex(int [] nums,int target, boolean left)
    {
        int low = 0;
        
        int high=nums.length;

        while(low<high)
        {
            
            int middle = (high+low)/2;
            
            //If we are trying to find the furthest left index, we move the 
            // high index to middle
            if(nums[middle]>target || (left && nums[middle]==target))
            {
                high=middle;
            }
            else // If we are not, we move it to the right
                low=middle+1;
                
            
        }
        
            
        return low;
    }
    
     public static int[] searchRangeOriginal(int[] nums, int target) {
        // First we try to find the first index of the target
        
        boolean finished=false;
        
        int[] result = new int[2];
        
        result[0]=-1;
        result[1]=-1;
        
        int start=0;
        int end=nums.length;
        
        while(!finished && start<end)
        {
            int middle = start+(end-start)/2;
            
            //System.out.println("Start: "+start+" - End: "+end);
            
            //If this element is less than the target
            if(nums[middle]<target)
            {
                start=middle+1;
            }
            else if(nums[middle]>target) //If this element is greater than target
            {
                end=middle;
            }
            else
            {    //If it is the target
                finished=true;
                result[0]=middle;
            }
        }
        
        
        //If we found the target
        if(finished)
        {
            
            //We try to find the first instance of the target since the one found before might not be
            //the first one
            
            int temp = result[0];
            
            int i=temp;
            
            boolean done=false;
            
            //We go to the right to find the first instance
            while(!done && i>=0)
            {
                if(nums[i]==target)
                {
                    result[0]=i;
                    i--;
                }
                else
                    done=true;
            }
            
            done=false;
            
            i=temp;
            
            //We go to the left to find the first instance
            while(!done && i<nums.length)
            {
                if(nums[i]==target)
                {
                    result[1]=i;
                    i++;
                }
                else
                    done=true;
            }
            
        }
        
        
        return result;
    }
    
     public static void printArr(int[] arr)
     {
         for(int el : arr)
             System.out.print(el+" ");
         
         System.out.println("");
     }
     
}
