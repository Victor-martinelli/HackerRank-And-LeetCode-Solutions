
import java.util.ArrayList;
import java.util.List;

/*
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
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
        int n = 15;
        System.out.println("Pascal Triangle for: "+n+" is: ");
        
        printTriangle(generate(n));
    }
    
    
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList();
        
        if(numRows>0)
        {
        
            List<Integer> temp = new ArrayList();

            temp.add(1);

            result.add(temp);

            if(numRows>1)
                return generatePascalTriangle(result,1,numRows);
            else
                return result;
        }
        else 
            return result;
        
    }
    
    public static List<List<Integer>> generatePascalTriangle(List<List<Integer>> sol,int currentRow,int numRows)
    {
        
        if(currentRow<=numRows-1)
        {
            List<Integer> current = new ArrayList();
            
            //We add the first one
            current.add(sol.get(currentRow-1).get(0));

            for(int i=1;i<currentRow;i++)
            {

                current.add(sol.get(currentRow-1).get(i-1) + sol.get(currentRow-1).get(i));
                
            }

            //We add the last one
            current.add(sol.get(currentRow-1).get(currentRow-1));
            
            sol.add(current);
            
             return generatePascalTriangle(sol,currentRow+1,numRows);
        }
        else
            return sol;

    }
    
    public static void printTriangle(List<List<Integer>> lista)
    {
        
        for(List<Integer> current: lista)
        {
            for(Integer item : current)
            {
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        
    }
    
}
