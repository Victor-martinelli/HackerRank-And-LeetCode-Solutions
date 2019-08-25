/*
 * Write a function that takes an unsigned integer and return the number of '1' 
bits it has (also known as the Hamming weight).

 

Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 

Note:

Note that in some languages such as Java, there is no unsigned integer type. 
In this case, the input will be given as signed integer type and should not 
affect your implementation, as the internal binary representation of the 
integer is the same whether it is signed or unsigned.

In Java, the compiler represents the signed integers using 2's complement 
notation. Therefore, in Example 3 above the input represents the signed integer -3.
 

Follow up:

If this function is called many times, how would you optimize it?
 */
package number.of.pkg1.bits;

/**
 *
 * @author Portatil
 */
public class NumberOf1Bits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = -3;
        
        System.out.println("Number of 1 bits in "+n+": "+hammingWeight(n));
        
    }
    
     public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    
     public static int hammingWeightOriginal(int n) {
        int result = 0;
        
        while(n!=0)
        {
            //Checks if the rightmost bit is 1 with an AND operation, meaning that if both are
            //1, returns 1
            result+=(n&1);
            
            //Shifts all the bits to the right and removes the current bit that was checked before
            /*
            10 = 1010
            After 10>>>1
            5 = 0101
            */
            n=n>>>1;
        }
        
        return result;
    }
    
}
