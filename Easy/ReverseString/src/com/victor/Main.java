package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public void reverseString(char[] s) {

        //Start of the array
        int i = 0;

        //End of the array
        int j = s.length-1;

        //While we haven't crossed paths
        while(i<j){

            //Swap them and continue
            char aux = s[i];

            s[i] = s[j];

            s[j] = aux;

            i++;
            j--;
        }

    }
}
