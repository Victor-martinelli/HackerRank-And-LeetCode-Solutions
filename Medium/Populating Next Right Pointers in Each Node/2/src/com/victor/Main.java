package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public Node connectRecursive(Node root) {

        //Connect the first two and then continue
        if(root!=null && root.left!=null){

            root.left.next = root.right;

            root.left = connectNodes(root.left,root.right);
            root.right = connectNodes(root.right,null);

        }

        return root;
    }


    //Recursive solution
    public Node connectNodes(Node current, Node otherChild){
        //We first connect the direct children if they exist
        if(current.left!=null){

            current.left.next = current.right;

            //If we have a child from the right branch
            if(otherChild!=null){
                // Connect their left child with our right child
                current.right.next = otherChild.left;

            }

            //Keep connecting
            current.left = connectNodes(current.left,current.right);
            current.right = connectNodes(current.right,otherChild!=null ? otherChild.left : null);

        }
        //We don't do anything otherwise because they would have connected us above
        return current;
    }

    public Node connectIteratively(Node root) {

        //Keep a pointer to the root
        Node current = root;

        //While we have things to process
        while(current!=null && current.left!=null){
            //Join all of the ones in this level
            connectThisLevel(current);
            //Keep going down
            current = current.left;
        }

        return root;
    }

    public void connectThisLevel(Node current){

        Node currentLevel = current;

        //While we still have nodes to process in this level
        while(currentLevel!=null){
            //Connect the children
            currentLevel.left.next = currentLevel.right;

            //If we have another node in this level
            if(currentLevel.next!=null){
                //Connect the children from the other branch
                currentLevel.right.next = currentLevel.next.left;
            }

            //Keep going
            currentLevel = currentLevel.next;
        }

    }
}
