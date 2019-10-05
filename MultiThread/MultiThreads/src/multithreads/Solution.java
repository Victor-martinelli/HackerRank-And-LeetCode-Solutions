/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

class Task1 extends Thread
{
    
    public void run(){ //SIGNATURE
        
        System.out.print("\nTask1 Started");
        
        for(int i=101; i<=199;i++)
            System.out.print(i+" ");
        
        System.out.print("\nTask1 Done");
        
    }
    
    
}

class Task2 implements Runnable
{
    
    public void run(){ //SIGNATURE
        
        System.out.print("\nTask2 Started");
        
        for(int i=201; i<=299;i++)
            System.out.print(i+" ");
        
        System.out.print("\nTask2 Done");
        
    }
    
    
}


public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        System.out.print("\nTask1 Kicked Off");
        Task1 t1 = new Task1();
        
        t1.start(); //NOT t1.run();
        
        System.out.print("\nTask2 Kicked Off");
        Task2 t2 = new Task2();
        Thread t2Thread = new Thread(t2);
        
        t2Thread.start();
        
        //We now wait until they are both done before continuing
        t1.join();
        t2Thread.join();
        
         System.out.print("\nTask3 Kicked Off");
         for(int i=301; i<=399;i++)
            System.out.print(i+" ");
        
        System.out.print("\nTask3 Done");
        
    }
    
}
