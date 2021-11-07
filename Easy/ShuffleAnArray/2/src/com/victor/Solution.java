package com.victor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private int[] nums;

    //private int[] original;

    public Solution(int[] nums) {
        this.nums = nums;


        //this.original = nums;
    }

    public int[] reset() {
        //this.nums = original;

        return this.nums;
    }

    public int[] shuffle() {

        //https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java

        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i<nums.length;i++){
            result.add(nums[i]);
        }

        Collections.shuffle(result);

        return result.stream().mapToInt(i->i).toArray();
    }

}
