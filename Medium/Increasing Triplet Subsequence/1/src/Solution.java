/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
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
        int [] test1 = {3,4,2,1,5};
        
        System.out.print("Is there an increasing triplet subsequence in the array: ");
        
        printSequence(test1);
        
        System.out.println(" ? : "+increasingTriplet(test1));
        
        int [] test2 = {3,5,2,1,4};
        
        System.out.print("Is there an increasing triplet subsequence in the array: ");
        
        printSequence(test2);
        
        System.out.println(" ? : "+increasingTriplet(test2));
    }
    
     public static boolean increasingTriplet(int[] nums) {
        
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
     
    public static void printSequence(int[] arr)
    {
        for(int el : arr)
        {
            System.out.print(el+" ");
        }
    }
    
}
