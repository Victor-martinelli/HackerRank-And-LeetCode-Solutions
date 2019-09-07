
import java.util.ArrayList;
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
        Message m1 = new Message(1,42,1);
        Message m2 = new Message(42,1,1);
        Message m3 = new Message(2,42,2);
        Message m4 = new Message(2,42,2);
        Message m5 = new Message(3,88,3);
        Message m6 = new Message(3,42,4);
        
        
        List<Message> allMessages = new ArrayList();
        
        allMessages.add(m1);
        allMessages.add(m2);
        allMessages.add(m3);
        allMessages.add(m4);
        allMessages.add(m5);
        allMessages.add(m6);
        
        System.out.println(businessResponsivenessRate(42,allMessages));
        
    }
    
    public static int businessResponsivenessRate(int ownerId, List<Message> allMessages)
    {
        List<Integer> involvedMessages = new ArrayList();
        
        //This needs to be a double so that we keep the numbers after the coma when we return the result
        double responded=0;
        
        for(int i=0;i<allMessages.size();i++)
        {
            Message current = allMessages.get(i);
            
            //If the current Message was to the owner and it wasn't counted before
            if(current.getRecipient()==ownerId && !involvedMessages.contains(current.getConversationId()))
            {
                
                //We add it to the list of involved messages and we look for the answer
                involvedMessages.add(current.getConversationId());
                
                int j=i+1;
                boolean found =false;
                
                while(j<allMessages.size() && allMessages.get(j).getConversationId()==current.getConversationId() && !found)
                {
                    
                    //If we found the reply
                    
                    if(allMessages.get(j).getSender()==ownerId)
                    {
                        found=true;
                        responded++;
                    }
                    j++;
                }
                
                
            }
            
        }
        
        return (int) Math.floor( (responded/involvedMessages.size()) * 100);
        
    }
    
    
}
