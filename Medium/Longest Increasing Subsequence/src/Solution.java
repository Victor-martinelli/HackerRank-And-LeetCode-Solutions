
import java.util.Arrays;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
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
        
        int [] nums2 = {3,5,6,2,5,4,19,5,6,7,12};
        
        System.out.println("Current Array: ");
        
        printArr(nums);
        
        System.out.println("Longest Subsequence Size: "+lengthOfLIS(nums));
        
        System.out.println("Current Array: ");
        
        printArr(nums2);
        
        System.out.println("Longest Subsequence Size: "+lengthOfLIS(nums2));
    }
    
    public static int lengthOfLISBinarySearch(int[] nums) {
     
      //This will hold the current subsequence that we are working on
        
      int[] dp = new int[nums.length];
        
      //This will be the longest subsequence that we have currently found
      int result = 0;
        
      //We go through all the numbers
    
      for(int current : nums)
      {
          
          //We try to find where the current number goes in the dp array
          //Up to the current length
          
          int pos = Arrays.binarySearch(dp,0,result,current);
          
          //If it's less that 0, it means that it isn't in the array and it
          //Tells us where it should be
          
          if(pos<0)
              pos = -(pos+1); // We get where the number it's supposed to be
          //Binary Search will return (-(insertion point) - 1). The insertion point is the point at which the key would be inserted into the array
          
          //We insert the number
          dp[pos] = current;
          
          //If we have increased our current solution
          if(pos==result)
              result++;
          
          
      }
        
      return result;  
    }
    
    public static int lengthOfLIS(int[] nums) {
     
        //If there are no elements
        if(nums.length==0)
            return 0;
        
        //We keep track of the largest subsequence found so far
        int[] dp = new int[nums.length];
        
        //If there is only 1 element, it's the only solution
        dp[0]=1;
        
        //Max element so far
        int maxSoFar=1;
        
        //We start from the second one and check the current element with every one
        //Up to that point
        
        for(int i=1;i<nums.length;i++)
        {
            //Current iteration max
            int currentMax = 0;
            
            //We check it from the very start
            for(int j=0;j<i;j++)
            {
                //If the current element can be a next element
                if(nums[i]>nums[j])
                    currentMax = Math.max(currentMax,dp[j]); //We check if the current max is bigger or the subsequence up to the point
            }
            
            //The current subsequence is the currentMax + the current element
            dp[i] = currentMax+1;
            
            //The max element so far is either the current max or the maxSoFar
            maxSoFar = Math.max(maxSoFar,dp[i]);
            
        }
        return maxSoFar;
        
    }
    
    public static int lengthOfLISBruteForce(int[] nums) {
     
        //We recursively go through the array
        return helper(nums,Integer.MIN_VALUE,0);
    }
    
    public static int helper(int [] nums,int previous, int currentPos)
    {
        
        //If we are done
        if(currentPos==nums.length)
            return 0;
        
        int tookCurrent=0;
        
        //If we can take the element
        if(nums[currentPos]>previous)
            tookCurrent = 1 + helper(nums,nums[currentPos],currentPos+1); //The current element is previous and we check the next one
        
        //We also look at the posibility of not taking the current element
        int notTookCurrent = helper(nums,previous,currentPos+1);
        
        //We return the max of both
        return Math.max(tookCurrent,notTookCurrent);
    }
    
    public static void printArr(int [] arr)
    {
        for(int el : arr)
            System.out.print(el+" ");
        
        System.out.println();
    }
    
    /*
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
    
    */
}
