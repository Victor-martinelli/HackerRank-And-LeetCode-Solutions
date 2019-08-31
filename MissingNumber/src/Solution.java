
import java.util.Arrays;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

/**
 *
 * @author victormartinelli
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /*
    One of the most well-known stories in mathematics is of a young Gauss, f
    orced to find the sum of the first 100 natural numbers by a lazy teacher. 
    Rather than add the numbers by hand, he deduced a closed-form expression 
    for the sum, or so the story goes. You can see the formula below:
    
    
    Algorithm

We can compute the sum of nums in linear time, and by Gauss' formula, we can 
compute the sum of the first natural numbers in constant time. Therefore, the 
number that is missing is simply the result of Gauss' formula minus the sum 
of nums, as nums consists of the first natural numbers minus some number.
    */
    
    public static int missingNumber(int[] nums) {
        
        int expected = (nums.length * (nums.length +1)) / 2;
        
        int actualSum=0;    
            
        for(int current : nums)
            actualSum+=current;
        
        return expected - actualSum;
    }
    
    public static int missingNumberOriginal(int[] nums) {
        int solution =-1;
        
        if(nums.length>=1)
        {

            Arrays.sort(nums);

            int i=0;

            while(solution==-1 && i<nums.length)
            {
                if(nums[i]!=i)
                {
                    solution=i;
                }
                else
                    i++;
            }
            
            if(solution==-1)
                solution=nums.length;
            
        }
        else
            solution=0;
        
        return solution;
    }
    
}
