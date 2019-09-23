/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where 
"adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

/**
 *
 * @author victormartinelli
 */
public class Solution {

    
    public static boolean[][] visited;
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        char[][] board = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','b'}};
        
        String word = "aaaaaaaaaaaaaaaaaaaa";
        
        System.out.println("Board: ");
        
        printBoard(board);
        
        System.out.println("Can the order: "+word+" be fulfilled? : "+exist(board,word));
        
        char [][] board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        
        String word2 = "ABCCED";
        
        String word3 = "SEE";
        
        String word4 = "ABCB";
        
        System.out.println("Board 2: ");
        
        printBoard(board2);
        
        System.out.println("Can the order: "+word2+" be fulfilled? : "+exist(board2,word2));
        
        System.out.println("Can the order: "+word3+" be fulfilled? : "+exist(board2,word3));
        
        System.out.println("Can the order: "+word4+" be fulfilled? : "+exist(board2,word4));
    }
    
    
    public static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        /* ensure all the nodes will be searched as the beginning point */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(int row, int col, int index, char[][] board, String word) {
        /*  1. out of bound 
            2. already visited
            3. not match    */
        if (checkBound(row, col, board) == -1 || 
            visited[row][col] || 
            word.charAt(index) != board[row][col]) {
            return false;
        }
        
        /* find one matched character, mark the current node as visited */
        visited[row][col] = true;
        
        /* found the whole word! */
        if (index == word.length() - 1) {
            return true;
        }
        
        /* continue searching the next char by extending the index of string,
        note that the current char may not belong to the word in the final.
        even though it matches until now */
        index++;
    
        /* down, right, up, left search */
        if (dfs(row + 1, col, index, board, word) ||
            dfs(row, col + 1, index, board, word) ||
            dfs(row - 1, col, index, board, word) ||
            dfs(row, col - 1, index, board, word)) {
                return true;
            }
        
        /* current position is wrong, backtracking */
        visited[row][col] = false;
        return false;
    }
    
    private static int checkBound(int row, int col, char[][] board) {
        if (row == -1 || row == board.length || col == -1 || col == board[0].length) {
            return -1;
        }
        return 0;
    }
    
    
     public static boolean existOriginal(char[][] board, String word) {
        
        
        
        //We first check if the first letter is found
        
        boolean finished=false;
        
        if(word.length()>0 && board.length>0 && board.length * board[0].length >= word.length())
        {
            char first = word.charAt(0);

            int i=0;

            int j=0;

            while(i<board.length && !finished)
            {

                j=0;

                while(j<board[i].length && !finished)
                {
                    if(board[i][j]==first)
                    {

                        int[][] matrix = new int[board.length][board[0].length];

                        matrix[i][j] = 1;                        
                        
                        //If we find a letter, we look through its neighbours but we dont stop the search
                        finished = canBeCompleted(board,word.substring(1),matrix,i,j);

                    }
                    j++;
                }
                i++;
            }
        }
        
        return finished;
        
    }
    
    public static boolean canBeCompleted(char[][] board,String remainWord,int[][] selectedPositions,int i,int j)
    {
        
        boolean found=false;
        
        //We look through the adjacent cells to see if there is a match
        
        if(remainWord.length()!=0)
        {
            
            char current = remainWord.charAt(0);
            
            //Up
            if(i-1>=0 && board[i-1][j]==current && selectedPositions[i-1][j]==0)
            {
                //System.out.println("Going Up");
                
                selectedPositions[i-1][j]=1;
                
                found = canBeCompleted(board,remainWord.substring(1),selectedPositions,i-1,j);
                
                selectedPositions[i-1][j]=0;
                
            }
            
            
            //Down
            
            if(!found && i+1<board.length && board[i+1][j]==current && selectedPositions[i+1][j]==0)
            {
                
                //System.out.println("Going Down");
                
                  selectedPositions[i+1][j]=1;

                 found = canBeCompleted(board,remainWord.substring(1),selectedPositions,i+1,j);
                
                selectedPositions[i+1][j]=0;
            }
            
             //Left
            
            if(!found && j-1>=0 && board[i][j-1]==current && selectedPositions[i][j-1]==0)
            {
                //System.out.println("Going Left");
                
                 selectedPositions[i][j-1]=1;

                 found = canBeCompleted(board,remainWord.substring(1),selectedPositions,i,j-1);
                
                selectedPositions[i][j-1]=0;
            }
            
             //Right
            
            if(!found && j+1<board[i].length && board[i][j+1]==current && selectedPositions[i][j+1]==0)
            {
                //System.out.println("Going Right");
                
                selectedPositions[i][j+1]=1;

                 found = canBeCompleted(board,remainWord.substring(1),selectedPositions,i,j+1);
                
                selectedPositions[i][j+1]=0;
            }
            
        }
        else
            found=true;
        
        return found;
        
    }
    
    public static void printBoard(char[][] board)
    {
        for(char[] row : board)
        {
            for(char el : row)
            {
                System.out.print(el+" ");
            }
            System.out.println("");
        }
    }
    
}
