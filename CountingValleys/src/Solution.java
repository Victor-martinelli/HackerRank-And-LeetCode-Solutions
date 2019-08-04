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
        // TODO code application logic here
    }
    
     static int countingValleys(int n, String s) {

        int count = 0;
        int altitude = 0;
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            // Step up
            if(c=='U') {
                if(altitude == -1) {
                    count++;
                }
                altitude++;
            }
            // Step down
            else {
                altitude--;
            }
        }
        return count;
    }
    
}
