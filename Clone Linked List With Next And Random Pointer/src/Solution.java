/*
 * A linked list is given such that each node contains an additional random 
pointer which could point to any node in the list or null.

Return a deep copy of the list.

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":
{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */

/**
 *
 * @author victormartinelli
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        
        n1.next = n2;
        n2.next=n3;
        n3.next=n4;
        
        n1.randomIndex=n4;
        n2.randomIndex=n1;
        n3.randomIndex=n2;
        n4.randomIndex=n3;
        
        System.out.println("Original List: ");
        
        printLinkedList(n1);
        
        ListNode copy = deepCopy(n1);
        
        System.out.println("Original List After Deep Copy: ");
        
        printLinkedList(n1);
        
        System.out.println("Copied List: ");
        
        printLinkedList(copy);
        
    }
    
    
    public static ListNode deepCopy(ListNode original)
    {
        //We first create a new linked List without the random index
        
        if(original!=null)
        {
            /*
            
            Current --> Original List
            
            Copy --> New Linked List
            
            */
            
            
            
            ListNode copy = new ListNode(original.val);

            ListNode current = original.next;

            ListNode copyCurrent = copy;

            while(current!=null)
            {
                
                ListNode next = new ListNode(current.val);
                
                copyCurrent.next=next;
                
                current=current.next;

                copyCurrent = copyCurrent.next;
            }

            
            //Now we set the next of each original node point to the copy
            //and then we set the index of each copy to the original node

            current = original;

            ListNode currentNext = original.next;
            
            copyCurrent = copy;
            
            
            while(current!=null)
            {
                
                copyCurrent.randomIndex = current;
                
                current.next = copyCurrent;
                
                current = currentNext;
                
                if(current!=null)
                    currentNext = current.next;
                
                copyCurrent = copyCurrent.next;
                
            }
            
            
            //Now we simply update the random index of copy node and then
            //Restore the original order of the original list

            current = original;
            
            copyCurrent = copy;
            
            currentNext = null;

            
            while(current!=null)
            {
                
                //Reference to restore the original Linked List
                if(copyCurrent.next!=null)
                    currentNext = copyCurrent.next.randomIndex;
                else
                    currentNext=null;
                
                //We set the new random Index
                copyCurrent.randomIndex = copyCurrent.randomIndex.randomIndex.next;
                
                
                //We restore the original List
                current.next = currentNext;
                
                
                current = current.next;
                
                copyCurrent = copyCurrent.next;
                
            }
            
            return copy;
        
        }
        else
            return null;
        
    }
    
    
    public static void printLinkedList(ListNode head)
    {
        
        while(head!=null)
        {
            System.out.print("Node value: "+head.val + " Index: "+head.randomIndex.val+" Address: "+head.toString()+" ");
            
            head = head.next;
        }
        System.out.println();
    }
    
}
