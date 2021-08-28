package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public int reverse(int x) {

        //Turn it to String
        String aux = String.valueOf(x);

        long auxResult = 0;

        int sign = 1;

        //Check if it's a negative number
        if(aux.contains("-")){
            sign=-1;
            //Trim the string
            aux = aux.substring(1,aux.length());
        }

        //Iterate through it in order to create the Integer
        //Will store it in a long in case it goes above the int

        for(int i=0;i<aux.length();i++){
            auxResult+=Long.parseLong(Character.toString(aux.charAt(i))) * Math.pow(10,i);
        }

        //Apply sign
        auxResult*=sign;

        //If we went above the limitation of integer
        if(auxResult<Integer.MIN_VALUE || auxResult>Integer.MAX_VALUE){
            auxResult = 0;
        }

        return (int)auxResult;
    }

    public int reverseAnother(int x) {

        //Used in order to know if the number is negative
        long sign = 1;

        //Check if it's negative and save the value
        if(x < 0){
            //Remove the negative sign and save it to another value for later
            //multiplication
            sign = -1;
            x*=-1;
        }

        //Save result to a long in case we go above an int limit
        long result = 0;

        //Do the actual reversing
        while(x>0){

            //Construct the result by multiplying what we have by 10 and taking a 'piece'
            //From the current number
            result = (result * 10) + (x % 10);
            //Cut down the number
            x/=10;
        }

        //Now check if we have gone above the limit

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            result = 0;
        }

        //Apply the sign value
        result*=sign;

        return (int) result;
    }

}
