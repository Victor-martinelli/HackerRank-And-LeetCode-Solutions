package com.vicotr;

public class Main {

    public static void main(String[] args) {

    }




    public static int removeDuplicates(int[] nums) {

        //Initial pointer of the array;
        int i = 0;

        //Other pointer of the array;
        int j = i+1;


        //Loop over the array in order remove the duplicates
        while(j<nums.length){

            //If the current number is smaller than the candidate
            if(nums[i]<nums[j]){
                //Go to the next position
                i++;
                //Switch the number's positions
                nums[i] = nums[j];
                //Replace the old target with 0
                //nums[j] = 0;
            }
            //Increase the target count
            j++;
        }

        return i+1;
    }
}
