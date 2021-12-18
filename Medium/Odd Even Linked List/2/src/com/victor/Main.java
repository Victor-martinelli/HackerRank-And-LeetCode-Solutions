package com.victor;

/**
 * Time Complexity O(n)
 * Space Compexity O(1)
 */
public class Main {

    public ListNode oddEvenList(ListNode head) {

        if(head!=null){
            //This is where the odd list will be at
            ListNode odd = head;

            ListNode even = head.next;

            //This will be the even list
            ListNode evenHead = even;

            //Go through with the even since it will see further ahead than the odd
            while(even!=null && even.next!=null){
                //Set the next for the odd one the next of the even
                odd.next = even.next;
                odd = odd.next;

                //Set the next of the even one the next of the odd one
                even.next = odd.next;
                even = even.next;
            }

            //Set the next in the list as the even List
            odd.next = evenHead;
        }

        return head;
    }
}
