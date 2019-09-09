
import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
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
       
       int [] nums2 = {2,10};
       
       printRanges(nums,0,99);
       
       printMissingRanges(missingRanges(nums,0,99));
       
       printRanges(nums2,0,10);
       
       printMissingRanges(missingRanges(nums2,0,10));
       
       printRanges(nums2,5,11);
       
       printMissingRanges(missingRanges(nums2,5,11));
       
    }
    
    public static List<String> missingRangesAnother(int[] arr,int lower,int upper)
    {
        //This is to avoid overflow
        
        long l = (long)lower;
        long u = (long)upper;
        
        List<String> res = new ArrayList();
        
        //There are no elements
        if(arr.length==0)
        {
            res.add(generateRange(l-1,u+1));
        }
        else
        {
            //We check the first range
            
            res.add(generateRange(l-1,arr[0]));
            
            //We keep doing it for the rest of the array
            
            for(int i=1;i<arr.length;i++)
            {
                res.add(generateRange(arr[i-1],arr[i]));
            }
            
            //Generate the last range
            res.add(generateRange(arr[arr.length-1],u+1));
        }
            
        return res;
    }
    
    
    public static String generateRange(long lo,long hi)
    {
        
        StringBuilder temp=new StringBuilder("");
        
        //If there are one number away
        if(lo+1 == hi-1)
        {
            temp.append(lo+1);
        }
        else if(lo!=hi && lo+1!=hi) // If there are more than one number away
        {
            temp.append(lo+1).append("->").append(hi-1);
        }
        return temp.toString();
    }
    
    
    public static List<String> missingRanges(int[] arr, int lo,int hi)
    {
        List<String> result = new ArrayList();
        
        int current = lo;
        
        boolean changed=false;
        
        for(int i=0;i<arr.length;i++)
        {
            
            StringBuilder temp= new StringBuilder("");
            
            //Number in arr greater than current
            
            if(arr[i]>current)
            {
                int dif = arr[i] - current;
                
                if(dif!=1)
                {
                    if(dif==2)
                    {
                        if(current!=0)
                            temp.append(arr[i]-1);
                        else
                            temp.append(current).append("->").append(arr[i]-1);
                    }
                    else
                    {
                        //First time that runs
                        if(changed)
                            temp.append(current+1).append("->").append(arr[i]-1);
                        else
                            temp.append(current).append("->").append(arr[i]-1);
                    }
                    
                    result.add(temp.toString());
                }
                
                changed=true;
                current=arr[i];
 
            }
            
            
        }
        
        //If there are still missing ranges
        if(current<hi)
        {
            int dif = hi - current;
            
            StringBuilder temp= new StringBuilder("");
            
             if(dif==2)
                temp.append(hi-current);
            else if(dif==1)
                 temp.append(hi);
            else
                temp.append(current+1).append("->").append(hi);
            
             
            result.add(temp.toString()); 
        }
        
        
        return result;
    }
    
    public static void printRanges(int[] nums,int lo, int hi)
    {
        System.out.print("Low: "+lo+" High: "+hi+" - ");
        
        for(int num : nums)
        {
            System.out.print(num+" ");
        }
        
        System.out.println();
        
    }
    
    public static void printMissingRanges(List<String> mRanges)
    {
        
        System.out.print("Missing Ranges: ");
        
        for(String range: mRanges)
        {
            System.out.print(range+" ");
        }
        
        System.out.println();
    }
    
}
