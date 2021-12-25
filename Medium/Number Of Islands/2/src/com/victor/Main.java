package com.victor;

public class Main {

    private char[][] mainGrid;

    /**
     * Time Complexity O(mxn)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        mainGrid = grid;

        int result = 0;

        //Go through the entire grid to find all the islands

        for(int i=0;i<mainGrid.length;i++){
            for(int j=0;j<mainGrid[i].length;j++){
                //If the current position is an undiscovered island

                if(mainGrid[i][j]=='1'){
                    //Count is as solution and look around it to find all the land
                    result++;
                    mainGrid[i][j]='2';

                    //Look in all directions in order to find the rest of the island
                    lookForIslandParts(i-1,j); //Up
                    lookForIslandParts(i+1,j); //Down
                    lookForIslandParts(i,j+1); //Left
                    lookForIslandParts(i,j-1); //Right
                }
            }
        }


        return result;
    }


    public void lookForIslandParts(int i,int j){
        //Is the current position land and if it's valid
        if(i>=0 && i<mainGrid.length && j>=0 && j<mainGrid[0].length && mainGrid[i][j]=='1'){
            //Mark as visited
            mainGrid[i][j]='2';
            //Look in all directions
            lookForIslandParts(i-1,j); //Up
            lookForIslandParts(i+1,j); //Down
            lookForIslandParts(i,j+1); //Left
            lookForIslandParts(i,j-1); //Right
        }
    }
}
