
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
        
        int [] arr = new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5};
        
        int index = 2;
        
        System.out.println("The "+index+"th rarest element in the following array is: ");
        
        printArr(arr);
        
        int x = nthMostRare(arr, index);
        
        System.out.println(index+"th rarest element: "+x);
    }

    public static int nthMostRare(int[] elements, int n) {

        if (elements.length > 0 && n > 0) {
            //Number in array and occurences
            HashMap<Integer, Integer> map = new HashMap();

            //Store every number as key and their frequency as value
            for (int i = 0; i < elements.length; i++) {

                if (!map.containsKey(elements[i])) {
                    map.put(elements[i], 1);
                } else {
                    map.put(elements[i], map.get(elements[i]) + 1);
                }

            }

            //We get the values and sort to find the value we want
            List<Integer> values = new ArrayList(map.values());

            Collections.sort(values);

            //If the nth that we are trying to get is larger than the number of unique
            //values
            if (n <= values.size()) {
                //We get the desired frequency and look for it's key

                int resultFreq = values.get(n - 1);

                Set<Integer> keys = map.keySet();

                for (Integer k : keys) {
                    if (map.get(k) == resultFreq) //Found the key
                    {
                        return k;
                    }
                }
                return -1;
            } else {
                return -1;
            }

        } else {
            return -1;
        }
    }
    
    public static void printArr(int [] arr)
    {
        for(int el : arr)
        {
            System.out.print(el+" ");
        }
        
        System.out.println();
        
    }

}
