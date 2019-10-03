
import java.util.Arrays;

/*
 *You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
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
        int[] coins = {1,2,5};
        int[] coins2 = {186,419,83,408};
        
        int amount = 39;
        int amount2 = 6249;
        
        System.out.println("Initial amount of coins: ");
        
        printArr(coins);
        
        System.out.println("Minimal amount of coins for the target: "+amount+" --> "+coinChange(coins,amount));
        
        System.out.println();
        
        System.out.println("Initial amount of coins: ");
        
        printArr(coins2);
        
        System.out.println("Minimal amount of coins for the target: "+amount2+" --> "+coinChange(coins2,amount2));
        
    }
    
     public static int coinChange(int[] coins, int amount) {
        
        //Array that will hold the answer (it's +1 because we are considering the case of having a target of 0)
        int[]dp = new int[amount+1];
            
        //We fill the array with an invalid amount such that it makes more coins than the current
        //target to solve the problem
            
        Arrays.fill(dp,amount+1);
        
        //We set the first position to 0 because it takes 0 coins for the target 0
        dp[0]=0;
        
        //We go through the different targets up to the final target trying every single coin we have
        
        for(int i=0;i<=amount;i++)
            for(int j=0;j<coins.length;j++)
                if(coins[j]<=i) // If we can take the current coin (the current coint is smaller than the current target)
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]); // We want the smallest amount of coins for the target,
                    //so we get the min, which is either current or taking the current coin and the amount of coins
                    //neccesary to complete the remaining amount left
        
        //If the last position is still amount+1, that means there is no solution
        
        return dp[amount]>amount ? -1 : dp[amount];
        
        
    }
     
    public static void printArr(int[] arr)
    {
        for(int el : arr)
            System.out.print(el+" ");
        
        System.out.println();
        
    }
    
}
