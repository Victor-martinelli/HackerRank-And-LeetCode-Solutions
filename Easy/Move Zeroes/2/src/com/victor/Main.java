package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public void moveZeroes(int[] nums) {

        //Create a result array
        int[] result = new int[nums.length];

        //Index for the result
        int j=0;

        //Go through the initial array

        for(int i=0;i<nums.length;i++){
            //If number is not 0, the we put it in the solution

            if(nums[i]!=0){
                result[j]=nums[i];
                j++;
            }

        }

        //Copy to result

        for(int i=0;i<nums.length;i++){
            nums[i]=result[i];
        }

    }


    public void moveZeroesAnotherSolution(int[] nums) {
        //We will move all of the non zero elements to the start of the array

        int j=0;

        for(int i=0;i<nums.length;i++){

            //If the number is not a 0
            if(nums[i]!=0){
                //Move it to where the last non zero element was found
                nums[j++]=nums[i];
            }

        }

        //After this, all the non-zero elements have been moved to the start of the array
        //And the only thing remaining is to fill up the other spaces with 0s

        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }

    }

}
