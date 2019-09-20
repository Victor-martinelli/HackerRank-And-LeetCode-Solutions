/*
 * 

    TEST CASES 

    0000000
    0000000
    0000000
    0000000
    0000000
    0000000
    0111100     

    0000000
    0000000
    0000000
    0000100
    0000100
    0000100
    0000100

    0000000
    0000000
    0000000
    0000010
    0000120
    0001220
    0012220

 */

/**
 *
 * @author Portatil
 */
public class Solution {

    /*
        Board for the entire game.
    
        0 --> Empty Space
        1 --> Player 1 Disc
        2 --> Player 2 Disc
    
    */
    public static int[][] board = new int[6][7];
    
    public static void main(String[] args) {
        
        dropDisc(2,1);
        
        printBoard();
        
        dropDisc(3,1);
        
        printBoard();
        
        dropDisc(2,2);
        
        printBoard();
        
        int [] temp = dropDisc(2,2);
        
        printBoard();
        
        System.out.println("Is player 2 a winner?: "+isWinner(temp[0],temp[1],2));
        
        dropDisc(2,2);
        
        printBoard();
        
        temp = dropDisc(2,2);
        
        printBoard();
        
        System.out.println("Is player 2 a winner?: "+isWinner(temp[0],temp[1],2));
        
        dropDisc(4,1);
        
        printBoard();
        
        temp = dropDisc(5,1);
        
        printBoard();
        
        System.out.println("Is player 1 a winner?: "+isWinner(temp[0],temp[1],1));
        
        //Diag
        board = new int[6][7];
        
        dropDisc(2,1);
        
        dropDisc(3,2);
        
        dropDisc(3,1);
        
        dropDisc(4,2);
        
        dropDisc(4,2);
        
        dropDisc(4,1);
        
        dropDisc(5,2);
        
        dropDisc(5,2);
        
        dropDisc(5,2);
        
        temp = dropDisc(5,1);
        
        printBoard();
        
        System.out.println("Is player 1 a winner?: "+isWinner(temp[0],temp[1],1));
        
        
        //Diag
        board = new int[6][7];
        
        dropDisc(0,2);
        
        dropDisc(0,2);
        
        dropDisc(0,2);
        
        dropDisc(0,1);
        
        dropDisc(1,2);
        
        dropDisc(1,2);
        
        dropDisc(1,1);
        
        dropDisc(2,2);
        
        dropDisc(2,1);
        
        temp = dropDisc(3,1);
        
        printBoard();
       
        
        System.out.println("Is player 1 a winner?: "+isWinner(temp[0],temp[1],1));
        
    }
    
    //Check if the current player is a winner
    
    public static boolean isWinner(int row,int col, int player)
    {
        return checkHorizontal(row,col,player) || 
               checkVertical(row,col,player) || 
               checkDiagonalTopRightBottomLeft(row,col,player) || 
               checkDiagonalTopLeftBottomRight(row,col,player);
    }
    
    //We check if the player won by horizontal discs
    public static boolean checkHorizontal(int row,int col, int player)
    {
        
        int count=0;
        
        int i=col;
        
        boolean finished=false;
     
        
        //We first check to the left of the current position
        while(i>=0 && count!=4 && !finished)
        {
            if(board[row][i]==player)
            {
                count++;
                i--;
            }
            else //If the piece is not ours, we simply stop
                finished=true;
        }
        
        //If we have not finished, we look to the right of the current position
        
        if(count!=4)
        {
            
            i=col+1;
        
            finished=false;
            
            while(i<=board[0].length && count!=4 && !finished)
            {
                if(board[row][i]==player)
                {
                    count++;
                    i++;
                }
                else //If the piece is not ours, we simply stop
                    finished=true;
            }
            
            
        }
        
        
        return count==4;
    }
    
    //We check if the player won by vertical discs
    public static boolean checkVertical(int row,int col, int player)
    {
        
        int count=0;
        
        int i=row;
        
        boolean finished=false;
     
        
        //We first check up of the current position
        while(i>=0 && count!=4 && !finished)
        {
            if(board[i][col]==player)
            {
                count++;
                i--;
            }
            else //If the piece is not ours, we simply stop
                finished=true;
        }
        
        //If we have not finished, we look down of the current position
        
        if(count!=4)
        {
            
            i=row+1;
        
            finished=false;
            
            while(i<board.length && count!=4 && !finished)
            {
                if(board[i][col]==player)
                {
                    count++;
                    i++;
                }
                else //If the piece is not ours, we simply stop
                    finished=true;
            }
            
            
        }
        
        
        return count==4;
    }
    
    //We check if the player won by diagonal discs
    public static boolean checkDiagonalTopRightBottomLeft(int row,int col, int player)
    {
        
        int count=0;
        
        int i=row;
        
        int j=col;
        
        boolean finished=false;
     
        
        //We first check up of the current position diagonally
        while(i>=0 && j<board[0].length && count!=4 && !finished)
        {
            if(board[i][j]==player)
            {
                count++;
                i--;
                j++;
            }
            else //If the piece is not ours, we simply stop
                finished=true;
        }
        
        //If we have not finished, we look down of the current position diagonally
        
        if(count!=4)
        {
            
            i=row+1;
            
            j=col-1;
        
            finished=false;
            
            while(i<board.length && j>=0 && count!=4 && !finished)
            {
                
                if(board[i][j]==player)
                {
                    count++;
                    i++;
                    j--;
                }
                else //If the piece is not ours, we simply stop
                    finished=true;
            }
            
            
        }
        
        
        return count==4;
    }
    
    //We check if the player won by diagonal discs
    public static boolean checkDiagonalTopLeftBottomRight(int row,int col, int player)
    {
        
        int count=0;
        
        int i=row;
        
        int j=col;
        
        boolean finished=false;
     
        
        //We first check up of the current position diagonally
        while(i>=0 && j>=0 && count!=4 && !finished)
        {
            if(board[i][j]==player)
            {
                count++;
                i--;
                j--;
            }
            else //If the piece is not ours, we simply stop
                finished=true;
        }
        
        //If we have not finished, we look down of the current position diagonally
        
        if(count!=4)
        {
            
            i=row+1;
            
            j=col+1;
        
            finished=false;
            
            while(i<=board[0].length && j<board[0].length && count!=4 && !finished)
            {
                if(board[i][j]==player)
                {
                    count++;
                    i++;
                    j++;
                }
                else //If the piece is not ours, we simply stop
                    finished=true;
            }
            
            
        }
        
        
        return count==4;
    }
    
    //Returns the positions of the disc that was inserted
    public static int[] dropDisc(int col,int player)
    {
        
        int[] result = new int[2];
        
        result[0]=-1;
        result[1]=-1;
        
        //Check if column is within the limits
        if(col>=0 && col<board[0].length)
        {
         
            boolean finished=false;
            
            int i=board.length-1;
            
            //We try to find the position where the disc will be inserted
            
            while(i>=0 && !finished)
            {
                //If we found it
                if(board[i][col]==0)
                {
                    board[i][col]=player;
                    
                    result[0]=i;
                    result[1]=col;
                    
                    finished=true;
                    
                }
                else
                    i--;
            }
            
        }
        
        return result;
    }
    
    
    public static void printBoard()
    {
        for(int[] row : board)
        {
            for(int elem : row)
            {
                System.out.print(elem);
            }
            System.out.println("");
        }
        
        System.out.println("");
    }
    
}
