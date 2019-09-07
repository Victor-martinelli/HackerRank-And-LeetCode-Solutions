
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        
        String test = "([)]";
        
        
        System.out.println("Does the string "+test+" contain valid parenthesis?: "+isValid(test));
    }
    
    
    public static boolean isValid(String s) {
        
        Stack<Character> pila = new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            
            char current = s.charAt(i);
            
            if(current=='{')
                pila.push('}');
            else if(current=='(')
                pila.push(')');
            else if(current=='[')
                pila.push(']');
            else if(pila.empty() || current!=pila.pop())
                return false;
            
        }
        
        return pila.empty();
    }
    
    public static boolean isValidOriginal(String s) {
        
        boolean result=true;
        
        Stack<Character> pila = new Stack();
        
        int i=0;
    
        while(result && i<s.length())
        {
            
            char current  = s.charAt(i);
            
            if(current=='(' || current=='[' || current=='{')
            {
                pila.push(current);
            }
            else if(current==')' || current==']' || current=='}')
            {
                
                char expected;
                
                
                if(current==')')
                {
                    expected='(';
                }
                else if(current==']')
                {
                    expected='[';
                }
                else
                    expected='{';
                
                
                if(!pila.empty() && pila.peek()==expected)
                {
                    pila.pop();
                }
                else
                    result=false;
                
            }
            else
                result=false;
            
            i++;
        }
        
        
        if(!pila.empty())
            result=false;
        
        
        return result;
    }
    
}
