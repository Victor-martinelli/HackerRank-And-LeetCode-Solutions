
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
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
        int[] nums = {1,1,1,2,2,2,3};
                
        System.out.println("Original Array: ");
        
        printArr(nums);
        
        int k = 1;
        
        System.out.println("Result: ");
        printList(topKFrequent(nums,k));
        
    }
    
     public static List<Integer> topKFrequent(int[] nums, int k) {
      
        //We store the frequency of each element and keep track of the most frequent element in a variable
        
        int mostFrequent=0;
        
        HashMap<Integer,Integer> map = new HashMap();
        
        for(int el : nums)
        {
            //We put the element in the HashMap and the value will be the same one as in map or 0 plus a 1
            map.put(el,map.getOrDefault(el,0)+1);
            
            //We keep track of the most frequent element in the array
            
            mostFrequent = Math.max(map.get(el),mostFrequent);
            
        }
        
        //We now store each element in buckets depending on frequency
        
        //Array of Lists
        List<Integer>[] buckets = new List[mostFrequent+1];
        
        
        for(Integer el : map.keySet())
        {
            int frequent = map.get(el);
            
            //If the list in that position has not been initialized
            if(buckets[frequent]==null)
                buckets[frequent] = new ArrayList();
            
            //We simply add the element to that specific frequency
            buckets[frequent].add(el);
            
        }
        
        List<Integer> result = new ArrayList();
        
        //We now return the result traversing the bucket list from the end
        
        int i=buckets.length-1;
        
        while(i>=0 && k>0)
        {
            //If the current list has some elements
            if(buckets[i]!=null)
            {
                List<Integer> current = buckets[i];
                
                //We add elements until there are no more left or k is equal to 0
                while(!current.isEmpty() && k>0)
                {
                    //We remove an element and add it to the solution
                    result.add(current.get(0));
                    
                    //Decrement k
                    k--;
                    
                    //And finally remove it from the bucket list
                    current.remove(0);
                }
                
            }
            i--;
            
        }            
        return result;
    }
    
    public static List<Integer> topKFrequentOriginal(int[] nums, int k) {
        //We first count the frequency of each unique element
        
        HashMap<Integer,Integer> map = new HashMap();
        
        for(int el : nums)
            map.put(el,map.getOrDefault(el,0)+1); //Get the value for n and if it isnt there, then return 0
        
        //We now build a priorityqueue to sort the list of frequencies    
            
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> map.get(n1) - map.get(n2));
        
        //We go through every key
        
        for(int elem : map.keySet())
        {
            heap.add(elem);
            
            //If we go over the amount that we want to return
            if(heap.size()>k)
                heap.poll(); // We remove the element with the least frequency from the queue
            
        }
        
        
        //We know build the result list
        
        List<Integer> result = new ArrayList();
        
        //While the queue is not empty, we remove elements and add them to the solution
        
        while(!heap.isEmpty())
            result.add(heap.poll());
        
        //We reverse the list since it's sorted from less frequent to more
        Collections.reverse(result);
        
        return result;
    }
    
    public static void printArr(int [] arr)
    {
        for(int el : arr)
            System.out.print(el+" ");
        
        System.out.println("");
    }
    
    public static void printList(List<Integer> list)
    {
        for(Integer el : list)
            System.out.print(el+" ");
        
        System.out.println("");
    }
    
}
