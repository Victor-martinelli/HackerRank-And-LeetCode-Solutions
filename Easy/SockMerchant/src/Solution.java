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
    
    static int sockMerchant(int n, int[] ar) {

        int solution=0;

        boolean socks [] = new boolean [n];

        for(int i=0;i<n;i++)
        {
            if(socks[i]==false)
            {
                int j=0;
                boolean found=false;
                while(j<n && !found)
                {
                    if(i!=j && ar[i]==ar[j] && socks[j]==false)
                    {
                        socks[i]=true;
                        socks[j]=true;
                        solution++;
                        found=true;
                    }
                    else
                    {
                        j++;
                    }
                }
            }
        }

        return solution;
    }
    
}
