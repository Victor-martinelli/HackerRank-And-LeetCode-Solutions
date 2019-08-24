/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class Node{
    
    public int data;
    public int min;
    public Node next;
    
    public Node(int x)
    {
        data=x;
        min=x;
        next=null;
    }
    
}
