/*
 * Let's start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

1 -> 1 -> 2 -> 1 -> null 
sf

(1) Move: fast pointer goes to the end, and slow goes to the middle.

1 -> 1 -> 2 -> 1 -> null 
          s          f

(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

1 -> 1    null <- 2 <- 1           
h                      s

(3) Compare: run the two pointers head and slow together and compare.

1 -> 1    null <- 2 <- 1             
     h            s

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
       ListNode n1 = new ListNode(1);
       ListNode n2 = new ListNode(2);
       ListNode n3 = new ListNode(1);
       
       head.next=n1;
       n1.next=n2;
       n2.next=n3;
       
      System.out.println("Is the following linked list a palindrome?");
      
      printLinkedList(head);
       
      
      System.out.println(isPalindrome(head));
    }
    
      public boolean isPalindromeOriginal(ListNode head) {
        
        int i=0;
        
        boolean isPalindrome=true;
        
        ListNode current = head;
        
        int listSize = linkedListSize(head);
        
        while(i<listSize/2 && isPalindrome)
        {
            ListNode candidate = getNodeInPosition(current,i,listSize-i-1);
            
            if(candidate.val!=current.val)
            {
                isPalindrome=false;
            }
            else
            {
              current=current.next;
              i++;
            }
            
        }
        
        return isPalindrome;
    }
      
      public static boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
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

public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
    
    public ListNode getNodeInPosition(ListNode current,int currentPosition,int desiredPosition)
    {
        
        ListNode target=null;
        
        int i =currentPosition;
        
        while(i!=desiredPosition)
        {
            current = current.next;
            i++;
        }
        
        target=current;
        
        return target;
    }
    
    
    public int linkedListSize(ListNode head)
    {
        int i =1;
        
        ListNode current = head;
        
        while(current!=null && current.next!=null)
        {
            current = current.next;
            i++;
        }
        return i;
    }
    
}
