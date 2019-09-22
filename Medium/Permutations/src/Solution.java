
import java.util.ArrayList;
import java.util.List;

/*
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
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
        int [] nums = {1,2,3};
        
        System.out.println("Original Array: ");
        printArray(nums);
        
        System.out.println("Solutions: ");
        printList(permuteBackTracking(nums));
    }
    
    
     public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> current = new ArrayList();
        
        if(nums.length>0)
        {

            //We first populate the result with every inital number

            for(int i=0;i<nums.length;i++)
            {
                List<Integer> temp = new ArrayList();
                temp.add(nums[i]);
                current.add(temp);
            }

            return generatePermutation(nums,current,1);
        }
        else
        {
            current.add(new ArrayList());
            return current;
        }
    }
    
    
    public static List<List<Integer>> generatePermutation(int[] nums, List<List<Integer>> current,int count)
    {
        List<List<Integer>> result = new ArrayList();
        
        if(count!=nums.length)
        {
            
            //We add every number to the current solutions
            
            for(int i=0;i<nums.length;i++)
            {
                
                for(List<Integer> solution : current)
                {
                    
                    List<Integer> temp = new ArrayList(solution);
                    
                    if(!temp.contains(nums[i]))
                    {
                        temp.add(nums[i]);
                        result.add(temp);
                    }
                    
                }
                
            }
            
            return generatePermutation(nums,result,count+1);
        }
        else 
        {
            return current;
        }
    }
    
    public static List<List<Integer>> permuteBackTracking(int[] nums) {
       List<Integer> current = new ArrayList();
       List<List<Integer>> result= new ArrayList();
        
       generatePermutationBackTracking(current,result,nums); 
       
       return result;
    }
    
    
    public static void generatePermutationBackTracking(List<Integer> current, List<List<Integer>> result, int[] nums)
    {
        
        //If we have reached a solution
        if(current.size()==nums.length)
        {
            //We save the solution in a new list in the solution
            result.add(new ArrayList(current));
        }
        else
        {
            //We go through all the numbers to add them to the solution
            for(int i=0;i<nums.length;i++)
            {
                //If the current solution doesnt have the number
                if(!current.contains(nums[i]))
                {
                    //We add the new element at the end
                    int endIndex = current.size();

                    current.add(endIndex,nums[i]);

                    //We send it to the next step

                    generatePermutationBackTracking(current,result,nums);

                    //We remove the element for the next in this iteration
                    current.remove(endIndex);
                }
            }
        }
        
    }
    
    
    
    public static void printArray(int[] arr)
    {
        for(int elem : arr)
        {
            System.out.print(elem+" ");
        }
        System.out.println("");
    }
    
    public static void printList(List<List<Integer>> list)
    {
        for(List<Integer> temp : list)
        {
            for(Integer temp2 : temp)
            {
                System.out.print(temp2+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
}
