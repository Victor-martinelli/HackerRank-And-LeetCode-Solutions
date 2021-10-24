package com.victor;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums,0,nums.length-1);
    }

    public TreeNode convertToBST(int[] nums, int i, int j){

        //System.out.println("Value of i: "+i+" - Value of j: "+j);

        TreeNode root = null;

        //If we have reached a leaf node

        if(i<j){

            root = new TreeNode();
            //Get the root node
            int middle = Math.round(i + j)/2;

            //System.out.println("Index Middle is "+middle+" - Middle value is "+ nums[middle]);

            root.val = nums[middle];

            //Get the children
            root.left = convertToBST(nums,i,middle-1);
            root.right = convertToBST(nums,middle+1,j);
        } else if(i==j){

            //System.out.println("Setting this leaf node to "+nums[i]);

            root = new TreeNode();
            //Just set the current as a leaf node
            root.val = nums[i];
        }

        return root;
    }

    public TreeNode convertToBSTAnother(int[] nums, int i, int j){

        TreeNode root = null;

        //If we have not reached a leaf node
        if(j>=i){
            root = new TreeNode();

            //Get the root node
            int middle = (i + j) /2;

            root.val = nums[middle];

            //Get the children
            root.left = convertToBST(nums,i,middle-1);
            root.right = convertToBST(nums,middle+1,j);
        }

        return root;
    }
}
