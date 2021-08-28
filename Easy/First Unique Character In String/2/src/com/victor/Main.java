package com.victor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public int firstUniqChar(String s) {

        //Keep list of already searched characters
        Set<String> searchedCharacters = new HashSet<>();

        int result = -1;

        int i = 0;

        //Go through the entire string
        while(i<s.length() && result==-1){

            //Get the candidate
            String current = Character.toString(s.charAt(i));

            //If we haven't searched it before
            if(!searchedCharacters.contains(current)){

                //Get the last index of the character and see if they match
                int auxIndex = s.lastIndexOf(current);

                if(auxIndex==i){
                    //Solution found
                    result = i;
                } else {
                    //Add to list of searched chars and keep looking
                    searchedCharacters.add(current);
                }

            }
            //Increment index
            i++;
        }


        return result;
    }

    public int firstUniqCharTwo(String s) {

        //Keep Hashmap of the characters that we have already seen
        HashMap<Character,Integer> chars = new HashMap<Character,Integer>();

        //Go through the entire String to categorize everything
        for(int i = 0; i < s.length(); i++){

            char current = s.charAt(i);

            //If we have not seen this character before
            if(!chars.containsKey(current)){
                //Add it with the index
                chars.put(current,i);
            } else {
                //Simply negate it
                chars.put(current,-1);
            }

        }

        //Smallest value we have seen so far
        int min = Integer.MAX_VALUE;

        //Now go through the entire chars that could be a solution
        for(Character current : chars.keySet()){

            int currentIndex = chars.get(current);

            //If the index is smaller than our smallest
            if(currentIndex<min && currentIndex != -1){
                min = currentIndex;
            }

        }

        //return solution
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
