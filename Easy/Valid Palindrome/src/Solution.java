/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false
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
        String s = "A man, a plan, a canal: Panama";
        
        System.out.println("Is the string "+s+" a palindrome?: "+isPalindrome(s));
    }
    
    
     public static boolean isPalindrome(String s) {
        
        int i=0;
        
        int j=s.length()-1;
            
        boolean result=true;
        
        
        while(i<j && result)
        {
            
            char first=s.charAt(i);
            
            if(Character.isLetterOrDigit(first))
            {
                char last = s.charAt(j);
                
                if(Character.isLetterOrDigit(last))
                {
                    
                    if(Character.toLowerCase(first)!=Character.toLowerCase(last))
                    {
                        //System.out.println(first+" "+last);
                        result=false;
                    }
                    else
                    {
                        i++;
                        j--;
                    }
                    
                }
                else
                    j--;
                
            }
            else
                i++;
            
        }
        
        return result;
    }
}
