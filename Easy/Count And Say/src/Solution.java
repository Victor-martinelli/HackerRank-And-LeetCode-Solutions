/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
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
        int n=20;
        
        System.out.println("Sequence until number "+n+" : "+countAndSay(n));
        
    }
    
    
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String preStr = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        char previous = preStr.charAt(0);
        int num = 1;
        for (int i = 1; i < preStr.length(); i++) {
            char cur = preStr.charAt(i);
            if (cur == previous) {
                num++;
            } else {
                result.append(num).append(previous);
                previous = cur;
                num = 1;
            }
        }
        result.append(num).append(previous);
        return result.toString();
    }
    
    public static String countAndSayOriginal(int n) {
        
        String result="1";
        
        if(n>=1 && n<=30)
        {
            for(int i=1;i<n;i++)
            {

                String previous = result;

                result="";

                int counter=1;

                for(int j=0;j<previous.length();j++)
                {

                    if(j+1>=previous.length() || previous.charAt(j)!=previous.charAt(j+1))
                    {

                        result=result+counter+""+previous.charAt(j);
                        //System.out.println("Current result: "+result);
                        counter=1;
                    }
                    else
                    {
                        counter++;
                        //System.out.println("Current counter: "+counter);
                    }

                }
                //System.out.println("step: "+i+" result: "+result);

            }
        }
        else
            result="";
        
        
        return result;
    }
    
    
}
