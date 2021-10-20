package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            //Let's first count the size
            ListNode current = head;

            int size = 0;
            while(current!=null){
                current = current.next;
                size++;
            }

            System.out.println("Size: "+size);

            //If the size is 1, simply set head to null
            if(size==1){
                head = null;
            } else if(size==n){
                //We want to replace the head
                //Simply take the value of the next and point to next next

                head.val = head.next.val;
                head.next = head.next.next;

            } else {
                //Go through the list again find the node right before the one we want to delete
                boolean found = false;

                //Index of where we currently are
                int i = 1;

                current = head;

                while(!found){

                    int temp = size-i-1;

                    //System.out.println("Current i "+i+" - Current value of size-i-1 is "+temp);
                    //If the current node is the one before the one we want to delete
                    if(size-n==i){
                        //System.out.println("Found the value, replacing");
                        //Skip the next one and go to next next
                        current.next = current.next.next;
                        found = true;
                    } else{
                        //System.out.println("Continue looking");
                        //Keep looking
                        current = current.next;
                        i++;
                    }
                }
            }

            return head;
        }
}
