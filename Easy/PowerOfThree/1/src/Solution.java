/*
 * Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
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
        int n = 14348907;
        
        
        System.out.println("Is "+n+" a power of three?: "+isPowerOfThree(n));
    }
    
    public static boolean isPowerOfThree(int n) {
    // 1162261467 is 3^19,  3^20 is bigger than int
    return ( n>0 &&  1162261467%n==0);
}
    
     public static boolean isPowerOfThreeOriginal(int n) {
        
        double result = Math.log10(n) / Math.log10(3);
        
        //We check if there is a decimal
        return result%1==0;
    }
    
}
