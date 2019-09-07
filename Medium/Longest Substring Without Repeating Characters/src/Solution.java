
import java.util.HashMap;
import java.util.HashSet;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
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
        String word = "anviaj";
        
        System.out.println("Word: "+word+" - Length of Longest Substring: "+lengthOfLongestSubstring(word));
        
    }
    
     public static int lengthOfLongestSubstring(String s) {
       
        int start=0;
        
        int end=0;
        
        int max=0;
        
        HashMap<Character,Integer> map = new HashMap();
        
        while(start<=end && end<s.length())
        {
            
            char current = s.charAt(end);
            
            if(map.containsKey(current))
                start = Math.max(map.get(current),start);
            
            //+1 to know the number of elements currently there
            max = Math.max(max,end-start+1);
            
            map.put(current,end+1);
            
            end++;
            
        }
       
        
        return max;
    }
    
    public static int lengthOfLongestSubstringOriginal(String s) {
        
        HashSet<Character> map = new HashSet();
        
        int maxCount=0;
        
        int currentCount=0;
        
        int i=0;
        
        int start=0;
        
        while(i<s.length())
        {
         
            char temp = s.charAt(i);
            
            if(!map.contains(temp))
            {
                currentCount++;
                map.add(temp);
                i++;
            }
            else
            {
                map=new HashSet();
                
                maxCount = Math.max(currentCount,maxCount);
                
                currentCount=0;
                
                start+=1;
                
                i=start;
                
            }
            
        }
        return Math.max(currentCount,maxCount);
    }
    
    
}
