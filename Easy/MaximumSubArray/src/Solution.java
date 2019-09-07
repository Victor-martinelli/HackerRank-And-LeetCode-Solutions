/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
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
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.print("The contiguos array which has the largest sum in the array: ");

        printArray(nums);

        System.out.println("is: " + maxSubArray(nums));

    }

    public static int maxSubArrayOriginal(int[] nums) {

        int finalSolution = nums[0];

        int currentSolution = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //We check if the current element is better than the sum of our current solution with that element
            currentSolution = Math.max(currentSolution + nums[i], nums[i]);

            //We know check if the current solution is better than our final solution
            finalSolution = Math.max(finalSolution, currentSolution);
        }

        return finalSolution;
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
