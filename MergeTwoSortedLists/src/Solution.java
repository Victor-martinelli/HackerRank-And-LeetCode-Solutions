/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
        ListNode n6 = new ListNode(6);
        
        n1.next=n2;
        
        n2.next=n3;
        
        n4.next=n5;
        n5.next=n6;
        
        mergeTwoLists(n1,n4);
        
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        
        ListNode current = head;
        
        while(l1!=null && l2!=null)
        {
            
            if(l1.val<l2.val)
            {
                current.next=l1;
                
                l1=l1.next;
                
            }
            else
            {
                current.next=l2;
                
                l2=l2.next;
            }
            
            current = current.next;
            
        }
        
        if(l1!=null)
        {
            current.next=l1;
        }
        else
        {
            current.next = l2;
        }
        
        
        return head.next;
    }
    
    public static ListNode mergeTwoListsOriginal(ListNode l1, ListNode l2) {
        
        ListNode head = null;
        
        if(l1.val<l2.val)
        {
            head = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            
            l2=l2.next;
        }
        
        ListNode current = head.next;
        
        while(l1!=null && l2!=null)
        {

            if(l1.val<l2.val)
            {
                current = new ListNode(l1.val);
                
                l1=l1.next;
            }
            else if(l2.val<=l1.val)
            {
                current = new ListNode(l2.val);
                
                l2=l2.next;
            }
            
            //System.out.println(current.val);
            
            current = current.next;
            
        }
        
        
        ListNode target=null;
        
        if(l1==null)
        {
            target=l2;
        }
        else
        {
            target=l1;
        }
        
        while(target!=null)
        {
            current = new ListNode(target.val);
                
            //System.out.println(current.val);
            
            target=target.next;
            
            current = current.next;
        }
        
        
        
        return head;
    }
    
    
}
