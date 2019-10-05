/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        int [] nums = {2,3,1,1,4};
        
        System.out.println(canJump(nums));
    }
    
    public static boolean canJump(int[] nums) {
        return isThereASolutionBruteForce(nums,0);
    }
    
    public static boolean isThereASolutionBruteForce(int[] nums, int currentPos)
    {
        boolean isSolution=false;
        
        //If we are at the end
        if(currentPos == nums.length-1)
            isSolution=true;
        else if(currentPos<nums.length)//If we are not
        {
            
            //We try every available step from the current position
            
            int currentSteps = nums[currentPos];
            
            //While we havent found a solution and there are still remaining jobs
            while(!isSolution && currentSteps>0)
            {
                isSolution = isThereASolutionBruteForce(nums,currentSteps + currentPos);
                currentSteps-=1;
            }
            
            
        }
        return isSolution;
    }
    
}
