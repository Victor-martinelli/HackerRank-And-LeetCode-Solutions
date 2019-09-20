
import java.util.Stack;

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
        String commands1 = "1N2W";
        
        Stack<String> processedCommands1 = processCommands(commands1);
        
        printStack((Stack<String>) processedCommands1.clone());
        
        moveRobot(processedCommands1);
        
        String commands2 = "1N3W2X";
        
        Stack<String> processedCommands2 = processCommands(commands2);
        
        printStack((Stack<String>) processedCommands2.clone());
        
        moveRobot(processedCommands2);
        
        String commands3 = "1N3W1X";
        
        Stack<String> processedCommands3 = processCommands(commands3);
        
        printStack((Stack<String>) processedCommands3.clone());
        
        moveRobot(processedCommands3);
        
        String commands4 = "1N3W1Q";
        
        Stack<String> processedCommands4 = processCommands(commands4);
        
        printStack((Stack<String>) processedCommands4.clone());
        
    }
    
    public static void moveRobot(Stack<String> stack)
    {
        
        int x=0;
        
        int y=0;
        
        while(!stack.empty())
        {
            
            String command = stack.pop();
            
            int number = command.charAt(0) - '0';
            
            char direction = command.charAt(1);
            
            switch(direction)
            {
                case 'N':
                {
                    y+=number;
                    break;
                }
                case 'S':
                {
                    y-=number;
                    break;
                }
                case 'E':
                {
                    x+=number;
                    break;
                }
                case 'W':
                {
                    x-=number;
                    break;
                }
            }
            
        }
        
        
        System.out.println("The final position of the robot is ("+x+","+y+")");
    }
    
    
    public static Stack<String> processCommands(String commands)
    {
        Stack<String> result = new Stack();
        
        int i=0;
        
        boolean finished=false;
        
        while(i+1<commands.length() && !finished)
        {
            
            char number = commands.charAt(i);
            
            //If the first char is a number
            if(Character.isDigit(number))
            {
                i++;
                char direction = commands.charAt(i);
                
                //If its one of the possible directions
                if(direction=='N' || direction=='W' || direction=='S' || direction=='E')
                {
                    result.add(number+""+direction);
                    commands = commands.substring(i+1);
                    i=0;
                    
                }
                else if(direction=='X') //If its an X, then we pop elements until the number says so or until there are no more elements
                {
                    
                    int count = (int)number - '0';
                    
                    while(!result.empty() && count>0)
                    {
                        result.pop();
                        count--;
                    }
                    
                    //If there are still elements to remove but there arent any
                    
                    if(count!=0)
                        finished=true;
                    else //Finished correctly
                    {
                        commands = commands.substring(i+1);
                        i=0;
                    }
                        
                    
                }
                else
                    finished=true;
                
                
            }
            else
                finished=true;
            
        }
        
        
        if(finished)
            result=new Stack();
        
        return result;
    }
    
    public static void printStack(Stack<String> stack)
    {
        
        while(!stack.empty())
        {
            System.out.println(stack.pop());
        }
        
        System.out.println("");
    }
    
    
    
}
