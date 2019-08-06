
import java.util.Arrays;

/*
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
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
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("Single number in Array: " + singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {

        int result = 0;

        /*
        If we take XOR of zero and some bit, it will return that bit
        a⊕0 =a
        
        If we take XOR of two same bits, it will return 0
        a⊕a=0
        a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
        
        So we can XOR all bits together to find the unique number.
         */
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    /*
    public static int singleNumber(int[] nums) {
        
        int result=0;
        
        boolean found = false;
        
        int i=0;
        
        Arrays.sort(nums);
        
        while(i<nums.length && !found)
        {
            if(i+1 >=nums.length || nums[i]!=nums[i+1])
            {
                found=true;
                result = nums[i];
            }
            else
            {
                i+=2;
            }
        }
        
        return result;
    }

     */
}
