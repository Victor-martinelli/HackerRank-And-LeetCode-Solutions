/*
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
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
        
        ShuffleArray arr = new ShuffleArray(nums);
        
        System.out.print("ORIGINAL ARRAY: ");
        printArray(arr.reset());
        
        System.out.println();
        
        int[] shuffle = arr.shuffle();
        
         System.out.print("SHUFFLED ARRAY: ");
        printArray(shuffle);
        
        System.out.println();
        
        System.out.print("RESET ARRAY: ");
        printArray(arr.reset());
        
        System.out.println();
        
    }
    
    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
    
}
