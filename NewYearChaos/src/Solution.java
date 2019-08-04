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
    
    static void minimumBribes(int[] q) {

    int bribe = 0;
    boolean chaotic = false;
    int n = q.length;
    for(int i = 0; i < n; i++)
    {
        //Where he is supposed to be - where he currently is
        if(q[i]-(i+1) > 2)
        {               
            //It means it took more than 2 bribes to get here
            chaotic = true;
            break;     
        }
        //Max is to avoid negative indices
        for (int j = Math.max(0, q[i]-2); j < i; j++)
            if (q[j] > q[i]) 
                bribe++;
    }
    if(chaotic)
        System.out.println("Too chaotic");
    else
        System.out.println(bribe);

    }
    
}
