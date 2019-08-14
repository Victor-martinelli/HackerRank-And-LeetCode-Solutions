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
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        
        head.next = n1;
        
        n1.next=n2;
        
        n2.next=n3;
        
        n3.next=n4;
        
        /*System.out.println("The linked list: ");
        
        printLinkedList(head);
        
        System.out.println("reversed through an iterative method is: ");
        
        printLinkedList(reverseListIterative(head));*/
        
        System.out.println("The linked list: ");
        
        printLinkedList(head);
        
        System.out.println("reversed through a recursive method is: ");
        
        printLinkedList(reverseListRecursive(head));
        
    }
    
    
     public static ListNode reverseListIterative(ListNode head) {
        
        ListNode current = head;
        
        ListNode prev = null;
        
        while(current!=null)
        {
            ListNode next = current.next;
            
            current.next=prev;
            
            prev=current;
            
            current=next;
        }
        
        return prev;
        
    }
     
     public static ListNode reverseListRecursive(ListNode head) {
        if(head!=null)
            return reverseListAux(head,null);
        else
            return null;
    }
    
    public static ListNode reverseListAux(ListNode current, ListNode newNext)
    {
        ListNode next = current.next;
        
        current.next=newNext;
     
        
        if(next!=null)
            return reverseListAux(next,current);
        else
            return current;
        
    }
    
    
    public static void printLinkedList(ListNode current)
    {
        
        while(current!=null)
        {
            System.out.print(current.val+" --> ");
            
            current = current.next;
            
        }
        
        System.out.println("NULL");
    }
    
}
