package com.victor;

/*
Time Complexity: O(logb(n)). The number of divisions is given by that logarithm. in our case b would be 3

Space Complexity: O(1)
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isPowerOfThree(int n) {

        boolean finished = false;

        boolean result = true;

        int power = 3;

        //Loop until we are finished
        while(!finished){

            //If the current number is greater or equal to our power
            if(n>=power){

                //Check to see if it can be a power
                if(n%power==0){
                    //Divide and take the result for the next iteration
                    n = n/power;
                } else {
                    //For sure not a power
                    finished = true;
                    result = false;
                }

            } else {
                //We are finished processing and are ready to see a result
                finished = true;
            }

        }

        //Will only be true if the mod is 0 and if the leftover is 1
        return result && n == 1;

    }

    public boolean isPowerOfThreeAnother(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
