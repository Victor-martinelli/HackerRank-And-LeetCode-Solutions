
import java.math.BigInteger;

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
        
        String test = "-42";
        
        myAtoi(test);
    }
    
    
     public static int myAtoi(String str) {
        

		if(str==null || str.length() == 0)
			return 0;
                
		String trimmedString = str.trim();

		int sign =1;
		int startIndex = 0;
                
                //If there is at least 1 character and the it's the minus sign 
		if(startIndex<trimmedString.length() && trimmedString.charAt(startIndex) == '-') {
			sign = -1;
                        
                        //We move to the next character
			startIndex++;
		}else if(startIndex<trimmedString.length() && trimmedString.charAt(startIndex) == '+') { //Same as before but with + sign
			startIndex++;
		}

                //This is for removing left 0's
		while(startIndex<trimmedString.length() && trimmedString.charAt(startIndex) == '0'){
			startIndex++;
		}

                //We use long in case of an integer overflow
		long output = 0;
                
                //While there is a string left and we find a number
		while(startIndex<trimmedString.length() && trimmedString.charAt(startIndex) >= '0'  && trimmedString.charAt(startIndex) <= '9') {
                    //We add the current number to the solution (The final 0 is to convert it into decimal from ASCII)
			output =output*10+(trimmedString.charAt(startIndex)-'0');
			startIndex++;
			
                        //If we overflow the integer, we stop
			if(output>Integer.MAX_VALUE) {
				break;
			}
		}

                
		output = sign*output;
		if(output>Integer.MAX_VALUE) {
			output = Integer.MAX_VALUE;
		}

		if(output<Integer.MIN_VALUE) {
			output = Integer.MIN_VALUE;
		}
		return (int)output;
	
    }
    
    
    public static int myAtoiOriginal(String str) {
        
        String trimmed = str.trim();
        
        int result=0;
        
        boolean canBeConverted=false;
        
        if(trimmed.length()>0 && Character.isDigit(trimmed.charAt(0)))
        {
            canBeConverted=true;
        }
        else if(trimmed.length()>0 && (trimmed.charAt(0)=='+' || trimmed.charAt(0)=='-'))
        {
            if(trimmed.length()>1 && Character.isDigit(trimmed.charAt(1)))
            {
                canBeConverted=true;
            }
        }
        
        
        if(canBeConverted)
        {

            int i=1;
            
            boolean finished=false;
            
            while(i<trimmed.length() && !finished)
            {
                if(Character.isDigit(trimmed.charAt(i)))
                {
                    i++;
                }
                else
                {
                    finished=true;
                }
            }
            
            BigInteger  temp = new BigInteger (trimmed.substring(0,i));
            
            if(temp.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))==1)
            {
                result=Integer.MAX_VALUE;
            }
            else if(temp.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))==-1)
            {
                result=Integer.MIN_VALUE;
            }
            else
            {
                result=temp.intValue();
            }
            
            
        }
        
        
        return result;
        
    }
    
}
