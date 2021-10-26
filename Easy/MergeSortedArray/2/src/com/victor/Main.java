package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //Result array
        int[] result = new int[m+n];

        //Go through both arrays until we are done
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<m || j<n){

            //If both of them are not over the arrays
            if(i<m && j<n){
                //Compare the numbers
                if(nums1[i]<nums2[j]){
                    //Put the number in i into the result
                    result[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    //Copy j
                    result[k] = nums2[j];
                    j++;
                    k++;
                }
            } else if(i<m){
                //Put the number in i into the result
                result[k] = nums1[i];
                i++;
                k++;
            } else {
                //Copy j
                result[k] = nums2[j];
                j++;
                k++;
            }

        }

        //Copy the result to nums1
        for(int z = 0;z<result.length;z++){
            nums1[z] = result[z];
        }

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        //This is basically the same solution as above but without using the extra space
        //Decrement both of the sizes since we'll be starting from the end of both of them
        m--;
        n--;

        //Index at the end of nums1 since we'll be building the result from the ned
        int resultIndex = nums1.length -1;

        //While we haven't reached the end of the array
        while(resultIndex>=0){
            //If we have reached the end of the first array
            if(m<0){
                //Copy the contents from the second array
                nums1[resultIndex] = nums2[n];
                n--;
            } else if(n<0){ //If we have reached the end of the second ara=ray
                nums1[resultIndex] = nums1[m];
                m--;
            } else {
                //We have to do a comparison to get the biggest number
                if(nums1[m]<nums2[n]){
                    nums1[resultIndex] = nums2[n];
                    n--;
                } else {
                    nums1[resultIndex] = nums1[m];
                    m--;
                }
            }
            resultIndex--;
        }

    }
}
