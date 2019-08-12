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
       int test = -123;
       
       System.out.println("The reverse of "+test+" is: "+reverse(test));
    }
    
     public static int reverse(int x) {
        
        boolean isNeg=false;
        
        int temp=0;
        
        long result=0;
        
        if(x<0)
        {
            isNeg=true;
            
            x*=-1;
        }
        
        
        while(x>0)
        {
            
            temp=x%10;
            
            x/=10;
            
            result=result*10+temp;
            
        }
        
        if(isNeg)
        {
            result*=-1;
        }
        
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)
        {
            result=0;
        }
        
        return (int)result;
        
}
    
    public int reverseOriginal(int x) {
        
        String temp = new StringBuilder(String.valueOf(x)).reverse().toString();
        
        boolean minus = false;
        
        long result=0;
        
        if(x<0)
        {
            minus=true;
            temp=new StringBuilder(String.valueOf(-x)).reverse().toString();
        }
        
        boolean finished=false;
        
        int i=0;
        
        while(i<temp.length() && !finished)
        {
            
            result+=(temp.charAt(i)-'0')*Math.pow(10,temp.length()-1-i);
            
            
            if(result>Integer.MAX_VALUE)
            {
                result=0;
                finished=true;
            }
            else if(minus && result*-1<Integer.MIN_VALUE)
            {
                result=0;
                finished=true;
            }
            
            i++;
            
        }
        
        if(minus)
            {
                result*=-1;
            }
        
        return (int)result;
    }
    
}
