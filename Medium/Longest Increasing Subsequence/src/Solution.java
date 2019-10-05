
import java.util.ArrayList;
import java.util.List;

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
        int [] nums = {10,9,2,5,3,3,7,101,18};
        
        lengthOfLIS(nums);
    }
    
     public static int lengthOfLIS(int[] nums) {
        
        //This is the list that will hold every solution up to the end
        List<Integer>[] dp = new List[nums.length];
        
        //If there is a single element, then we simply select the only one available
        
        dp[0] = new ArrayList();
        
        dp[0].add(nums[0]);
        
        //If there is two elements, we check if they can be a sequence or if only one of them can be selected
        
        dp[1] = new ArrayList();
        
        if(dp[0].get(0)<nums[1])
        {
            dp[1].add(dp[0].get(0));
            dp[1].add(nums[1]);
        }
        else
            dp[1].add(Math.min(dp[0].get(0),nums[1])); // If they cant be a sequence, we keep the smallest one
        
        
        //We go through the nums array checking if the current element can be inserted into the previous longest
        //subsequence
        
        for(int i=2;i<nums.length;i++)
        {
            //We test the current element with the previous sequence
            
            dp[i] = new ArrayList();
            
            List<Integer> candidate = new ArrayList();
            
            boolean finished=false;
            
            int j=0;
            
            while(!finished && j<dp[i-1].size()+1)
            {
                
                //If the current element is less than the current element in the previous sequence
                
                if(dp[i-1].get(j)<nums[i])
                    candidate.add(dp[i-1].get(j));
                else
                {
                    //Finished the sequence up to this point
                    finished=true;
                    candidate.add(nums[i]);
                }
                j++;
            }
            
            //If the new sequence is larger than the previous one
            
            if(candidate.size()>=dp[i-1].size())
                dp[i].addAll(candidate);
            else
                dp[i].addAll(dp[i-1]);
        }
        
        //We return the final length
        return dp[nums.length-1].size();
    }
    
}
