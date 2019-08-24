
import java.util.ArrayList;
import java.util.List;

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
        int n=15;
        
        List<String> result = fizzBuzz(n);
        
        System.out.println("FizzBuzz Sequence");
        
        printList(result);
        
    }
    
    
     public static List<String> fizzBuzz(int n) {
        
        List<String> result = new ArrayList();
        
        for(int i=1;i<=n;i++)
        {
            StringBuilder current=new StringBuilder("");
            
            if(i%3==0)
            {
                current.append("Fizz");
            }
            
            if(i%5==0)
            {
                current.append("Buzz");
            }
            
            if(current.toString().equals(""))
            {
                current.append(i);
            }
            
            result.add(current.toString());
            
        }
        
        return result;
    }
    
    public static void printList(List<String> lista)
    {
        
        for(String item : lista)
        {
            System.out.print(item+" ");
        }
        System.out.println();
    }
    
}
