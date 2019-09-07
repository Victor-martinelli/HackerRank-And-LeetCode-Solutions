/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s="aba";
        
        long n=10;
        
        
        repeatedString(s,n);
    }
    
    public static long repeatedString(String s, long n) {
        
        long count =0;
        for(char c : s.toCharArray())
            if(c == 'a')
                count++;

        //Number of times the entire string s will be in the final string
        long factor = (n/s.length());
        
        //Length of the remaining substring that is just a part of s
        long rem = (n%s.length());
        
        //Number of a's in the number of times of s in the final string
        count =  factor*count  ;
        for(int i=0;i<rem;i++)
            if(s.charAt(i)=='a')
                count++;        

        return count;
    }
    
}
