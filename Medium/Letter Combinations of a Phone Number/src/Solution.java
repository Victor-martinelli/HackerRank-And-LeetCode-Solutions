
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

Time complexity : 
O(3^N ×4^M) where N is the number of digits in the input that maps to 3 letters 
(e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 
4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

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
        
        String current = "23";
        String current2 = "575";
        
        System.out.println("Letter combinations for: "+current);
        
        System.out.print("Result: ");
        printList(letterCombinations(current));
        
        System.out.println("Letter combinations for: "+current2);
        
        System.out.print("Result: ");
        printList(letterCombinations(current2));
    }
    
     public static List<String> letterCombinations(String digits) {
        
        HashMap<Character,String[]> map = new HashMap();
        
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});
        
        //This will hold every possible character to create all the combinations
        List<List<String>> possibleCharacters = new ArrayList();
        
        int i=0;
        
        boolean finished=false;
        
        while(i<digits.length() && !finished)
        {
            
            char temp = digits.charAt(i);
            
            if(temp-'0' >1) //Every Number must be greater than 1
            {
                possibleCharacters.add(Arrays.asList(map.get(temp)));
                i++;
            }
            else
                finished=true;
            
            
        }
        
        if(!finished && digits.length()>0)
            return createCombinations(possibleCharacters,"",0);
        else
            return new ArrayList();
    }
    
    public static List<String> createCombinations(List<List<String>> possibleCharacter,String current,int nList)
    {
     
        List<String> result = new ArrayList();
     
        //We have not reached the end of the lists
        if(nList<possibleCharacter.size())
        {
            //We add a character of the current list and start the next one
            for(int i=0;i<possibleCharacter.get(nList).size();i++)
            {
                result.addAll(createCombinations(possibleCharacter,current + possibleCharacter.get(nList).get(i),nList+1));
            }
            
        }
        else
            result.add(current);
        
        return result;
    }
    
    public static void printList(List<String> lista)
    {
        for(String el : lista)
        {
            System.out.print(el+" ");
        }
        System.out.println(" ");
    }
    
}
