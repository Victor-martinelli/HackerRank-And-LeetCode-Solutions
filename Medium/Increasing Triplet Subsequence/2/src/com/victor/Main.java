package com.victor;

/**
 * Time Complexity 0(n)
 * Space Complexity 1
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean increasingTriplet(int[] nums) {
        //If the array has no elements or they are less than 3, then there's no solution
        if(nums.length < 3) return false;

        //Define the two elements that will hold the two smallest numbers until we find
        //The largest one

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        //Go throguh the array

        for (int num : nums) {

            //If we have found a first smallest element
            if (num < minOne) minOne = num;
            //If we may have found the second smallest element
            if (num > minOne) {
                //Try to find which one is the smallest
                minTwo = Math.min(minTwo, num);
            }
            //If it's larger than our minTwo, then we have a solution
            if (num > minTwo) return true;

        }
        return false;

    }

}
