
import java.util.HashMap;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
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
        
        int [] nums = {2,7,11,15};
        
        
        print(twoSum(nums,9));
        
    }
    
    
     public static int[] twoSum(int[] nums, int target) {
        
        int [] solution = new int [2];
        
        HashMap <Integer,Integer> leftOver= new HashMap<Integer,Integer>();
        
        int i=0;
        
        boolean found = false;
        
        while(i<nums.length && !found)
        {
            
            if(leftOver.containsKey(nums[i]))
            {
                found=true;
                
                solution[0] = leftOver.get(nums[i]);
                solution[1] = i;
                
                
            }
            else
            {
                leftOver.put(target-nums[i],i);
                i++;
            }
            
            
        }
        
        return solution;
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
