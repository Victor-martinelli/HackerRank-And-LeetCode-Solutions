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
    
    // For each of the "m" operations, we do not want to take O(n) time to 
    //process it. That's because our runtime will end up being O(nm). 
    //To get a O(n+m) runtime, we have to process each operation in O(1) time. 
    //To do so, we keep track of just the endpoints, which are just 2 numbers, 
    //instead of the O(n) numbers in between the endpoints. This is the main idea 
    //to decrease our runtime.

    // For a value "k", we can mark its left endpoint "a" in the original array, 
    //along with its right endpoint "b" in the original array. To distinguish 
    //between "a" and "b" we can store "+k" for "a" and "-k" for "b". Now, we 
    //technically have stored all information that the "m" operations represent, 
    //into an array. Most importantly, we stored it in O(m) time.

    // The next step is to actually find the maximum value based off of our 
    //unique representation of the data. We traverse our array from left to right. 
    //Whenever we reach a left endpoint "a" (which we represented with a 
    //positive number), we just add that to our sum. Whenever we reach a right 
    //endpoint "b" (which we represented with a negative number), we subtract 
    //that from our sum (well, technically we add a negative value). By doing so, 
    //the value "sum" represents the value that array[i] would have if we had 
    //applied all "m" operations to it. The maximum value of "sum" that we get 
    //while traversing the array is the value we return. If this algorithm is still 
    //unclear to you, try walking through HackerRank's sample input (Testcase 0) with the code below.

    public static void main(String[] args) {
        
        int [][] queries = {
    
        {1,2,100},
        {2,5,100},
        {3,4,100}
    };
        
        System.out.println(arrayManipulation(5,queries));
    }
    
    public static long arrayManipulation(int n, int [][] queries)
    {
        long [] arr = new long[n+1];
        
        long result=0;
        
        
        for(int i=0;i<queries.length;i++)
        {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            
            arr[a-1]+=k;
            arr[b]-=k;
        }
        
        long sum=0;
        
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            result = Math.max(result, sum);
        }
        
        
        return result;
    }
    
}
