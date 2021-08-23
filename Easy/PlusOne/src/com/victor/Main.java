package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int[] plusOne(int[] digits) {

        //Go through the array backwards


        for(int i = digits.length-1;i>=0;i--){

            //If the current number is not a 9
            //We simply increment
            if(digits[i]<9){
                digits[i]++;
                return digits;
            } else {

                //We will simply set to 0 and go to the next number since it might all the 9
                digits[i]=0;

            }

        }


        //If we are here, it means that we need to increase the size of the array

        int[] result = new int[digits.length+1];

        //Simply set index 0 to 1 to symbolize that we have incremented the original number
        result[0]=1;

        return result;

    }

}
