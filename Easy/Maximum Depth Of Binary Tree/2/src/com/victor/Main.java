package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TreeNode root = new TreeNode();

        int result = findMaxDepth(root,0);
    }


    public static int findMaxDepth(TreeNode current, int currentDepth){

        int result = currentDepth;

        //If the node is not null, count it towards the depth
        if(current!=null){

            result++;

            //Go down the other children and see the results
            int leftDepth = findMaxDepth(current.left,result);
            int rightDepth = findMaxDepth(current.right,result);

            //Compare the heights of the children
            if(leftDepth>rightDepth){
                result = leftDepth;
            } else {
                result = rightDepth;
            }

        }

        return result;
    }
}
