/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class MinStack {

    private Node head;
    
    public void push(int x) {
        
        if(head==null)
        {
            head = new Node(x);
            
        }
        else
        {
            
            //Each node holds the min element up to that point
            Node nextNode = new Node(x);
            
            nextNode.min = Math.min(head.min,nextNode.min);
            
            nextNode.next = head;
            
            head = nextNode;
            
        }
        
    }
    
    public void pop() {
        
        head = head.next;
        
    }
    
    public int top() {
        
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}

/*
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
*/