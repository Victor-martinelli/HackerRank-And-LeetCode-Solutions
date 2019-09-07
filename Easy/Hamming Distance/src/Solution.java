/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ^   ^
       |   |

The above arrows point to positions where the corresponding bits are different.
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
        int x = 1;
        
        int y = 4;
        
        System.out.println("The Hamming Distance of "+x+" and "+y+" is: "+hammingDistance(x,y));
        
    }
    
     public static int hammingDistance(int x, int y) {
        
        int temp = x ^ y; //If its different, then 1. Else 0
        
        return Integer.bitCount(temp); //We simply count the number of different
    }
    
}
