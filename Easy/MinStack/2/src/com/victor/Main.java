package com.victor;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class Main {

    public class Node {

        //Next node in the LinkedList
        private Node next;

        //Value that we are currently holding
        private int value;

        //Minimum value that we have found up to this point
        private int min;

        public Node(int value){
            this.value = value;
            this.next = null;
            this.min = value;
        }

        public void setMin(int min){
            this.min = min;
        }

        public int getMin(){return min;}

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){return next;}

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){return value;}
    }

    //This will be the latest inserted node that will also hold
    //The minimun value seen so far
    private Node head;

    public void push(int val) {

        //If this is the start of the Stack
        if(head==null){
            head = new Node(val);
        }else {

            //Prepare the new head
            Node newHead = new Node(val);

            //See which is the new minimun
            newHead.setMin(Math.min(val,head.getMin()));

            //Set the current head as the next

            newHead.setNext(head);

            //Set the new head
            head = newHead;

        }

    }

    public void pop() {
        //Simply go to the next element
        head = head.getNext();
    }

    public int top() {
        return head.getValue();
    }

    public int getMin() {
        return head.getMin();
    }

    public static void main(String[] args) {
	// write your code here
    }
}
