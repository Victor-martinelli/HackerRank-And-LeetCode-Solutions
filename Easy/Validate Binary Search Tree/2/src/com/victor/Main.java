package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isValidBST(TreeNode root) {
        return validateBST(root,null,null);
    }

    public boolean validateBST(TreeNode root, TreeNode min, TreeNode max){

        if(root!=null)
        {
            //Check if the condition for BST is not met
            if( (min!=null && root.val<=min.val) || (max!=null && root.val >=max.val)){
                return false;
            }
            //Keep looking into the tree
            return validateBST(root.left,min,root) && validateBST(root.right,root,max);
        } else{
            //Reached a leaf node
            return true;
        }
    }


}
