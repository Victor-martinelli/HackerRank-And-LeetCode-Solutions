
import java.util.HashMap;

/*
 * Given a string, we want to know the maximum no. of occurrences of any substring that satisfies following two conditions:

The substring’s lengths is within in inclusive range of minLength to maxLength.

The total no. of unique characters in the string doesn’t exceed maxUnique.

For example, given a string s=abcde, minLength=2, maxLength=5, maxUnique=3, 
the substrings matching the criteria are (ab, bc, cd, de, abc, bcd, cde). 
Any shorter string fails he minLength>=2 any longer will fail maxUnique <= 3. 
Each of the substring occurs only one time.

INPUT :
First line contains a string, second line contains minLength, third line 
contains maxLength, and the last line contains maxUnique.

Constraints :

2<=n<=105
2<=minLength<= maxLength <=26
maxLength<n
2<=maxUnique<=26
SAMPLE INPUT :

ababab
2
3
4
SAMPLE OUTPUT :

3
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
        String s1 = "ababab";
        
        int min1 = 2;
        int max1=3;
        int mUnique1=4;
        
        String s2 = "aabaadfgadaa";
        int min2 = 2;
        int max2=5;
        int mUnique2=4;
        
        System.out.println("The frequency of the most common substring in : "+s1+" that has a min length of "+min1+" , a max length of "+max1+" , and "
                + "a max number of unique characters of "+mUnique1+" is: "+mostCommonSubstring(s1,min1,max1,mUnique1));
        
        System.out.println("The frequency of the most common substring in : "+s2+" that has a min length of "+min2+" , a max length of "+max2+" , and "
                + "a max number of unique characters of "+mUnique2+" is: "+mostCommonSubstring(s2,min2,max2,mUnique2));
    }
    
    public static int mostCommonSubstring(String s, int min,int max,int maxFreq)
    {
        
        //If the input is not valid
        
        if(s.length()==0 || min<0 || max<0 || maxFreq<=0 || min>max || s.length()<min)
            return -1;
        
        int result=0;
        
        //Store every frequency so far
        HashMap<String,Integer> frequencies = new HashMap();
        
        //We test every combination possible
        for(int n =min;n<=max;n++)
        {
            //Ending point
            int j=n-1;
            
            //Starting point
            for(int i=0;j<s.length();i++)
            {
                String current = s.substring(i, j+1);
                
                //If the number of unique characters of the current substring is not greater than maxUnique
                if(validMaxUnique(current,maxFreq))
                {
                    
                    //We store it in the hashmap and store the max frequency found so far
                    
                    frequencies.put(current, frequencies.getOrDefault(current,0)+1);
                    
                    result = Math.max(result,frequencies.get(current));
                    
                }
                
                j++;
                
            }
            
        }
        
        return result;
    }
    
    public static boolean validMaxUnique(String substring,int maxUnique)
    {
       //HashMap for every character
        HashMap<Character,Integer> characters = new HashMap();
        
        boolean result=true;
        
        int i=0;
        //We go through the entire string and stop if any character goes beyond maxUnique
        
        while(i<substring.length() && result)
        {
            
            char current = substring.charAt(i);
            
            //We increment the frequency of the current char
            characters.put(current,characters.getOrDefault(current,0)+1);
            
            //If it went above the maxUnique
            if(characters.get(current)>maxUnique)
                result=false;
            
            i++;
        }
        
        return result;
    }
    
}
