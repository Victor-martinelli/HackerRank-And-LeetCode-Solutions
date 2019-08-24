
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class ShuffleArray {
    private int[] original;
    
    public ShuffleArray(int[] nums) {
        original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        Random randomizer = new Random();
        
        int [] result = original.clone();
        
        for(int i=0;i<original.length;i++)
        {
            
            int pos1 = randomizer.nextInt(original.length-i)+i;
            
            int aux = result[pos1];
            
            result[pos1] = result[i];
            
            result[i] = aux;
        }
        
        
        return result;
    }
}
