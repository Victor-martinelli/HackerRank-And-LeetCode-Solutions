/*
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
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
        int n = 10;
        
        System.out.println("The number of primes up to "+n+" is: "+countPrimes(n));
        
    }
    
     public static int countPrimes(int n) {
        
        int count=0;
        
        if(n>1)
        {
            boolean [] notPrime = new boolean[n];

            //0 and 1 are not considered prime
            notPrime[0] = true;
            notPrime[1] = true;



            //There are no prime numbers greater than the sqrt of the searched number
            for(int i=2;i<Math.sqrt(n);i++)
            {
                if(!notPrime[i])
                {   
                    //We set all the multiples of the prime number to false
                    for(int j=2;i*j<n;j++)
                    {
                        notPrime[i*j]=true;
                    }

                }
            }

            
            //We just count the number of prime numbers 
            for(int i=2;i<n;i++)
            {
                if(!notPrime[i])
                    count++;
            }
        }
        
        return count;
    }
    
}
