
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
public class MinStackOriginal {
    private Stack pila;
    private int min;
    
    /** initialize your data structure here. */
    public MinStackOriginal() {
        pila = new Stack();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        pila.push(x);
        
        if(x<min)
            min=x;
        
    }
    
    public void pop() {
        
        if(!pila.empty())
        {
            int x = (int)pila.pop();

            if(x==min)
            {
                Stack temp = new Stack();

                int candidate=Integer.MAX_VALUE;

                int current;

                while(!pila.empty())
                {
                    current = (int)pila.pop();

                    if(current<candidate)
                        candidate=current;

                    temp.push(current);
                }


                min=candidate;

                while(!temp.empty())
                {
                    pila.push(temp.pop());
                }



            }
            
        }
        
    }
    
    public int top() {
        
        if(!pila.empty())
            return (int)pila.peek();
        else
            return -1;
    }
    
    public int getMin() {
        return min;
    }
}
