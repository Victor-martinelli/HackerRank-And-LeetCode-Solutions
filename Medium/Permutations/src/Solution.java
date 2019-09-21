
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int [] nums = {1,2,3};
        
        permute(nums);
        
    }
    
    
     public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> current = new ArrayList();
        
        //We first populate the result with every inital number
        
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> temp = new ArrayList();
            temp.add(nums[i]);
            current.add(temp);
        }
        
        return generatePermutation(nums,current,1);
    }
    
    
    public static List<List<Integer>> generatePermutation(int[] nums, List<List<Integer>> current,int count)
    {
        List<List<Integer>> result = new ArrayList();
        
        if(count!=nums.length)
        {
            
            //We add every number to the current solutions
            
            for(int i=0;i<nums.length;i++)
            {
                
                for(List<Integer> solution : current)
                {
                    
                    if(!solution.contains(nums[i]))
                    {
                        solution.add(nums[i]);
                        result.add(solution);
                    }
                    
                }
                
            }
            
            return generatePermutation(nums,result,count+1);
        }
        else 
        {
            return current;
        }
    }
    
}
