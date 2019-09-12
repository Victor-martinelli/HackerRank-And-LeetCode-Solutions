
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of distinct elements. The task is to find triplets in array whose sum is zero.

Examples :

Input : arr[] = {0, -1, 2, -3, 1}
Output : 0 -1 1
         2 -3 1

Input : arr[] = {1, -2, 1, 0, 5}
Output : 1 -2  1
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
        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = tripletSum(arr);

        System.out.println("Result List");

        printList(result);

    }

    public static List<List<Integer>> tripletSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i]; //This sum is so that lo+hi counters sum
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> tripletSumOriginal(int[] arr, int target) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList();

        //Standart Pivot that we change with every iteration
        for (int i = 0; i < arr.length - 1; i++) {

            //Set the right and left pivot for every iteration
            int l = i + 1;

            int r = arr.length - 1;

            //While they dont meet
            while (l < r) {

                int candidate = arr[i] + arr[r] + arr[l];

                //If it's the same, we add it to the solution
                if (candidate == target) {

                    List<Integer> temp = new ArrayList();

                    temp.add(arr[i]);

                    temp.add(arr[l]);

                    temp.add(arr[r]);

                    if (!result.contains(temp)) //This is to not return the same result twice
                    {
                        result.add(temp);
                    }

                    l++;

                    r--;

                } else if (candidate < target) //If its less, we increment the left pivot
                {
                    l++;
                } else //If it's more, we increment the right pivot
                {
                    r--;
                }

            }

        }

        return result;
    }

    public static void printList(List<List<Integer>> lista) {
        for (List<Integer> current : lista) {
            for (Integer element : current) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
