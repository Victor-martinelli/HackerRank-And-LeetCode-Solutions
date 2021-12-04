/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    private static int start;
    
    private static int maxLength;
    
    public static void main(String[] args) {
    }
    
     public static String longestPalindrome(String s) {
        
        if(s.length()<2)
            return s;
    
        for(int i=0;i<s.length();i++)
        {
            expandPalindrome(s,i,i); //Odd Cases
            expandPalindrome(s,i,i+1); //Even Cases
        }
        
        return s.substring(start,start+maxLength);
    }
    
    //We expand the palindrome from the center
    public static void expandPalindrome(String s, int startIndex, int endIndex)
    {
        
        //While they are the same and we don't jump off the limits of the string
        while(startIndex>=0 && endIndex<s.length() && s.charAt(startIndex)==s.charAt(endIndex))
        {
            startIndex--;
            endIndex++;
        }
        
        //If we have a new max
        if(maxLength< endIndex - startIndex -1)
        {
            //To return to the previous position
            start = startIndex+1;
            maxLength = endIndex - startIndex -1;
        }
        
    }
    
}
