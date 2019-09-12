/*
 * You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        
        n1.next=n2;
        n2.next=n3;
        
        n4.next=n5;
        n5.next=n6;
        
        System.out.print("List 1: ");
        printLinkedList(n1);
        System.out.print("List 2: ");
        printLinkedList(n4);
        
        System.out.print("Result of sum: ");
        printLinkedList(addTwoNumbers(n1,n4));
        
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);

        ListNode current = result;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int val1 = 0;
            int val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + carry;

            carry = sum / 10; //This is because the sum is digit by digit

            current.next = new ListNode(sum % 10);//This is because the sum is digit by digit and we already removed the farthest left

            current = current.next;

        }

        //If there is a carry remaining
        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
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
