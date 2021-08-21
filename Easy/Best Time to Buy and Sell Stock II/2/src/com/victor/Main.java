package com.victor;

public class Main {

    public static void main(String[] args) {



    }


    public static int maxProfit(int[] prices) {

        int profit = 0;

        for(int i =0; i<prices.length;i++){
            //If we can make a profit
            if(prices[i+1]>prices[i]){
                //Buy and sell the stock

                profit+=prices[i+1]-prices[i];

            }
        }

        return profit;
    }
}
