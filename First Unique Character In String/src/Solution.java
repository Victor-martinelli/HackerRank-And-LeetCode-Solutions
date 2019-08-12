/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
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
        String test ="leetcode";
        
        String test2="loveleetcode";
        
        
        System.out.println("The index of the first non-repeating character in the string "+test+" is: "+firstUniqChar(test));
        
        System.out.println("The index of the first non-repeating character in the string "+test2+" is: "+firstUniqChar(test2));
        
    }
    
    public static int firstUniqChar(String s) {

        int min = Integer.MAX_VALUE;
        
        //Instead of going through the string, we go through all the letters.
        //This is very quick in cases of large inputs
        for(char current ='a'; current<= 'z';current++)
        {
            int firstIndex = s.indexOf(current);
            
            int lastIndex = s.lastIndexOf(current);
            
            if(firstIndex!=-1 && firstIndex==lastIndex)
            {
                //Min index
                min = Math.min(min,firstIndex);
            }
            
        }
        
        if(min==Integer.MAX_VALUE)
        {
            min=-1;
        }
        
        return min;
    }
    
}
