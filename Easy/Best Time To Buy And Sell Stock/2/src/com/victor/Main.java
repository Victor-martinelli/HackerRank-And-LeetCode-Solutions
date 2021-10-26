package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int maxProfit(int[] prices) {
        //Max profit that we have made for sure
        int profit = 0;
        //Smallest number that we have seen so far for comparisons
        int min = Integer.MAX_VALUE;

        //Loop through all the values
        for(int i = 0; i<prices.length;i++){
            //If this value is a min
            if(min>prices[i]){
                //Update it
                min = prices[i];
            } else {
                //If by selling now we get more of a profit than before
                profit = profit > prices[i] - min ? profit : prices[i] - min;
            }
        }

        return profit;
    }

}
