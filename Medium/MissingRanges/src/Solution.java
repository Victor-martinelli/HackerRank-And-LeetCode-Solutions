
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
       int [] nums = {0, 1, 3, 50, 75};
    }
    
    public List<String> missingRanges(int[] arr, int lo,int hi)
    {
        List<String> result = new ArrayList();
        
        int current = lo;
        
        for(int i=0;i<arr.length;i++)
        {
            
            StringBuilder temp= new StringBuilder("");
            
            //Number in arr greater than current
            
            if(arr[i]>current)
            {
                int dif = arr[i] - current;
                
                if(dif!=1)
                {
                    if(current==0) //3-0 --> 2
                        temp.append(current+"->"+(dif+current-1));
                    else
                        temp.append(current+"->"+(dif+current));
                }
                else
                {
                    current++;
                    temp.append(current);
                }
                
                current=arr[i];
                
                result.add(temp.toString());
                
            }
            
            
        }
        
        return result;
    }
    
}
