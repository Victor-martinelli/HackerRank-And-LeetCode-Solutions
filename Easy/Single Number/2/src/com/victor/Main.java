package com.victor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int singleNumber(int[] nums) {

        //Sort Array
        Arrays.sort(nums);

        int result = Integer.MIN_VALUE;

        int i = 0;

        //While we haven't found a number

        while(i<nums.length && result==Integer.MIN_VALUE) {

            //If we have a next number
            if(i+1<nums.length-1){
                //If it's the same as the current one
                if(nums[i]==nums[i+1]){
                    //Go two numbers ahead and keep comparing
                    i+=2;
                } else {
                    //We found our number
                    result=nums[i];
                }
            } else {
                //No next number, this is the unique one
                result=nums[i];
            }

        }

        return result;
    }


    public int singleNumberBit(int[] nums) {

        int result = 0;

        //We'll compare the numbers on a bit level If they are the same, it will return 0. Otherwise the way that bit
        // manipulation works is the following a⊕b⊕a=(a⊕a)⊕b=0⊕b=ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
        for(int i=0;i<nums.length;i++){

            result ^= nums[i];
        }
        return result;
    }

}
