package com.victor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: 0(n^2) since we have to go through the entire array for each of the numbers
 */


public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //Sort the array
        Arrays.sort(nums);

        //Target number that we are trying to reach
        int target = 0;

        List<List<Integer>> result = new ArrayList();

        //Go through the array and find out the other two numbers that we need
        //-2 because the last two numbers don't have a pair when we reach them
        for(int i=0;i<nums.length-2;i++){
            //If this is a number worth exploring, meaning that the index is 0 or if we
            //are above 0, that we haven't found a duplicate
            if(i==0 || (i > 0 && nums[i]!=nums[i-1])){

                //Look at the numbers from a high and low range
                int low = i+1;
                int high = nums.length-1;

                //This will be the complement of selecting the first number for our solution,
                //So we now know what we will need to find
                int complement = target-nums[i];
                while(low < high){
                    //Check if we have found a possible solution
                    if(nums[low] + nums[high]==complement){
                        //Found a solution, add it and make sure that we don't add the same solution again
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));

                        //Keep skipping till we have found a duplicate
                        while(low < high && nums[low]==nums[low+1])low++;
                        while(low < high && nums[high]==nums[high-1])high--;

                        //Have it ready for the next run since we are technically still at a duplicate
                        low++;
                        high--;

                    } else if(nums[low] + nums[high] > complement){
                        //Need to decrement the high
                        high--;
                    } else{
                        //Candidate is lower than the complement, need to increment
                        low++;
                    }
                }

            }
        }


        return result;
    }

}
