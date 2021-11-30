package com.victor;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        if(s.length()>0){

            //Array that will keep the characters that we have seen
            int[] seen = new int[95];

            //First index
            int i = 0;

            result++;

            //Mark the first character for the solution
            seen['~' - s.charAt(i)]=1;

            //Second index
            int j = 1;

            //While we haven't reached the end of the String
            while(i<s.length() && j<s.length()){

                //Check if we have seen this character before
                if(seen['~' - s.charAt(j)]==0){
                    //Haven't seen this character before
                    //Add it to the solution and see if we need to update the global max
                    seen['~' - s.charAt(j)] = 1;

                    result = Math.max(result,j - i + 1);

                    j++;

                } else {
                    //We have seen this character before
                    //Move the i index and update the list of seen characters
                    seen['~' - s.charAt(i)] = 0;

                    i++;

                }

            }

        }


        return result;
    }

}
