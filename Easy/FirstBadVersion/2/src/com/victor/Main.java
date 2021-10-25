package com.victor;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int firstBadVersion(int n) {
        return findFirstBadVersion(0,n,-1);
    }

    public int findFirstBadVersion(int start, int end, int candidate){

        //System.out.println("Start: "+start+" - End: "+end);

        //If we have not reached the end
        if(start<=end){

            //First get the middle number for the binary search
            //This has an overflow bug
            //int middle = (end + start)/2;

            int middle = start + (end - start) / 2 ;

            //System.out.println("Middle: "+middle);

            //Check if it's good or bad version
            if(isBadVersion(middle)){

                //System.out.println(middle+" is a bad version");
                //It's a bad version, take it as a candidate and update end

                candidate = middle;

                //System.out.println("New candidate is "+candidate);
                end = middle - 1;

            } else {
                //System.out.println(middle+" is not a bad version");
                //Not bad version, update start
                start = middle + 1;
            }

            //System.out.println("UPDATED:  Start: "+start+" - End: "+end);

            //Keep looking
            return findFirstBadVersion(start,end,candidate);
        } else {
            //System.out.println("Simply returning candidate");
            //Done looking, return the candidate
            return candidate;
        }

    }

    public int firstBadVersionAnother(int n) {
        int start = 0;
        int end = n;

        //While both have not met

        while(start<end){

            //Get the middle
            int middle = start + (end - start) /2;

            //If this version is bad
            if(isBadVersion(middle)){
                //Update end to middle since this might be the starting bad version too
                end = middle;
            } else {
                //This is not a bad version update the start
                start = middle +1;
            }

        }

        return start;
    }
}
