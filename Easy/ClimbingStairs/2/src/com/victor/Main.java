package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public int climbStairs(int n) {
        return findAllWays(n,0,0);
    }

    //TIME LIMIT EXCEEDED
    public int findAllWays(int n,int step,int foundWays){
        //If we found a solution
        if(step==n){
            return foundWays+1;
        } else if(step>n){
            //If this goes over the solution
            return foundWays;
        } else {
            //Keep searching
            int oneStep = findAllWays(n,step+1,foundWays);
            int twoSteps = findAllWays(n,step+2,oneStep);

            //foundWays = oneStep>twoSteps ? oneStep : twoSteps;

            return twoSteps;
        }
    }

    public int climbStairsAnother(int n) {

        //Build the initial solution
        //+1 because solution to 0 doesn't count
        int[] solution = new int[n+1];
        solution[0] = 1;
        solution[1] = 1;

        //Go through the array until we've reached n
        //The solution to n will basically be n-1 and n-2 since we could have only reached this solution
        //By taking one or two steps, so the solution to this step is the additions of the solutions for the
        //last two steps
        for(int i = 2;i<=n;i++){
            solution[i] = solution[i-1] + solution[i-2];
        }

        return solution[n];
    }

}
