package com.victor;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            //Let's first count the size
            ListNode current = head;

            int size = 0;
            while (current != null) {
                current = current.next;
                size++;
            }

            System.out.println("Size: " + size);

            //If the size is 1, simply set head to null
            if (size == 1) {
                head = null;
            } else if (size == n) {
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

                while (!found) {

                    int temp = size - i - 1;

                    //System.out.println("Current i "+i+" - Current value of size-i-1 is "+temp);
                    //If the current node is the one before the one we want to delete
                    if (size - n == i) {
                        //System.out.println("Found the value, replacing");
                        //Skip the next one and go to next next
                        current.next = current.next.next;
                        found = true;
                    } else {
                        //System.out.println("Continue looking");
                        //Keep looking
                        current = current.next;
                        i++;
                    }
                }
            }

            return head;
        }

        public ListNode removeNthFromEndANother(ListNode head, int n) {

            int i = 0;

            ListNode counter = head;

            //Set the second pointer, which will be n+1 away from the start
            while(i!=n && counter!=null){
                //System.out.println("Current counter "+counter.val+" next counter "+counter.next);

                counter = counter.next;
                i++;
            }

            //System.out.println("Number in counter "+counter.val);

            //Check if it's an edge case (we already reached the end, which means we want to delete the first node)
            if(counter==null){
                //Another edge case where n is 1, which is a linked list of one element
                if(n==1){
                    head = null;
                } else{
                    //Delete the head and set the new head
                    head.val = head.next.val;
                    head.next = head.next.next;
                }
            } else {
                //Traverse the LinkedList until the counter is null, which means current is at the desired position
                ListNode current = head;

                //System.out.println("Number in current "+current.val);


                while(counter.next!=null){
                    current = current.next;
                    counter = counter.next;
                }

                //System.out.println("Number in current "+current.val);

                //Finally set the new location
                current.next = current.next.next;

            }

            return head;
        }

        public ListNode removeNthFromEndAnother(ListNode head, int n) {
            ListNode temp = new ListNode(0);
            temp.next = head;

            ListNode slow = temp;
            ListNode fast = temp;

            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next == null ? null : slow.next.next;

            return temp.next;
        }

    }


}
