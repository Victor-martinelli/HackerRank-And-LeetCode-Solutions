package com.victor;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int strStr(String haystack, String needle) {

        int result = 0;

        if(needle.length()>haystack.length()){
            return -1;
        }

        if(!haystack.isEmpty() && !needle.isEmpty()) {


            int hayIndex = 0;

            int nedIndex = 0;

            //Go through the entire haystack, checking if the first instance of the neddle is found
            while(hayIndex<haystack.length() && nedIndex<needle.length()){

                //System.out.println("Checking haystack char "+haystack.charAt(hayIndex)+" with needle char "+needle.charAt(nedIndex));

                //If it matches the index
                if(haystack.charAt(hayIndex)==needle.charAt(nedIndex)){
                    //Check if the index of the neddle is 0, it means that we are at the start of the solution and need to remember it
                    if(nedIndex==0){
                        //System.out.println("Possible starting solution found, setting result to current neddle index, which is "+nedIndex);
                        result = hayIndex;
                    }

                    //Increment the neddle index to go to the next character
                    nedIndex++;
                } else {
                    //System.out.println("Setting index back to 0 for needle index");

                    //First set the haystack to the result index since we might have skipped over a possible result with this result. The reason why to the result index is because it will be incremented to the next one later
                    if(result!=-1){
                        hayIndex = result;
                        result = -1;
                    }

                    //Set the needle index back to 0
                    nedIndex = 0;
                }
                //Go to the next value in the haystack
                hayIndex++;
            }


            //Did we get to the end of the needle
            result = nedIndex==needle.length() ? result : -1;

        } else {

            //If both of them are empty
            if(haystack.isEmpty() && needle.isEmpty()){
                result = 0;
            } else if(haystack.isEmpty()){
                //Haystack is empty, so it cannot have a neddle
                result = -1;
            } else{
                //Needdle is empty, it is in haystack
                result = 0;
            }

        }


        return result;
    }

    public int strStr2(String haystack, String needle) {
        //If needle is empty, not even look
        if(needle.isEmpty())
        {
            return 0;
        }

        int hLength = haystack.length();

        int nLength = needle.length();

        //If the needle is larger than the haystack, there's no solution
        if(nLength<=hLength){

            //Loop through the character in the haystack up until hLength - nLength because after we have reached a
            // length that is shorter than the needle, there's no solution
            for(int i = 0;i<=hLength - nLength;i++){

                //Index for the needle
                int j;
                //Go through the needle
                for(j=0;j<nLength;j++){
                    //If the character is not the same
                    //i+j is so that we can get the current char for the haystack and the needle at the same time
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        //Not a solution
                        break;
                    }
                }

                //If we have reached the end of the needle
                if(j==nLength){
                    //i has the index of the solution
                    return i;
                }
                //Not a solution, keep looking

            }

        }
        //If we got all the way here, no solution
        return -1;

    }

}
