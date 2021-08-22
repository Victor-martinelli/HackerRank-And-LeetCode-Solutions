package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public void rotate(int[] nums, int k) {

        //Create arrat of the same size

        int result[] = new int[nums.length];

        int target;

        //Go through the entire array

        for(int i=0;i<nums.length;i++){

            //New candidate
            target= i+k;

            //System.out.println(Arrays.toString(result));

            //While we are over the limit
            while(target>=nums.length){
                target-=nums.length;
            }

            //Put the number in the new array
            result[target] = nums[i];

            //System.out.println(Arrays.toString(result));

        }

        //Set the values

        for(int i=0;i<nums.length;i++){
            nums[i] = result[i];
        }

    }

    public void anotherSolution(int[] nums,int k){

        //Since the solution simply has the last k elements on the front reversed and
        //The rest of the numbers reversed. We will first reverse the entire thing
        //And then reverse the first k elements and then the rest

        //In case k goes over the size of the array
        k = k % nums.length;

        System.out.println(k);

        nums = reverse(nums,0,nums.length-1);
        nums = reverse(nums,0,k-1);
        nums = reverse(nums,k,nums.length-1);
    }

    public int[] reverse(int [] nums,int start,int end){


        while(start<end){

            //Make the switch
            int aux = nums[end];
            nums[end] = nums[start];
            nums[start] = aux;

            //Update the counters
            start++;
            end--;

        }
        return nums;
    }

}
