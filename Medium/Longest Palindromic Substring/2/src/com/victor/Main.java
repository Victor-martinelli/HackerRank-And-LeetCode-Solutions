package com.victor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public String longestPalindrome(String s) {

        String result = "";

        //Used for keeping track of the letters that we have seen so far

        //Key will be the letter and the value will be a list of the visited positions
        //of the letter
        HashMap<Character,List<Integer>> seenLetters = new HashMap();

        char[] charArray = s.toCharArray();

        //Go through the entire array
        for(int i = 0;i<charArray.length;i++){

            //Check if we have seen this character
            Character current = Character.valueOf(charArray[i]);

            if(seenLetters.containsKey(current)){

                //System.out.println("We have seen the character "+current+" before");
                //We have seen this letter before, could be palindrome

                //System.out.println("Number of times the character has been seen: "+seenLetters.get(current).size());

                //Get the ArrayList of positions and check
                for(Integer visitedPos: seenLetters.get(current)){


                    //System.out.println("Current position to consider is "+visitedPos);

                    //If the possible solution is smaller than out current solution
                    //Don't even look
                    if(result.length()<i-visitedPos+1){

                        //Go through the letters in between to check
                        int k = i-1;
                        int l = visitedPos+1;

                        //System.out.println("BEFORE - k: "+k+" - l: "+l);

                        while(k>l && k>0 && l<charArray.length && charArray[k]==charArray[l]){
                            //Keep going
                            k-=1;
                            l+=1;
                        }

                        //System.out.println("AFTER - k: "+k+" - l: "+l);

                        //If we got till the end
                        if(l>=k){
                            //Set the solution
                            result = s.substring(visitedPos,i+1);
                        }

                    }

                }

                //Update with the new index
                List<Integer> aux = seenLetters.get(current);
                aux.add(i);
                seenLetters.put(current,aux);

            } else{
                //System.out.println("We have not seen the character "+current+" before");
                //We haven't seen this letter before, store it
                List<Integer> aux = new ArrayList();
                aux.add(i);
                seenLetters.put(current,aux);
            }

        }

        //If result is empty, return the first letter
        if(result.isEmpty()){
            result = String.valueOf(s.charAt(0));
        }

        return result;
    }

    public String longestPalindromeAnother(String s) {

        //Check if there's even a solution
        if(s ==null || s.isEmpty()){return "";};

        //Indices that will give us the result

        int start = 0;
        int end = 0;

        //Go through the entire string

        for(int i = 0;i<s.length();i++){

            //Get the two possible lengths since the palindrome might be odd
            //(the middle letter might not be part of the palindrome)
            int len = Math.max(expandFromMiddle(s,i,i),expandFromMiddle(s,i,i+1));

            //Check if this could be a solution
            if(len > end - start){
                //Update to the new indices
                /// /2 is because we are expanding from the middle of the string
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }


        }

        return s.substring(start,end+1);
    }

    public int expandFromMiddle(String s,int left,int right){

        //While we haven't gone beyond the limits and the letters are the same
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        //Return the length of the solution
        return right - left - 1;
    }
}
