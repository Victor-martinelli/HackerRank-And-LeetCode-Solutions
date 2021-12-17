package com.victor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * Time Complexity: O(Max(m,n))
     * Space Complexity O(Max(m,n))
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //HashMap that will store all the times that a value has been seen
        HashMap<Integer, ArrayList<ListNode>> seenNodes = new HashMap();

        //Pointer to the start of the lists

        ListNode headAPointer = new ListNode(0);

        ListNode headBPointer = new ListNode(0);


        headAPointer.next = headA;

        headBPointer.next = headB;

        //Add all the elements in headA and then look for them in headB

        while(headA!=null){
            if(seenNodes.containsKey(headA.val)){
                //Add it to the list and continue

                List<ListNode> aux = seenNodes.get(headA.val);

                aux.add(headA);

            } else {
                //Add the solution
                seenNodes.put(headA.val,new ArrayList(Arrays.asList(headA)));
            }
            headA = headA.next;
        }


        //Go through the second Linked List in order to find the match

        while(headB!=null){

            //If we have seen the current value in the seenNodes

            if(headB!=null && seenNodes.containsKey(headB.val)){

                //Get the list of Nodes and check

                List<ListNode> detailedSeenNodes = seenNodes.get(headB.val);

                int i = 0;

                while(i<detailedSeenNodes.size()){

                    //If it's the same object
                    if(headB.equals(detailedSeenNodes.get(i))){

                        headA = headAPointer.next;
                        headB = headBPointer.next;

                        return detailedSeenNodes.get(i);
                    } else{
                        //Go to the next one
                        i++;
                    }

                }

            }
            //Keep going
            headB = headB.next;

        }

        return null;
    }

    /**
     * Time Complexity: O(m+n)
     * Space Complexity O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeAnother(ListNode headA, ListNode headB) {

        //Setup a pointer for both heads
        ListNode headAPointer = headA;
        ListNode headBPointer = headB;

        //While we haven't found the intersection
        //We will basically be traversing both lists until they meet
        while(headAPointer != headBPointer){

            //If we have reached the end of one of the list
            if(headAPointer==null){
                //Set it to the other list so that it also traverses it
                headAPointer = headB;
            } else {
                //Keep going
                headAPointer = headAPointer.next;
            }

            //If we have reached the end of one of the list
            if(headBPointer==null){
                //Set it to the other list so that it also traverses it
                headBPointer = headA;
            } else {
                //Keep going
                headBPointer = headBPointer.next;
            }

        }

        //Return the possible intersection or null
        return headAPointer;

    }

}
