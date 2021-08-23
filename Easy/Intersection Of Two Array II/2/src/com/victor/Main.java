package com.victor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    //Complexity O(nlogn) where n is the longest array
    public int[] intersect(int[] nums1, int[] nums2) {

        //Sort both of them
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //get the smallest array
        int resultSize = nums1.length > nums2.length ? nums2.length : nums1.length;

        //Current solution (let's assume that the longest solution will be all the ones in the
        //smallest array)
        int[] result = new int[resultSize];

        int resultIndex = 0;

        //Indices for all the arrays

        int i=0;
        int j=0;



        //Loop over one of the array and check
        while(i<nums1.length && j<nums2.length){

            //If we have found the same number
            if(nums1[i]==nums2[j]){
                //Put it in the solution
                result[resultIndex] = nums1[i];
                //Increment the resultIndex
                resultIndex++;
                //Increment both of them
                i++;
                j++;
            } else if(nums1[i]<nums2[j]){
                //Increment i since it's smaller than the other one
                i++;
            } else {
                //Increment the other index
                j++;
            }

        }


        //Copy the final result
        result = Arrays.copyOfRange(result,0,resultIndex);

        return result;
    }

    public int[] intersectAnotherSolution(int[] nums1, int[] nums2) {

        //Sort both of them
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //Get the size of both arrays

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        //Pointers for 1. nums1 2. nums2 3. solution that will be stored in first array
        //This is because we don't really need to use the original array and can use it to
        int i = 0;
        int j = 0;
        int k = 0;


        while(i<nums1Length && j<nums2Length){

            //If one number is larger than the other one, we increment the pointer
            //that is pointing to the smallest one

            if(nums1[i]<nums2[j]){
                i++;
            } else if(nums1[i]>nums2[j]){
                j++;
            } else{
                //Grab the number and put in the first array as a solution
                //k++ and i++ will post increment the pointers after we set them
                nums1[k++] = nums1[i++];

                //Also increment j, since it is the same as i
                j++;

            }

        }

        //Finally, copy the result array
        nums1 = Arrays.copyOfRange(nums1,0,k);


        return nums1;
    }
}
