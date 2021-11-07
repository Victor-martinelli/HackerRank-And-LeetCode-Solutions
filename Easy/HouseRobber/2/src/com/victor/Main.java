package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int rob(int[] nums) {

        int[] result = new int[nums.length];

        //Solve the first two cases, which is to rob one house or to rob two
        result[0] = nums[0];

        //In case there aren't any other number
        if(nums.length>1){

            result[1] = Math.max(nums[0],nums[1]);


            //Go through the entire array to build the solution

            for(int i = 2; i<nums.length;i++){
                //The solution in this position is the max of either the current one +
                //two behind us (since we cannot rob two houses that are close to each other)
                //Or simply rob the house before us

                result[i] = Math.max(nums[i] + result[i-2],result[i-1]);
            }

        }

        return result[nums.length-1];
    }
}
