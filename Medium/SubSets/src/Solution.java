
import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
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
        int[] nums = {1,2,3};
        
        System.out.println("Original Array: ");
        printArray(nums);
        
        System.out.println("Solutions: ");
        printList(subsets(nums));
    }
    
     public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        result.add(new ArrayList());
        
        generateSubSets(result,new ArrayList(),0,nums);
        
        return result;
    }
    
    public static void generateSubSets(List<List<Integer>> result,List<Integer> current,int index, int[] nums)
    {
        //We add every number to current starting from index and them add it to solution
        
        if(index<nums.length)
        {
            int endIndex = current.size();

            for(int i=index;i<nums.length;i++)
            {

                current.add(endIndex,nums[i]);

                result.add(new ArrayList(current));

                //We send it to the next place

                generateSubSets(result,new ArrayList(current),i+1,nums);

                //We remove it
                current.remove(endIndex);

            }
        }
        
    }
    
     public static List<List<Integer>> subsetsAnother(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        subsetAnother(nums,result,new ArrayList(),0);
        
        return result;
    }
    
    public static void subsetAnother(int[] nums, List<List<Integer>> res,List<Integer> lst,int i){
            if(i == nums.length)
            {
                res.add(new ArrayList<>(lst));
            }
            else
            {
                subsetAnother(nums,res,lst,i+1);
                lst.add(nums[i]);
                subsetAnother(nums,res,lst,i+1);
                lst.remove(lst.size()-1);
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
