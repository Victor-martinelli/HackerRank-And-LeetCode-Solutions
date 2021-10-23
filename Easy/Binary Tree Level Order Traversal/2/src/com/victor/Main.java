package com.victor;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();

        //If we are not null

        if(root!=null) {

            //System.out.println("Root is not null, Root is "+root.val);

            //Add ourselves
            result.add(Arrays.asList(new Integer[]{root.val}));

            //Go through left and right to get the rest of the results

            List<List<Integer>> left = levelOrder(root.left);

            //System.out.println("Left "+left+" Root "+root.val);

            List<List<Integer>> right = levelOrder(root.right);

            //System.out.println("Right "+right+" Root "+root.val);

            //Merge the results
            int i = 0;

            while(i<left.size() || i<right.size()){

                //Put both of the results in a List and add it to the result
                List<List<Integer>> temp = new ArrayList();


                List<Integer> preLeft = new ArrayList();
                List<Integer> preRight = new ArrayList();

                if(i<left.size()){

                    preLeft.addAll(left.get(i));

                }

                if(i<right.size()){
                    preRight.addAll(right.get(i));
                }

                //Joined List

                List<Integer> temp2 = new ArrayList();

                temp2.addAll(preLeft);
                temp2.addAll(preRight);

                //Add both results to temp and to the result

                temp.add(temp2);

                //System.out.println("Preleft: "+preLeft+" root "+root.val);
                //System.out.println("Preright: "+preRight+" root "+root.val);

                result.addAll(temp);
                i++;
            }
            //System.out.println("Result with root "+root.val+" - "+result);
        }

        return result;
    }

    public List<List<Integer>> levelOrderAnother(TreeNode root) {

        List<List<Integer>> result = new ArrayList();

        if(root!=null){
            //Queue where we will store the nodes that we are going to currently process
            Queue<TreeNode> queue = new LinkedList();

            //Add the current node to process and begin all of the processing

            queue.add(root);

            //Process while the queue is not empty
            while(!queue.isEmpty()){

                //Current size of the Queue
                int currentSize = queue.size();

                //Nodes in this level
                List<Integer> currentLevel = new ArrayList();

                for(int i=0; i<currentSize;i++){

                    //Take out the node
                    TreeNode current = queue.remove();

                    //Add the children to the queue if they are not empty

                    if(current.left!=null){
                        queue.add(current.left);
                    }

                    if(current.right!=null){
                        queue.add(current.right);
                    }

                    //Add the current node to the solution
                    currentLevel.add(current.val);

                }

                //Finished processing this level, add it to the solution
                result.add(currentLevel);

            }

        }

        return result;
    }

}
