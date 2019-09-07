
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
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
        // TODO code application logic here
    }
    
     public boolean isValidSudoku(char[][] board) {
        
        Set map = new HashSet();
        
        int i=0;
        
        int j=0;
        
        boolean found=true;
        
        while(i<9 && found)
        {
            
            j=0;
            
            while(j<9 && found)
            {
                char number = board[i][j];
                
                if(number!='.')
                {
                    if(!map.add(number+" in row"+i) || !map.add(number+" in colum"+j) || !map.add(number+" in block "+i/3+"-"+j/3))
                    {
                        found=false;
                    }
                }
                j++;
            }
            i++;
        }
        
        
        return found;
    }
    
    public static boolean isValidSudokuOriginal(char[][] board) {
        
        HashMap map = new HashMap(board.length);
        
        boolean found=true;
        
        int i=0;
        
        //Rows
            
        while(i<board.length && found)
        {
            int j=0;
            
            map.clear();
            
            while(j<board.length && found)
            {
                if(map.containsKey(board[i][j]))
                {
                   found=false; 
                }
                else if(board[i][j]!='.')
                {
                    map.put(board[i][j],board[i][j]);
                }
                
                j++;
            }
            i++;
        }
        
        
        //Columns
        
        i=0;
        
        while(i<board.length && found)
        {
            int j=0;
            
            map.clear();
            
            while(j<board.length && found)
            {
                if(map.containsKey(board[j][i]))
                {
                   found=false; 
                }
                else if(board[j][i]!='.')
                {
                    //System.out.println("Hello");
                    map.put(board[j][i],board[j][i]);
                }
                
                j++;
            }
            i++;
        }
        
        //Grid
        
        int count=0;
        
        i=0;
        
        int j=0;
        
        int startJ=0;
        
        int startI=0;
        
        int endI=3;
        
        int endJ=3;
        
        while(count<9 && found)
        {
            
            map.clear();
            
            if(count!=0 && count%3==0)
            {
                startJ=0;
                endJ=3;
                startI+=3;
                endI+=3;
                //System.out.println("Hello");
            }
            
            //System.out.println("Before Starting Row: "+i);
            i=startI;
            //System.out.println("After StartI: "+i);
            
            while(i<endI && found)
            {
                
                j=startJ;
                
                //System.out.println("Count: "+count);
                
                while(j<endJ && found)
                {
                    //System.out.println("Row: "+i+" Column: "+j);
                    
                    if(map.containsKey(board[i][j]))
                    {
                       found=false; 
                    }
                    else if(board[i][j]!='.')
                    {
                        map.put(board[i][j],board[i][j]);
                    }

                    j++;
                }
                i++;
            }
            count++;
            endJ+=3;
            startJ+=3;
            
        }
        
        return found;
    }
    
}
