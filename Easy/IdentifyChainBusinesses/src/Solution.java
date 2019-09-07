
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        
        List<Business> lista1 = new ArrayList();
        
        lista1.add(new Business("Starbucks","Seattle","101"));
        lista1.add(new Business("Peets Coffee","San Francisco","102"));
        lista1.add(new Business("Whole Foods","Austin","103"));
        lista1.add(new Business("Starbucks","San Francisco","104"));
        lista1.add(new Business("Peets Coffee","Austin","105"));
        lista1.add(new Business("Starbucks","Austin","106"));
        lista1.add(new Business("Whole Foods","Austin","103"));
        lista1.add(new Business("Whole Foods","Austin","107"));
        
        System.out.println("New Solution");
        printList(detectAndOrderChainBusiness(lista1,"Austin"));
        
        System.out.println("Original Solution");
        printList(detectAndOrderChainBusinessOriginal(lista1,"Austin"));
        
        
        List<Business> lista2 = new ArrayList();
        
        lista2.add(new Business("Starbucks","Seattle","101"));
        lista2.add(new Business("Peets Coffee","Seattle","102"));
        lista2.add(new Business("Whole Foods","San Francisco","103"));
        lista2.add(new Business("Whole Foods","San Francisco","110"));
        lista2.add(new Business("Peets Coffee","San Francisco","104"));
        lista2.add(new Business("Peets Coffee","San Francisco","105"));
        lista2.add(new Business("Starbucks","San Francisco","106"));
        lista2.add(new Business("Whole Foods","San Francisco","103"));
        lista2.add(new Business("Whole Foods","San Francisco","107"));
        
        System.out.println("New Solution");
        printList(detectAndOrderChainBusiness(lista2,"San Francisco"));
        
        System.out.println("Original Solution");
        printList(detectAndOrderChainBusinessOriginal(lista2,"San Francisco"));
    }
    
    
    public static List<Chain> detectAndOrderChainBusiness(List<Business> businesses, String location)
    {
        
        List<Chain> result = new ArrayList();
        
        List<Business> visitedStores = new ArrayList();
        
        List<String> selectedIds = new ArrayList();
        
        for(Business candidate : businesses)
        {
            if(candidate.getLocation().equals(location) && !selectedIds.contains(candidate.getId()))
            {
                visitedStores.add(candidate);
                selectedIds.add(candidate.getId());
            }
        }
        
        
        
        for(int i=0;i<visitedStores.size();i++)
        {
            int frequency = 1;
            
            Business current = visitedStores.get(i);
            
            for(int j=0;j<visitedStores.size();j++)
            {
                if(i!=j && visitedStores.get(j).getName().equals(current.getName()))
                {
                    frequency++;
                    visitedStores.remove(j);
                    j--;
                }
            }
            
            result.add(new Chain(current.getName(),frequency));
            
        }
        
        Collections.sort(result, (a,b) -> Integer.compare(b.getFrequency(), a.getFrequency()));
        
        
        return result;
    }
            
    
    
    public static void printList(List<Chain> list)
    {
        for(Chain current : list)
        {
            System.out.println(current.getName()+" - "+current.getFrequency());
        }
        
        System.out.println();
    }
    

    
      public static List<Chain> detectAndOrderChainBusinessOriginal(List<Business> businesses, String location) {
    
      List<Chain> result = new ArrayList();

      List<String> selectedIds = new ArrayList();

      List<Business> visitedStores = new ArrayList();

      for(int i=0;i<businesses.size();i++)
      {

         if(businesses.get(i).location.equals(location) && !selectedIds.contains(businesses.get(i).id))
         {
            visitedStores.add(businesses.get(i));
            selectedIds.add(businesses.get(i).id);
         }

      }

      if(visitedStores.size()>0)
      {
        for(int i=0;i<visitedStores.size();i++)
        {
            int frequency=1;

            for(int j=0;j<visitedStores.size();j++)
            {
                if(visitedStores.get(i).name.equals(visitedStores.get(j).name)) //i!=j
                {
                    frequency++;
                    selectedIds.add(visitedStores.get(j).id);
                    visitedStores.remove(j);
                    //j--
                }
            }

            result.add(new Chain(visitedStores.get(i).name,frequency));
        }
      }



      return result;
  }          

    
}
