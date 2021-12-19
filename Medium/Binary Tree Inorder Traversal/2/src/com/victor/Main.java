package com.victor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return processNodeInOrderRecursive(root);
    }

    /**
     * Time Complexity O(n)
     * Space Complexity O(n)
     * @param currentNode
     * @return
     */
    public List<Integer> processNodeInOrderRecursive(TreeNode currentNode){
        List<Integer> currentSolution = new ArrayList();

        //If we have something to process

        if(currentNode!=null){

            //Explore both children and make the inOrder traversal at the same time
            if(currentNode.left!=null) currentSolution.addAll(processNodeInOrderRecursive(currentNode.left));

            currentSolution.add(currentNode.val);

            if(currentNode.right!=null) currentSolution.addAll(processNodeInOrderRecursive(currentNode.right));

        }

        //Return solution
        return currentSolution;
    }

    /** Iterative
     * Time Complexity O(n)
     * Space Complexity O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList();

        //This will help us iterate through the Tree iteratively
        Stack<TreeNode> stack = new Stack();

        TreeNode current = root;

        //While there is still elements in the stack
        while(!stack.empty() || current!=null){
            //While we haven't reached the end of the left line
            while(current!=null){
                //Add it to the stack and keep going
                stack.push(current);
                current = current.left;
            }
            //Pop it out, add it to the solution and continue right
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }


        return result;
    }

}
