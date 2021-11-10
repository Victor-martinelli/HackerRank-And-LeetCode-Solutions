package com.victor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int countPrimes(int n) {

        //We keep an array of n length that will tell us if an element is prime or not

        boolean[] isPrime = new boolean[n];

        //Go through every element and check if they are prime
        //We only have to check up until i * i because after that, they are all prime

        for(int i = 2; i * i< n;i++){
            //If it isn't prime
            if(!isPrime[i]){
                //Go through the multiples of this number and mark them as not prime
                for(int j = i; i * j < n; j++){
                    isPrime[i * j] = true;
                }
            }
        }

        //Go through the array and count the number of trues
        int result = 0;

        for(int i = 2; i<n;i++){
            result = !isPrime[i] ? result+1 : result;
        }

        return result;
    }

    public int countPrimesOriginal(int n) {

        //Predefined list of prime numbers

        List<Integer> primeNumbers = new ArrayList(Arrays.asList(2,3,5,7));

        int result = 0;

        //Return predefined results
        if(n<3){
            result = 0;
        }
        else if(n==3){
            result = 1;
        } else if(n>=4 && n<6){
            result = 2;
        } else if(n==6 || n==7){
            result = 3;
        } else if(n==8){
            result = 4;
        }else {

            result = 4;

            //Calculate up to the desired number
            for(int i = 8;i*i<n;i++){
                //Check if the number can be divided by any of the base prime numbers
                int j = 0;
                boolean isPrime = true;

                //System.out.println("Current number to test: "+i);

                while(j<primeNumbers.size() && isPrime){

                    //System.out.println("Can the number "+i+" be divided by "+primeNumbers[j]);

                    if(i%primeNumbers.get(j)==0){
                        //Not prime
                        //System.out.println(i+" is not a prime number");
                        isPrime = false;
                    }
                    j++;
                }

                //If the number is prime
                if(isPrime){
                    //System.out.println(i+" is a prime number");
                    //Add it to the list of prime numbers to test
                    primeNumbers.add(i);
                }

            }

            result = primeNumbers.size();


        }

        return result;
    }

}
