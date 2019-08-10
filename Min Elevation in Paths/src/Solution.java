
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        
        int [][] mat = {
            {6,1,6},
            {4,5,7},
            {2,3,8},
        };
        
        int [][] mat2 = {
            {5,1},
            {2,5},
        };
        
        System.out.println("The Maximum value in the minimum elevations is: "+maxOfMinElevations(mat[0].length,mat.length,mat));
        
        System.out.println("The Maximum value in the minimum elevations is: "+maxOfMinElevations(mat2[0].length,mat2.length,mat2));
        
    }
    
    public static int maxOfMinElevations(int columnCount, int rowCount,int [][] mat)
    {
        //We get a lists of all the possible paths, each one being a list too
        ArrayList<ArrayList<Integer>> paths = traverseMatrix(0,0,rowCount,columnCount,mat,new ArrayList<Integer>());
        
        ArrayList<Integer> mins = new ArrayList();
        
        //For each list, we get its minimum
        for(ArrayList<Integer> path: paths)
        {
            mins.add(Collections.min(path));
        }
        
        //We return the max of the minimums
        return Collections.max(mins);
    }
    
    public static ArrayList<ArrayList<Integer>>traverseMatrix(int currentRow,int currentColumn,int rowCount,
    int columnCount,int [][]mat,ArrayList<Integer> current)
    {
        //We add the current element
        current.add(mat[currentRow][currentColumn]);
        
        //We make lists to store every path that leads from this one
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        
        ArrayList<ArrayList<Integer>> down = new ArrayList();
        
        ArrayList<ArrayList<Integer>> right = new ArrayList();
        
        //If we can go down
        if(currentRow<rowCount-1)
        {
            //This is so that the current is not modified when it gets back
            //We get all the paths that are generated from this one
            down = traverseMatrix(currentRow+1,currentColumn,rowCount,columnCount,mat, (ArrayList<Integer>) current.clone());
        }
        
        //If we can go right
        if(currentColumn < columnCount-1)
        {
            right = traverseMatrix(currentRow,currentColumn+1,rowCount,columnCount,mat,(ArrayList<Integer>) current.clone());
        }
        
        //If we coudln´t do any moves
        if(down.isEmpty() && right.isEmpty())
        {
            result.add(current);
        }
        else //If we could do a move
        {
            result.addAll(down); 
            result.addAll(right);
        }
        
        return result;
    }
    
}
