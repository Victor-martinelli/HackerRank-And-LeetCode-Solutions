package com.victor;

import java.util.Random;

public class Solution2 {


    private int[] nums;

    private Random rd;

    //private int[] original;

    public Solution2(int[] nums) {
        this.nums = nums;

        rd = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {

        //Copy to a new array
        int[] result = nums.clone();

        //Go through the entire array and swap the elements
        for(int i=0;i<nums.length;i++){

            //get the index of the next element to swap
            int secondIndex = rd.nextInt(nums.length);

            //Swap the element
            int firstElement = result[i];

            result[i] = result[secondIndex];

            result[secondIndex] = firstElement;

        }

        return result;
    }

}
