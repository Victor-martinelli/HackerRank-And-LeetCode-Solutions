package com.victor;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public static int firstUniqChar(String s) {

        //Store all the times that we've seen the characters

        HashMap<Character,Integer> characters = new HashMap();

        //Go through the string and see the number of times each of the characters appears
        char[] sChar = s.toCharArray();

        for(int i=0;i<s.length();i++){

            //Check if the character is already there
            Integer numTimes = characters.get(sChar[i]);

            //System.out.println("Current number of times for "+sChar[i]+" is "+numTimes);

            //If it's there
            if(numTimes!=null){
                //Simply update
                //System.out.println(sChar[i]+" is already been found, incrementing number of times");
                numTimes+=1;
            } else {
                //Start counter at 1
                //System.out.println("First time "+sChar[i]+" has been found");
                numTimes = 1;
            }

            characters.put(sChar[i],numTimes);

        }

        //Loop through the String in order to find the first unique character

        for(int i=0;i<s.length();i++){

            //If we only found this character once
            if(characters.get(sChar[i])==1){
                return i;
            }

        }

        return -1;
    }
}
