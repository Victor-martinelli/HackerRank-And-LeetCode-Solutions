package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isPalindromeTooSlow(ListNode head) {

        boolean result = true;

        //If we even have to search
        if(head!=null){
            //First figure out the size

            int size = 0;
            ListNode current = head;
            while(current!=null){
                size++;
                current = current.next;
            }

            //Now, go up until half of the LinkedList and see if they are the same
            int i = 0;

            while(result && i<size/2){
                //Get the two nodes
                ListNode one = getNode(head,i);
                ListNode two = getNode(head,size-i-1);

                //Check if they are the same
                if(one.val!=two.val){result = false;}
                //Keep going
                i++;
            }

        } else {
            result = false;
        }

        return result;

    }

    public ListNode getNode(ListNode head,int pos){
        ListNode result = head;

        int i = 0;
        while(i!=pos){
            i++;
            result = result.next;
        }

        return result;
    }

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        boolean result = true;

        //If we even have to search
        if(head!=null){
            //First figure out the size

            int size = 0;
            ListNode current = head;
            while(current!=null){
                size++;
                current = current.next;
            }

            //Get the middle of the list

            ListNode reversedListStart = head;
            int i = 0;
            while(i<size/2){
                reversedListStart = reversedListStart.next;
                i++;
            }

            //Now reverse the second half of the Linked LinkedList in order to compare

            ListNode reversedList = reverseList(reversedListStart);

            i = 0;

            current = head;

            //Check if they are the same as the first half of the list
            while(i<size/2 && result){
                if(reversedList.val!=current.val){
                    result = false;
                }
                //Keep going
                i++;
                reversedList = reversedList.next;
                current = current.next;
            }

        } else {
            result = false;
        }

        return result;

    }

    public ListNode reverseList(ListNode head){
        ListNode current = head;
        //This is to represent the end of the list
        ListNode prev = null;

        while(current!=null){

            //Get the next current for the next round
            ListNode nextTemp = current.next;
            //Set the current next according to the prev
            current.next = prev;
            //Set the previous to the current and current to the nextTemp
            prev = current;

            current = nextTemp;
        }

        return prev;
    }

}
