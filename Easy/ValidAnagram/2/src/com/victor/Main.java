package com.victor;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isAnagram(String s, String t) {

        //Create a HasMap that will hold the number of times that we've
        //seen each character

        HashMap<Character,Integer> chars = new HashMap<Character,Integer>();

        //Go through the first string

        for(int i = 0; i < s.length(); i++){

            //Get the character
            char current = s.charAt(i);

            //If it contains it
            if(!chars.containsKey(current)){
                //Add new value
                chars.put(current,1);
            } else {
                //Increment the value
                int currentValue = chars.get(current);
                chars.put(current,currentValue+1);
            }

        }

        //Do the same thing for the other string
        //Go through the first string

        for(int i = 0; i < t.length(); i++){

            //Get the character
            char current = t.charAt(i);

            //If it contains it
            if(!chars.containsKey(current)){
                //Add new value
                chars.put(current,1);
            } else {
                //Increment the value
                int currentValue = chars.get(current);
                chars.put(current,currentValue-1);
            }

        }


        //Now go through the keys and see if it is all zeroes

        for(char current : chars.keySet()){

            int value = chars.get(current);
            //If not zero, not the same amount was used
            if(value!=0){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramANother(String s, String t) {

        //Check if both are the same length, if they are not they will never be
        //anagrams

        if(s.length()==t.length()){

            //Since it's only lowercase english letters, it will never go beyong
            //26 characters so we can keep a int array representing each character
            int[]chars = new int[26];

            //Go through both array and increment when we see a character from
            //the first string and decrement when found from the second

            for(int i = 0; i < s.length(); i++){
                //We use 'a' because in unicode a is the first character in the alphabet,
                //so when we do a minus with another number, it will start from index 0
                // b - a --> 94 - 93 = 1 index
                chars[s.charAt(i) - 'a']++;
                chars[t.charAt(i) - 'a']--;
            }

            //Now we simply check that all the numbers are zero since it means that
            //It was found twice or not at all

            for(int current : chars){
                if(current!=0){
                    return false;
                }
            }

            //Got here, all are zero
            return true;

        } else{
            return false;
        }

    }

    public boolean isAnagramAnotherANother(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

}
