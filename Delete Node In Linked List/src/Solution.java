/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:


Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 

Note:

The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    
    static ListNode head = new ListNode(4);
    
    public static void main(String[] args) {
       
       ListNode n1 = new ListNode(5); 
       ListNode n2 = new ListNode(1); 
       ListNode n3 = new ListNode(9); 
       
       head.next=n1;
       n1.next=n2;
       n2.next=n3;
       
       System.out.println("Linked List before deleting node: ");
       printLinkedList(head);
       
       System.out.println("Linked List after deleting node "+n2.val+" : ");
       
       deleteNode(n2);
       
       printLinkedList(head);
    }
    
    public static void deleteNode(ListNode node) {
        
        if(node != null && node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }
    
     public static void deleteNodeOriginal(ListNode node) {
        
        while(node!=null && node.next!=null)
        {
            //System.out.println("Before: "+node.val);
            node.val=node.next.val;
            
            if(node.next!=null && node.next.next==null)
            {
                node.next=null;
            }
            
            node=node.next;

        }
        
        node=null;
        
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
