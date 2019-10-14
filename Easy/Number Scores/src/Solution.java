/*
 * 
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
        
        int n1 = 8765320;
        
        int n2 = 9765320;
        
        int n3 = 765;
        
        System.out.println("The number "+n1+" has scored: "+calculateScore(n1));
        
        System.out.println("The number "+n2+" has scored: "+calculateScore(n2));
        
        System.out.println("The number "+n3+" has scored: "+calculateScore(n3));
        
    }
    
    public static int calculateScore(int number)
    {
        return threePoints(number)+fourPoints(number)+nPowerTwoPoints(number)+sixPoints(number)+fivePoints(number);
    }
 
    //+3 for each even digit (note that 0 is even)
    public static int threePoints(int number)
    {
        int result=0;
        
        while(number!=0)
        {
            int temp = number%10;
            
            if(temp%2==0)
                result+=3;
            
            number/=10;
            
        }
        
        return result;
    }
    
    //+4 if the entire number is a multiple of 3
    public static int fourPoints(int number)
    {
        return number%3==0 ? 4 : 0 ;
    }
    
    /*
        +N^2 points for a sequence of length N (N >= 1) where each
        digit is 1 less than the previous digit. For example,
        9765320 (9-765-32-0) would be 1 + 3^2 + 2^2 + 1 = 15 points
    */
    public static int nPowerTwoPoints(int number)
    {
        
        int result = 0;
        
        int prev = number % 10;
        
        int count=1;
        
        number/=10;
        
        boolean finishedCount=false;
        
        while(number!=0)
        {
            
            int temp = number % 10;
            
            //If it the next number, we keeo the count
            if(temp-prev==1)
                count++;
            else
                finishedCount=true;
            
            prev = temp;
            
            number/=10;
            
            //If we reached the end of a sequence, we calculate it
            if(finishedCount)
            {
                result+=Math.pow(count,2);
                finishedCount=false;
                count=1;
            }
            
        }
        
        result+=Math.pow(count,2);
        
        return result;
    }
    
    /*
        +6 points for each pair of consecutive 2s. If there
        are more than two 2s in a row, add +6 for each additional 2,
        since it makes an additional pair
    */
    public static int sixPoints(int number)
    {
        
        int result=0;
        
        //Number of 2s we have consecutively seen
        int twoCount=0;
        
        while(number!=0)
        {
            
            int temp=number%10;
            
            if(temp==2)
            {
                
                twoCount++;
                
                if(twoCount>=2)
                    result+=6;
                
            }
            else
                twoCount=0;
            
            number/=10;
            
            
        }
        
        return result;
    }
    
    //+5 points for every 7 found in the number
    public static int fivePoints(int number)
    {
        int result=0;
        
        while(number!=0)
        {
            int temp = number%10;
            
            if(temp==7)
                result+=5;
            
            number/=10;
            
        }
        
        return result;
    }
    
}
