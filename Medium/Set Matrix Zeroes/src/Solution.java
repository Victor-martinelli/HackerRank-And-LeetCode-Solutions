
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
/**
 *
 * @author Portatil
 */
public class Solution {

    
    public static void main(String[] args) {
        
        int [][] matrix1 = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        
        int [][] matrix2 = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        
        System.out.println("Matrix 1 before setting zeroes: ");
        printMatrix(matrix1);
        
        System.out.println("Matrix 1 after setting zeroes: ");
        printMatrix(setZeroes(matrix1));
        
        System.out.println("Matrix 2 before setting zeroes: ");
        printMatrix(matrix2);
        
        System.out.println("Matrix 2 after setting zeroes: ");
        printMatrix(setZeroes(matrix2));
        
        
    }
    
    public static int[][] setZeroes(int[][] matrix) {
        
        //We are going to use first row and column to keep track of rows and columns that need to be 0
        //After that, we are going to check if they themselfs need to be 0
        
        boolean zeroRow=false;
        boolean zeroColum=false;
        
        int i=0;
        
        //We check if there is a zero in the first row and column before changing it
        while(!zeroRow && i<matrix.length)
        {
            if(matrix[i][0]==0)
                zeroRow=true;
            else
                i++;
        }
        
        i=0;
        
        while(!zeroColum && i<matrix[0].length)
        {
            if(matrix[0][i]==0)
                zeroColum=true;
            else
                i++;
        }
        
        //We now check every cell (except first row and column)to check if they are 0
        
        for(i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[i].length;j++)
            {
                //We use the first row and column to keep track of zeros in the matrix
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        //We check all rows (except first one) to set zeroes
        
        for(i=1;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        //We check all columns (except first one) to set zeroes
        
        for(i=1;i<matrix[0].length;i++)
        {
            if(matrix[0][i]==0)
            {
                for(int j=0;j<matrix.length;j++)
                {
                    matrix[j][i]=0;
                }
            }
        }
        
        
        //We now check if the first row and colum originally had zeroes before they were used for memory
        
        if(zeroRow)
        {
            for(i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        }
        
        
        if(zeroColum)
        {
            for(i=0;i<matrix[0].length;i++)
            {
                matrix[0][i]=0;
            }
        }
        
        return matrix;
        
    }
    
    public static void printMatrix(int[][] matrix)
    {
        for(int[] row : matrix)
        {
            for(int element : row)

            {
                System.out.print(element+" ");
            }
            
            System.out.println();
        }
        System.out.println();
    }

    public void setZeroesBetter(int[][] matrix) {
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int a:rows)
        {
            for(int j=0;j<matrix[a].length;j++){
                matrix[a][j]=0;
            }
        }
        
        
        for(int a:cols)
        {
            for(int j=0;j<matrix.length;j++){
                matrix[j][a]=0;
            }
        }
    }
    
    
    public static void setZeroesOriginal(int[][] matrix) {

        //Key is row and value is column
        HashMap<Integer, List<Integer>> map = new HashMap();

        //We store the row and column that is 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {

                    if (!map.containsKey(i)) {
                        map.put(i, new ArrayList());
                    }

                    map.get(i).add(j);

                }

            }
        }

        //Now we set them to 0
        for (Integer row : map.keySet()) {

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }

        }

        for (List<Integer> values : map.values()) {

            for (Integer colum : values) {
                for (int[] matrix1 : matrix) {
                    matrix1[colum] = 0;
                }
            }

        }

    }

}
