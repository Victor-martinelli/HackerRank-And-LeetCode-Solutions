package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int maxSubArray(int[] nums) {

        //Final result
        int result = nums[0];

        //Candidate result were we will be storing the current contiguous sum
        int candidate = result;

        //Go through the entire array trying to find the longest contiguous sum

        for(int i = 1; i<nums.length; i++){

            //If we are currently at a negative result, we don't even consider it
            //as a solution and just set it to the current number that we are in
            if(candidate<0){
                candidate = nums[i];
            } else {
                //Add the current number to the candidate
                candidate+=nums[i];
            }

            //See which is the largest
            result = Math.max(result,candidate);

        }

        return result;
    }
}
