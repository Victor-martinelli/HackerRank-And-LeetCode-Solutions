package com.victor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList();

        //Array that will hold the Strings that have already been visited
        int[] indexes = new int[strs.length];

        //Go through the indexes array

        int i = 0;

        while(i<indexes.length){

            //If this is one of the indexes that have not been found yet
            if(indexes[i]==0){

                //Other index that will be used for comparison
                int j = i + 1;

                //HashMap that will be used to figure out the number of
                //Characters that the solutions should have
                HashMap<Character,Integer> countChars = filledHashMap(strs[i]);

                //Current solution if we do find something
                List<String> currentSolution = new ArrayList();

                //Go through the rest of the indexes
                while(j<indexes.length){
                    //If it's not a value that we have found already or if
                    //It's not the same length as the curretn candidate

                    if(indexes[j]==0 && strs[j].length()==strs[i].length()){

                        //Fill the array and compare

                        HashMap<Character,Integer> candidateSolution = filledHashMap(strs[j]);

                        boolean same = true;

                        //Check if they are both the same
                        for(Character aux : candidateSolution.keySet()){

                            if(candidateSolution.get(aux)!=countChars.get(aux)){
                                same=false;
                                break;
                            }
                        }

                        //See what happened
                        if(same){
                            currentSolution.add(strs[j]);
                            //Set the number so that it isn't checked again
                            indexes[j]=1;
                        }

                    }
                    //Go to the next index
                    j++;
                }

                //Add ourselves to the solution and to the main solution too
                currentSolution.add(strs[i]);
                result.add(currentSolution);

            }
            //Go to the next index
            i++;
        }

        return result;
    }

    private HashMap<Character,Integer> filledHashMap(String current){

        HashMap<Character,Integer> result = new HashMap<>();

        //Go through and fill it
        for(Character aux : current.toCharArray()){

            //If the character is not found
            if(!result.containsKey(aux)){
                //Put it inside
                result.put(aux,1);
            } else {
                //Simply increment
                result.put(aux,result.get(aux)+1);
            }

        }
        return result;
    }

    public List<List<String>> groupAnagramsANother(String[] strs) {

        HashMap<String,List<String>> result = new HashMap();

        //Go through all the strings and sort them

        for(String current : strs){

            //Convert the String to a char array and sort
            char[] currentArray = current.toCharArray();

            Arrays.sort(currentArray);

            //Convert back to String and check if it's in the HashMap

            String sortedCurrent = new String(currentArray);

            //If it's not in the HasMap, we create the entry and then add it
            if(result.get(sortedCurrent)==null) result.put(sortedCurrent,new ArrayList());

            result.get(sortedCurrent).add(current);

        }

        return new ArrayList(result.values());
    }

    public List<List<String>> groupAnagramsEvenAnother(String[] strs) {

        HashMap<String,List<String>> result = new HashMap();

        //Go through all the strings  while building the array of counts

        for(String current : strs){

            //Array that will hold the number of times that we have have found each character
            //26 since that's the number of characters in the english language
            int[] matches = new int[26];

            //Go through the current string
            for(Character aux: current.toCharArray()){
                matches[aux - 'a']++;
            }

            //Now build the String
            StringBuffer rawKey = new StringBuffer();

            for (int match : matches) {
                rawKey.append("#").append(match);
            }

            String key = rawKey.toString();

            //If it's not in the HasMap, we create the entry and then add it
            result.computeIfAbsent(key, k -> new ArrayList());

            result.get(key).add(current);

        }

        return new ArrayList(result.values());
    }
}
