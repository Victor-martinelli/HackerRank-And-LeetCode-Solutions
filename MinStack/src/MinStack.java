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
