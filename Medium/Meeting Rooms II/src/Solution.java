import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        Interval n1 = new Interval(0,30);
        
        Interval n2 = new Interval(5,10);
        
        Interval n3 = new Interval(15,20);
        
        Interval[] arr = {n1,n2,n3};
        
        System.out.println("The number of meeting rooms required the following intervals: ");
        
        printIntervals(arr);
        
        System.out.println("Is: "+minMeetingRooms(arr));
        
        Interval n4 = new Interval(7,10);
        
        Interval n5 = new Interval(2,4);
        
        Interval[] arr2 = {n4,n5};
        
         System.out.println("The number of meeting rooms required the following intervals: ");
        
        printIntervals(arr2);
        
        System.out.println("Is: "+minMeetingRooms(arr2));
        
        Interval n6 = new Interval(2,8);
        
        Interval n7 = new Interval(10,18);
        
        Interval[] arr3 = {n1,n6,n7};
        
         System.out.println("The number of meeting rooms required the following intervals: ");
        
        printIntervals(arr3);
        
        System.out.println("Is: "+minMeetingRooms(arr3));
    }
    
    //https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
    //Reason for using a priority queue
    public static int minMeetingRooms(Interval[] intervals)
    {
        if(intervals==null || intervals.length==0)
            return 0;
        
        //We sort in line
        Arrays.sort(intervals,(a,b) -> a.end - b.end);
        
        //We now use a priority queue to make sure that the earliest ending meeting is kept
        //At the root of the queue. This defines how the priority queue will sort the elements
        PriorityQueue<Interval> queue = new PriorityQueue<>((a,b) -> a.end - b.end);
        
        //Since at least we will needed 1 room, we insert the first meeting into the queue
        queue.add(intervals[0]);
        
        //While there is still meetings to process
        for(int i=1;i<intervals.length;i++)
        {
            Interval current = intervals[i];
            
            Interval earliest = queue.remove();
            
            //The current meetings start time is larger than the current earliest meeting
            //Meaning that it doesnt need another room
            if(current.start>=earliest.end)
            {
                //Both intervals can be mergued since it doesnt require another room
                earliest.end= current.end;
            }
            else
            {
                queue.add(current);
            }
            
            //We add the previous intervall too
            queue.add(earliest);
        }
        
        //The size of the priority queue will determine the number of rooms needed
        return queue.size();
    }

    
    /*
    public static int minMeetingRoomsOriginal(Interval[] intervals) {
        
        int result=1;
        
        if(intervals!=null && intervals.length!=0)
        {
            //We first sort the intervals
            Arrays.sort(intervals, (Interval o1, Interval o2) -> o1.start - o2.start);
            
            //We now go through the array to check if there are any overlapping intervals
            
            int i=0;
            
            //While there is still something to compare to
            while(i+1<intervals.length)
            {
                //If the next interval overlaps the current one
                
                if(intervals[i].end>=intervals[i+1].start)
                    result++;
                
                i++;
                
            }
            
        }
        else
            result=0;
        
        return result;
    }
    */
    
    public static void printIntervals(Interval[] inter)
    {
        for(Interval in : inter)
        {
            System.out.println("Start: "+in.start+" - End: "+in.end);
        }
        System.out.println();
    }
    

}
