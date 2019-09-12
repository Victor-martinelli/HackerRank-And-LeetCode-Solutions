/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        
        System.out.print("List: ");
        
        printLinkedList(n1);
        
        System.out.println("Result List: ");
        
        printLinkedList(oddEvenList(n1));
    }
    
    public static ListNode oddEvenList(ListNode head) {
        
        if(head!=null)
        {
            
            //We set two pointers that will iterate through the linked list through the even and odd positions
            ListNode odd = head;
            
            ListNode even = head.next;
            
            ListNode evenHead = even;
            
            while(even!=null && even.next!=null)
            {

                odd.next=even.next;
                
                odd=odd.next;
                
                even.next=odd.next;
                
                even=even.next;
                
            }
            
            odd.next=evenHead;
            
            return head;
            
        }
        else
            return head;
        
    }
    
    public static void printLinkedList(ListNode n)
    {
        while(n!=null)
        {
            System.out.print(n.val+" ");
            n=n.next;
        }
        System.out.println("");
        
    }
    
}
