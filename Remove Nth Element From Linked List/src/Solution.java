/*
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
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
        
        int n=2;
        
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        
        System.out.println("The linked list before deleting the "+n+"th node from the end of the list: ");
        
        printLinkedList(n1);
        
        n1 = removeNthFromEnd(n1,n);
        
        System.out.println("The linked list after deleting the "+n+"th node from the end of the list: ");
        
        printLinkedList(n1);
        
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
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
    
    
    public static ListNode removeNthFromEndOriginal(ListNode head, int n) {
       
        head = reverseLinkedList(head);
        
        int count=1;
        
        boolean finished=false;
        
        ListNode current = head;
        
        if(count==n)
        {
            head=head.next;
        }
        else
        {
            while(!finished)
            {

                if(count+1==n)
                {

                    current.next=current.next.next;

                    finished=true;

                }
                else
                {
                  current=current.next;
                  count++;
                }

            }
        }
        
            
        return reverseLinkedList(head);
    }
    
    
    public static ListNode reverseLinkedList(ListNode head)
    {
        
        ListNode current = head;
        
        ListNode prev = null;
        
        while(current!=null)
        {
            
           ListNode next = current.next; 
           
            current.next = prev;
            
            prev = current;
            
            current = next;
        }
        
        head = prev;
        
        return head;
    }
    
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow=head;
        
        ListNode fast=head;
        
        while(n>0 && fast!=null)
        {
            fast=fast.next;
            n--;
        }
        
        //System.out.println(fast.val);
        
        if(fast==null)
        {
            slow=slow.next;
            head=slow;
        }
        else
        {
            
            while(fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next;
            }

            slow.next=slow.next.next;
        }
            
        return head;
    }
    */
    
    
}
