
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
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
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        
        System.out.println("Original Intervals: ");
        printMatrix(intervals);
        
        System.out.println("Result: ");
        printMatrix(merge(intervals));
    }
    
     public static int[][] merge(int[][] intervals) {

        //If the array is not null or if the size is not 0

         if(intervals!=null && intervals.length!=0)
         {
             
             //We sort the array
              Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                }
            });
             
            //Solution list
             List<int[]> result = new ArrayList();
             
             //First interval as a reference
             int[] current = intervals[0];
             
             //We go through the entire array trying to find overlapping intervals
             
             for(int i=1;i<intervals.length;i++)
             {
                 //if it overlaps
                 if(intervals[i][0]<=current[1])
                 {
                     //We update the end of the interval
                     current[1] = Math.max(intervals[i][1],current[1]);
                 }
                 else //No overlap
                 {
                     //We save the current interval in the solution
                     result.add(current);
                     current = intervals[i];
                 }
             }
             
             //Add the last interval
             result.add(current);
             
             //Return result (This indicates how the array will be structures)
             return result.toArray(new int[result.size()][2]);
             
         }
         else
             return intervals;
         
    }
    

   public static int[][] mergeOriginal(int[][] intervals) {
        
        if(intervals.length!=0)
        {
            //Sort
            java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
            }
            }); 
     
            //At worst, the matrix will stay the same
            int[][] result = new int[intervals.length][intervals[0].length];
            
            //We go through the entire matrix to find the new intervals
            
            int i=0;
            int resultIndex=0;
            
            while(i<intervals.length)
            {
                //If there is no next interval to compare
                if(i+1>=intervals.length)
                {
                    //We simply add it
                    
                    result[resultIndex][0] = intervals[i][0];
                    result[resultIndex][1] = intervals[i][1];

                    i++;
                }
                else
                {
                    //We try to find an interval
                    int max=intervals[i][1];
                    int min = intervals[i][0];
                    
                    //While max is greater than the current i min and we dont go beyond the array
                    while(i<intervals.length && max>=intervals[i][0])
                    {
                        //Max will be the max between the current max and the current i max
                        max=Math.max(max,intervals[i][1]);
                        
                        i++;
                    }
                    
                    result[resultIndex][0] = min;
                    result[resultIndex][1] = max;
                    
                }
                resultIndex++;
            }
            
            //We check if we made the result array too big
            if(resultIndex<intervals.length)
            {
                //We make a new array with the correct size and return it
                
                int[][] newResult = new int[resultIndex][2];
                
                for(i=0;i<resultIndex;i++)
                {
                    newResult[i][0] = result[i][0];
                    newResult[i][1] = result[i][1];
                }
                return newResult;
            }
            else
                return result;
            
        }
        else
            return new int[0][0];
        
    }

    public static void printMatrix(int[][] mat)
    {
        for(int[]row : mat)
        {
            for(int el : row)
            {
                System.out.print(el+" ");
            }
            System.out.println("");
        }
    }
   
}
