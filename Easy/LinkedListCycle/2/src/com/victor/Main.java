package com.victor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean hasCycle(ListNode head) {

        boolean result = false;

        //List that will hold all the nodes that we have found so far
        List<ListNode> foundNodes = new ArrayList();

        //Go through the entire LinkedList
        while(head!=null && !result){

            int i = 0;

            //If we have seen the value
            while(i<foundNodes.size() && !result){
                //If same value and same next
                if(head.val==foundNodes.get(i).val && head.next==foundNodes.get(i).next){
                    //Has a cycle
                    result = true;
                }
                //Keep looking
                i++;
            }

            //Add to the list and keep looking
            foundNodes.add(head);

            //Go to the next Node
            head = head.next;

        }

        return result;
    }

    public boolean hasCycle2(ListNode head) {

        boolean result = false;

        //If the list is not empty
        if(head!=null)
        {

            //Two pointers.
            //Slow one will move one at a time
            //Fast will move twice at a time
            ListNode slow = head;
            ListNode fast = head.next;

            //While we haven't reached the end of the list and we haven't found a cycle
            while(fast!=null && fast.next!=null && !result){

                //If the value is the same (we found a cycle)

                if(slow == fast){
                    result = true;
                }

                //Move the pointers
                slow = slow.next;
                fast = fast.next.next;

            }
        }

        return result;
    }

}
