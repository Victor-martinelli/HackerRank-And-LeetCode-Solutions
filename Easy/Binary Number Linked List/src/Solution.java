
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a singly linked list of 0s and 1s find its decimal equivalent.

   Input  : 0->0->0->1->1->0->0->1->0
   Output : 50   

   Input  : 1->0->0
   Output : 4
Decimal Value of an empty linked list is considered as 0.
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
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(0);
        
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        
        System.out.println("Binary Number: ");
        
        printList(n1);
        
        System.out.println("Decimal Number: "+binaryToDecimal(n1));
    }
    
    public static int binaryToDecimal(Node start)
    {
        
        Node current = start;
        
        //We first store the binary number into a list
        
        List<Integer> numbers = new ArrayList();
        
        //While we have not reached the end
        
        while(current!=null)
        {
            numbers.add(current.data);
            
            current=current.next;
            
        }
        
        //We now go through the list calculating the binary number
        
        int result=0;
        
        for(int i=0;i<numbers.size();i++)
        {
            if(numbers.get(i)==1)
                result+=Math.pow(2,numbers.size()-1-i);
        }
        
        return result;
    }
    
    public static void printList(Node current)
    {
        while(current!=null)
            System.out.print(current.data+" ");
        
        System.out.println();
    }
    
}
