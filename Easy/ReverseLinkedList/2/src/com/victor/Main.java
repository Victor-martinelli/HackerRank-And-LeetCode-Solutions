package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode reverseList(ListNode head) {

        ListNode current = null;

        //If the ListNode is empty

        if(head!=null){
            //New node that will be tail of the linked list
            current = new ListNode(head.val);

            //Prepare for the next ListNode
            head = head.next;

            //While we haven't reached the end of the linked list
            while(head!=null){

                //Get the current value
                ListNode temp = new ListNode(head.val);

                //Set the next to the current one to build the Linked List in reverse
                temp.next = current;

                //Update the reference
                current = temp;

                //Go to the next value in the original LinkedList

                head = head.next;
            }
        }
        return current;
    }

    public ListNode reverseList2(ListNode head) {

        ListNode current = null;

        //If the ListNode is empty

        if(head!=null){

            //New node that will be tail of the linked list
            current = new ListNode(head.val);

            //Prepare for the next ListNode
            head = head.next;

            //While we haven't reached the end of the linked list
            current = setNewHead(head,current);
        }
        return current;
    }

    public ListNode setNewHead(ListNode head,ListNode current){

        if(head!=null){

            //Get the current value
            ListNode temp = new ListNode(head.val);

            //Set the next to the current one to build the Linked List in reverse
            temp.next = current;

            //Update the reference
            current = temp;

            //Go to the next value in the original LinkedList

            current = setNewHead(head.next,current);

        }
        return current;
    }

}
