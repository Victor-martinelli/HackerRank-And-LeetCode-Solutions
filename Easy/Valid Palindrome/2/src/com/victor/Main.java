package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isPalindrome(String s) {

        //Convert to lowercase
        String sLower = s.toLowerCase();

        //Go through the entire string with two indices to see if it's a palindrome
        int i = 0;
        int j = sLower.length()-1;

        boolean result = true;

        while(i<j && result){

            //If it's an alphanumeric character
            char iChar = sLower.charAt(i);

            char jChar = sLower.charAt(j);

            if(isAlphanumeric(iChar)){

                //Check if the other is alphanumeric
                if(isAlphanumeric(jChar)){

                    //System.out.println("i char "+iChar+" - j char "+jChar);

                    //Check if they are the same
                    if(iChar==jChar){
                        //Continue search
                        i++;
                        j--;
                    } else{
                        //Not palindrome
                        result = false;
                    }

                } else {
                    //System.out.println("j char "+jChar+" is not a alphanumeric character");
                    //next character
                    j--;
                }

            } else {
                //System.out.println("i char "+iChar+" is not a alphanumeric character");
                //next character
                i++;
            }
        }

        return result;
    }

    public boolean isAlphanumeric(char candidate){
        //Check if it's an alphanumeric character

        boolean result = false;

        if( (candidate-'a'<='z'-'a' && candidate-'a'>=0) || (candidate-'0'<='9'-'0' && candidate-'0'>=0) ) {
            result = true;
        }

        return result;
    }

    public boolean isPalindromeANother(String s) {
        if(s.isEmpty()) {
            return true;
        }

        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if(!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }

                head++;

                tail--;
            }
        }
        return true;
    }
}
