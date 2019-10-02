/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is 
trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28
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
        int n = 3;
        int m = 7;
        
        System.out.println("Unique paths for a matrix of size "+n+"x"+m+" is: "+uniquePaths(m,n));
        
        int n1 = 3;
        int m1 = 100;
        
        System.out.println("Unique paths for a matrix of size "+n1+"x"+m1+" is: "+uniquePaths(m1,n1));
    }
    
    //m -> columns    n-> rows 
    public static int uniquePaths(int m, int n) {
        
        //We have an auxiliary matrix that where each cell will build up the solutions
        
        int[][] matrix = new int[n][m];
        
        //We set the first column and row to 1 to represent a solution to the problem
        
        for(int i=0;i<m;i++) 
        {
            matrix[0][i] = 1;
        }
        
        for(int i=0;i<n;i++) 
        {
            matrix[i][0] = 1;
        }
        
        //We now go through the entire matrix building up the solution depending on the previous step to get there
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                //To get to this cell, it can only come from going down or right
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        
        
        //Finally, we simply return the number that is on the lasst cell since it will have the number of 
        //Paths to get there
        return matrix[n-1][m-1];
        
    }
    
}
