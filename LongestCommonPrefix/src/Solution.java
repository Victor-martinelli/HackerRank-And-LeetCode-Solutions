/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
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
        String [] test = {"flower","flow","flight"};
        
        System.out.println("The longest common prefix is: "+longestCommonPrefix(test));
        
    }
    
     public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        //We start with the whole string
        String common = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(common)) {
                //We shrink the string every time that there isn't a match
                common = common.substring(0, common.length() - 1);
            }
        }
        
        return common;
    }
    
    
    public static String longestCommonPrefixOriginal(String[] strs) {
        
        String result="";
        
        if(strs.length>0)
        {
            int start=0;

            int finish=0;

            boolean finished=false;

            while(finish<strs[0].length() && !finished)
            {

                char temp = strs[0].charAt(finish);
                
                int count=0;

                while(count<strs.length && !finished)
                {
                    if(strs[count].isEmpty() || finish>=strs[count].length() || strs[count].charAt(finish)!=temp)
                    {
                        finished=true;
                    }
                    else
                        count++;
                }
                
                if(!finished)
                    finish++;
            }
            
            if(finish>0)
            {
                result=strs[0].substring(start,finish);
            }

            return result;

        }
        else
            return "";
    }
    
    
}
