package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //We will just do a next in order to return the result

        ListNode result = new ListNode(0);

        ListNode aux = result;

        //Will give us the remainder of the current sum
        int remainder = 0;

        int currentSum = 0;

        //While we have elements to go through
        while(l1!=null || l2!=null){

            int firstNumber = 0;

            int secondNumber = 0;

            //If we have a number to add
            if(l1!=null){
                firstNumber = l1.val;
                //Go to the next one
                l1 = l1.next;
            }

            //Get the second Number
            if(l2!=null){
                secondNumber = l2.val;
                //Go to the next one
                l2 = l2.next;
            }

            //Add them and then the remainder
            currentSum = firstNumber + secondNumber + remainder;

            //Check if we have gone beyond 10, if so then remove a 10 for the next one
            if(currentSum>=10){
                remainder = 1;
                currentSum-=10;
            } else{
                remainder = 0;
            }

            //System.out.println(currentSum);

            //Add it to the solution
            aux.next = new ListNode(currentSum);
            aux = aux.next;

        }

        //If we have some remainder left
        if(remainder!=0){
            aux.next = aux.next = new ListNode(remainder);
        }

        return result.next;
    }

}
