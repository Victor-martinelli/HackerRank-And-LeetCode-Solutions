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
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        int[][] matrix2 = {
            {1,6,6,9,14,14,17},{5,8,9,9,14,17,18},{5,10,11,12,18,18,20},
                {5,15,16,16,20,23,27},{7,15,19,21,22,24,31},{12,16,22,22,24,25,34},
                {16,21,23,26,26,30,37},{18,25,25,30,33,36,37},{22,30,31,33,34,39,42}
        };

        int[][] matrix3 = {
            {1,2,3,4,5}
        };
        
        int target = 5;

        searchMatrix(matrix2, target);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //We go though the matrix in a diagonal and checking the ends of the row and column to 
        //Check if the searched element can be there. If it can be there we binary search the row and column

        boolean found = false;

        int i = 0;

        while(i<matrix.length && !found)
       {
           
           //If the current element in diagonal is the target or any of the limits are the target
           
           //if(matrix[i][i]==target || matrix[matrix.length-1][i]==target || matrix[i][matrix[0].length-1]==target)
           if((i<matrix[i].length && i<matrix.length && matrix[i][i]==target) //Check if the target is in diag
                || (i<matrix[i].length && matrix[matrix.length-1][i]==target) //Check if target is at the end of the current column
                || (i<matrix.length && matrix[i][matrix[0].length-1]==target)) //Check if target is at the end of the current row
               found=true;
           if(!found && i<matrix.length && matrix[i][matrix[0].length-1]>target) //If the target could be within the current row
               found = binarySearch(matrix,i,i,matrix[0].length-1,target,true);
           if(!found && i<matrix[i].length && matrix[matrix.length-1][i]>target) //If we still didn't find the target and the target could be within the current column
                found = binarySearch(matrix,i,i,matrix.length-1,target,false);
           i++;
       }
        return found;
    }

    public static boolean binarySearch(int[][] matrix, int i, int left, int right, int target, boolean isRow) {

        boolean found = false;

        if (isRow) {
            while (!found && left < right) {
                int mid = left + (right - left) / 2;

                if (matrix[i][mid] == target) {
                    found = true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            if(matrix[i][left]==target)
                found=true;
            
        } else {
            while (!found && left < right) {
                int mid = left + (right - left) / 2;

                if (matrix[mid][i] == target) {
                    found = true;
                } else if (matrix[mid][i] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if(matrix[left][i]==target)
                found=true;
            
        }

        return found;
    }

}
