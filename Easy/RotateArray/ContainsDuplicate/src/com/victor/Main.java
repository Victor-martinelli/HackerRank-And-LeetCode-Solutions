package com.victor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public boolean containsDuplicate(int[] nums) {

        //Let's first sort the array

        Arrays.sort(nums);

        boolean result = false;

        //Go through the array and see if the next number is the same as the current one
        int i=0;

        while(!result && i<nums.length){

            //If the next number is not outside the array
            if(i+1<nums.length){

                //Check if the next number is the same as the current one
                if(nums[i]==nums[i+1]){
                    result=true;
                }

            }
            //Go to the next number
            i++;
        }

        return result;
    }
}
