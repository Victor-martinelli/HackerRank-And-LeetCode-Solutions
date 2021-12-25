/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands 
horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    private static char[][] mainGrid;
    
    public static void main(String[] args) {
        char [][] mat = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        
        System.out.println("The number of islands in: ");
        printMatrix(mat);
        
        System.out.println("Is: "+numIslands(mat));
        
        char [][] mat2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        
        System.out.println("The number of islands in: ");
        printMatrix(mat2);
        
        System.out.println("Is: "+numIslands(mat2));
        
    }
    
    public static int numIslands(char[][] grid) {
        
        int result=0;
        
        mainGrid=grid;
        
        for(int i=0;i<mainGrid.length;i++)
        {
            for(int j=0;j<mainGrid[i].length;j++)
            {
                //If we find a piece of island, we set the entire island to zero
                if(mainGrid[i][j]=='1')
                {
                    setIslandToZero(i,j);
                    result++;
                }
            }
        }
        return result;
    }
    
    public static void setIslandToZero(int i,int j)
    {
        //If it's not out of bounds and it's a 1
        if(i>=0 && j>=0 && i<mainGrid.length && j<mainGrid[i].length && mainGrid[i][j]=='1')
        {
            
            mainGrid[i][j]='0';
            
            //Up
            setIslandToZero(i-1,j);
            
            //Down
            setIslandToZero(i+1,j);
            
            //Left
            setIslandToZero(i,j-1);
            
            //Right
            setIslandToZero(i,j+1);
        }
    }
    
    public static void printMatrix(char[][] mat)
    {
        for(char [] row : mat)
        {
            for(char el : row)
            {
                System.out.print(el+" ");
            }
            System.out.println("");
        }
    }
    
}
