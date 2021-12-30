package com.victor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //List that will contain the solution
        List<List<Integer>> result = new ArrayList();

        //If we have something to look
        if(root!=null){

            //Add the root to the solution
            result.add(Arrays.asList(root.val));

            //List that will hold the current Nodes to process
            List<TreeNode> currentTreeNodes = new ArrayList();

            //Prepare for the iterations
            if(root.left!=null) currentTreeNodes.add(root.left);
            if(root.right!=null) currentTreeNodes.add(root.right);

            //Current Level of the tree
            int level = 2;

            //While we have things to process
            while(!currentTreeNodes.isEmpty()){

                //By default, we will iterate the list from left to right
                int i = currentTreeNodes.size()-1;
                int end = -1;

                //List that will hold our solution
                List<Integer> currentSolution = new ArrayList();

                //List that will hold the nodes for our next iterations
                List<TreeNode> nextTreeNode = new ArrayList();

                //Iterate over the solution and prepare the next iterations

                while(i!=end){

                    //Get the current nodes, get the children and go to the next iterations
                    //in the list of current nodes
                    TreeNode current = currentTreeNodes.get(i);

                    if(level%2==0){
                        if(current.right!=null) nextTreeNode.add(current.right);
                        if(current.left!=null) nextTreeNode.add(current.left);
                    } else {
                        if(current.left!=null) nextTreeNode.add(current.left);
                        if(current.right!=null) nextTreeNode.add(current.right);
                    }

                    i--;

                    //Add to solution
                    currentSolution.add(current.val);

                }

                //Go to next level, add to solution and set the nodes for the next iteration

                level++;


                result.add(new ArrayList(currentSolution));

                currentTreeNodes = new ArrayList(nextTreeNode);

            }

        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrderStack(TreeNode root) {

        //List that will contain the solution
        List<List<Integer>> result = new ArrayList();

        //Stack for Odd levels
        Stack<TreeNode> odd = new Stack();

        //Stack for Even levels
        Stack<TreeNode> even = new Stack();

        //Add the root to start our processing
        if(root!=null) odd.push(root);

        int level = 1;

        //While we have things to process in either stack
        while(!odd.empty() || !even.empty()){

            //Current Iteration's solution
            List<Integer> currentSolution = new ArrayList();

            //Select the current stack
            Stack<TreeNode> current = !odd.empty() ? odd : even;

            //Keep popping until it is empty
            while(!current.empty()){

                //Get the current one and add the children depending on which level we
                //are on
                TreeNode currentNode = current.peek();

                if(level%2!=0){
                    //Add from left to right
                    if(currentNode.left!=null) {
                        even.push(currentNode.left);
                    }

                    if(currentNode.right!=null){
                        even.push(currentNode.right);
                    }
                } else {
                    //Add from right to left
                    if(currentNode.right!=null){
                        odd.push(currentNode.right);
                    }
                    if(currentNode.left!=null){
                        odd.push(currentNode.left);
                    }
                }

                //Add to solution and keep going
                currentSolution.add(currentNode.val);
                current.pop();

            }

            //Go to the next level
            level++;

            //Add to final solution
            result.add(new ArrayList(currentSolution));

        }


        return result;
    }

}
