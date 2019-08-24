/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStackOriginal minStack = new MinStackOriginal();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
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
        MinStack stack = new MinStack();
        
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        
        System.out.println("Current Min: "+stack.getMin());
        
        stack.pop();
        
        System.out.println("Current Min: "+stack.getMin());
        
        stack.pop();
        
        System.out.println("Current Min: "+stack.getMin());
        
        stack.pop();
        
        System.out.println("Current Min: "+stack.getMin());
    }
    
}
