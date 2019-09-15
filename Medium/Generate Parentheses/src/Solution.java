
import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]



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
        int n1=3;
        int n2=5;
        
        System.out.println("Result for "+n1+" parenthesis: ");
        printList(generateParenthesis(n1));
        
        System.out.println("Result for "+n2+" parenthesis: ");
        printList(generateParenthesis(n2));
    }
    
    public static List<String> generateParenthesis(int n) {
        
        if(n>1)
            return generateCombination(n,1,0,"(",1);
        else if(n==1)
        {
            List<String> result = new ArrayList();
            result.add("()");
            return result;
        }
        else
            return new ArrayList();
    }
    
    public static List<String> generateCombination(int total,int open,int close,String current,int currentLength)
    {
        List<String> result = new ArrayList();
        
        //If we are not done with the current string
        if(currentLength<total*2)
        {
            
            //If there are still parenthesis to be oppened
            if(open<total)
                result.addAll(generateCombination(total,open+1,close,current+"(",currentLength+1));
            
            if(close<open)//We also create a branch to close a parenthesis if needed to keep the balance
                result.addAll(generateCombination(total,open,close+1,current+")",currentLength+1));
            
        }
        else if(currentLength==total*2)//If we are done
            result.add(current);
        
        return result;
    }
    
    public static void printList(List<String> lista)
    {
        for(String el : lista)
        {
            System.out.println(el);
        }
    }
    
}
