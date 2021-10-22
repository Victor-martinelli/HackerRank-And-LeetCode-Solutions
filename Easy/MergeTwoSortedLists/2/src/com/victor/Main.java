package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //Result

        ListNode result = new ListNode(0);

        ListNode current = result;

        //Go through both lists until we reach the end of one of them
        while(l1!=null && l2!=null){

            //Check their value
            if(l1.val==l2.val){
                //Add them both and increment both counters
                current.next = new ListNode(l1.val);

                current = current.next;

                current.next = new ListNode(l2.val);;

                l1 = l1.next;

                l2 = l2.next;

                current = current.next;

            } else if(l1.val>l2.val){
                //Add l2
                current.next = new ListNode(l2.val);

                current = current.next;

                l2 = l2.next;
            } else {
                //Add l1

                current.next = new ListNode(l1.val);

                current = current.next;

                l1 = l1.next;
            }

        }

        //If one of the list is still not empty
        while(l1!=null){
            current.next = new ListNode(l1.val);;

            current = current.next;

            l1 = l1.next;
        }

        while(l2!=null){
            current.next = new ListNode(l2.val);

            current = current.next;

            l2 = l2.next;
        }

        return result.next;
    }

    public ListNode mergeTwoListsAnother(ListNode l1, ListNode l2) {

        //Result

        ListNode result = new ListNode(0);

        ListNode current = result;

        //Go through both lists until we reach the end of one of them
        while(l1!=null && l2!=null){

            //Check their value
            if(l1.val>l2.val){
                //Add l2
                current.next = new ListNode(l2.val);

                current = current.next;

                l2 = l2.next;
            } else {
                //Add l1

                current.next = new ListNode(l1.val);

                current = current.next;

                l1 = l1.next;
            }

        }

        //If one of the list is still not empty

        if(l1!=null){
            //Set it to the rest of the list
            current.next = l1;
        } else {
            current.next = l2;
        }

        return result.next;
    }

}
