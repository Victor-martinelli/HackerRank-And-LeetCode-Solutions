package com.victor;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    //Index of where we currently are in building the tree
    private int preOrderIndex;

    //Build an index of all the nodes in the tree in Inorder
    private HashMap<Integer,Integer> inOrderIndex = new HashMap();

    /**
     * Time Complexity O(n)
     *
     * Space Complexity O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preOrderIndex = 0;

        for(int i = 0;i<inorder.length;i++){
            inOrderIndex.put(inorder[i],i);
        }

        //Build the rest of the tree
        return buildTreeRecursive(preorder,0,preorder.length-1);
    }

    public TreeNode buildTreeRecursive(int[] preorder, int start, int end){

        TreeNode result = null;

        //If we have already built the rest of the tree
        if(start<=end){

            //Create the current Node
            result = new TreeNode(preorder[preOrderIndex]);
            preOrderIndex++;

            //Create the rest of the children by updating the range according to where the indices are
            //Since all the numbers to the left will be part of the left children and to the right
            //Will be the right children

            //We exclude the current node because it is the root
            result.left = buildTreeRecursive(preorder,start,inOrderIndex.get(result.val)-1);
            result.right = buildTreeRecursive(preorder,inOrderIndex.get(result.val)+1,end);

        }
        return result;
    }

}
