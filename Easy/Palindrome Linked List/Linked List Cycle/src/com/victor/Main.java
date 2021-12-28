package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * Time Complexity O(n)
     * Space Complexity 0(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        boolean result = false;

        //Check if we even have to search
        if(head!=null && head.next!=null){
            //We will have two pointers, a slow (one at a time) and a fast one (two at a time).
            //If there's a cycle, they will eventually meet
            ListNode slow = head;
            ListNode fast = head.next;

            //While there's still nodes to search
            while(slow!=null && fast!=null && fast.next!=null && !result){
                //If they are the same, we found the cycle
                if(slow==fast){
                    result = true;
                } else {
                    slow = slow.next;
                    fast = fast.next.next;
                }
            }

        }

        return result;

    }

}
