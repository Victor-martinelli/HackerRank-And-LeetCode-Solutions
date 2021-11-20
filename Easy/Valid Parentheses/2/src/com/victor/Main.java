package com.victor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isValid(String s) {

        String insertString = "([{";

        //Stack that will hold the sequence of parenthenses
        Stack<String> stack = new Stack();

        //Prepare a HashMap so that we can quickly find out if it's ok to pop

        HashMap<String,String> quickLookup = new HashMap();

        quickLookup.put("]","[");
        quickLookup.put("}","{");
        quickLookup.put(")","(");

        int i = 0;

        //Go through the entire string until we process them all or we are finished
        while(i<s.length()){

            //Get the current String
            String candidate = s.substring(i,i+1);

            //If it's an insert
            if(insertString.contains(candidate)){
                //Insert it into the stack
                stack.push(candidate);
            }else if(!stack.empty()){

                //Check if it can be correctly popped

                if(quickLookup.get(candidate).equals(stack.peek())){
                    //Pop the element
                    stack.pop();
                } else {
                    //Not ok to pop
                    i=s.length();
                }
            } else{
                //Trying to pop an empty stack is not permitted
                i=s.length();
            }
            //Increment
            i++;

        }

        //Everything has been permitted and the stack is empty
        return i<=s.length() && stack.isEmpty();
    }

    public boolean isValidAnother(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(char c : s.toCharArray()){
            if( c == '(' || c == '{' || c == '[')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                switch(c){
                    case ')':
                        if (stack.pop() != '(')
                            return false;
                        break;
                    case '}':
                        if (stack.pop() != '{')
                            return false;
                        break;
                    case ']':
                        if (stack.pop() != '[')
                            return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

}
