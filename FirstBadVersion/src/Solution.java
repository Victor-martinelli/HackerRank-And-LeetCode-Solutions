/*
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    static int badVersion=4;
    
    public static void main(String[] args) {
        
        int total = 5;
        
        System.out.println("What is the first bad version from "+total+" ?: "+firstBadVersion(total));
    }
    
     public static int firstBadVersion(int n) {
       
        int start =1;
        
        int end =n;
        
        while(start<end)
        {
            
            /*
            
            Before this problem, I have always use

              mid = (start+end)) / 2;
              To get the middle value, but this can caused OVERFLOW !

              when start and end are all about INT_MAX , then (start+end) of course will be overflow !

              To avoid the problem we can use

              mid =  start+(end-start)/2;
            
            */
            int middle = start + (end-start)/2;
            
            if(!isBadVersion(middle))
                start=middle+1;
            else
                end=middle;
            
        }
       
        return start;
    }
     
    public static boolean isBadVersion(int candidate)
    {
        return badVersion==candidate;
    }
    
}
