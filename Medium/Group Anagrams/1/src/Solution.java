
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
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
        String [] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        System.out.println("Initial Words");
        
        printRegularArray(words);
        
        System.out.println("Grouped Anagrams");
        
        printResult(groupAnagrams(words));
    }
    
    
    /*
    Every anagram must be equal when sorted, so we first sort the word and then
    put it in a group based on it
    */
     public static List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length>0)
        {
            
            HashMap<String,List<String>> result = new HashMap();
            
            for(String s : strs)
            {
                
                char [] temp = s.toCharArray();
                
                Arrays.sort(temp);
                
                String current = new String(temp);
                
                
                if(!result.containsKey(current))
                    result.put(current,new ArrayList());
                
                result.get(current).add(s);
                
                
            }
            
            return new ArrayList(result.values());
            
        }
        else
            return new ArrayList();
            
        
    }
    
    public static void printRegularArray(Object[] arr)
    {
        for(Object s : arr)
        {
            System.out.print(s+" ");
        }
        
        System.out.println("");
        System.out.println("");
    }
    
    public static void printResult(List<List<String>> lista)
    {
        for(List<String> temp : lista)
        {
            printRegularArray(temp.toArray());
        }
    }
     
}
