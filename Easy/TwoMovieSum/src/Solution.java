import java.util.HashMap;

/*
 * Like 2 Sum but with movies, movies must end 30 minutes before landing
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
        int flightDuration = 110;
        
        int [] movies = {20,70,90,30,60,110};
        
        int flightDuration2 = 250;
        
        int [] movies2 = {110,180,40,120,10};
        
        int flightDuration3 = 90;
        
        int [] movies3 = {1,10,25,35,60};
        
        System.out.print("Indices for the movies played for the flight with duration "+flightDuration+" are ");
        
        print(movieIndices(flightDuration,movies));
        
        System.out.print("Indices for the movies played for the flight with duration "+flightDuration2+" are ");
        
        print(movieIndices(flightDuration2,movies2));
        
        System.out.print("Indices for the movies played for the flight with duration "+flightDuration3+" are ");
        
        print(movieIndices(flightDuration3,movies3));
    }
    
    public static int[] movieIndices(int flightDuration, int [] movieDuration)
    {
        int totalMoviesDuration = flightDuration - 30;
        
        HashMap<Integer,Integer> leftOver = new HashMap();
        
        int [] result = new int[2];
        
        for(int i=0;i<movieDuration.length;i++)
        {
            
            if(leftOver.containsKey(movieDuration[i]))
            {
                result[0] = leftOver.get(movieDuration[i]);
                
                result[1] = i;
            }
            else
            {
                leftOver.put(totalMoviesDuration - movieDuration[i],i);
            }
            
        }
        
        
        return result;
    }
    
    public static void print(int [] indices)
    {
        System.out.println(indices[0]+" "+indices[1]);
    }
    
}
