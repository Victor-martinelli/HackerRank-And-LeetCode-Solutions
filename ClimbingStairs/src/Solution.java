/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

/**
 *
 * As we can see this problem can be broken into subproblems, and it contains 
 * the optimal substructure property i.e. its optimal solution can be constructed 
 * efficiently from optimal solutions of its subproblems, we can use dynamic 
 * programming to solve this problem.

One can reach i^{th} step in one of the two ways:

Taking a single step from (i-1)^{th} step.

Taking a step of 22 from (i-2)^{th} step.

So, the total number of ways to reach i^{th} is equal to sum of ways of 
* reaching (i-1)^{th}  step and ways of reaching (i-2)^{th} step.

Let dp[i]dp[i] denotes the number of ways to reach on i^{th} step:

dp[i]=dp[i-1]+dp[i-2] dp[i]=dp[i−1]+dp[i−2]
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 38;
        
        System.out.println("There are "+climbStairs(n)+" ways of reaching "+n+" with 1 and 2 steps.");
    }
    
    //Fibonacci Sequence
     public static int climbStairs(int n) {
        
        int a=1;
        
        int b=1;
            
        int count=2;
        
        while(count<=n)
        {
            int temp = a;
            
            a = temp+b;
            
            b=temp;
            
            count++;
        }
        
        
        return a;
    }
    
    //Brute Force
     public static int climbStairsOriginal(int n) {
        
        int [] initial = new int[n];
        
        return stairClimber(initial,n,0,0,0);    
            
    }
    
    public static int stairClimber(int [] state,int solSteps,int sols,int currentSteps,int currentPos)
    {
        
        int sol=0;
        
        if(currentSteps<solSteps)
        {
            
            int [] one = new int[solSteps];
            
            int [] two = new int[solSteps];
            
            System.arraycopy(state, 0, one, 0, state.length);
            
            System.arraycopy(state, 0, two, 0, state.length);
            
            one[currentPos]=1;
            
            two[currentPos]=2;
            
            sol+=stairClimber(one,solSteps,sols,currentSteps+1,currentPos+1);
            
            sol+=stairClimber(two,solSteps,sols,currentSteps+2,currentPos+1);
            
        }
        else if(currentSteps==solSteps)
            sol+=1;
        
        return sol;
    }
    
}
