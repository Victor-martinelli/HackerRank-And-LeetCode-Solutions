package com.victor;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    //HashSet implementation. Our buckets will be a ArrayList and
    //The LinkedList will be another ArrayList so it will simply be
    //A double List
    private List<List<Integer>> hashSet;

    //This will be the size of the HashSet that we will use in order
    //for the hashing function
    private int HASH_SET_SIZE = 100;


    public MyHashSet() {
        //Simply initialize the list
        hashSet = new ArrayList<>(HASH_SET_SIZE);

        //Set the entire Bucket
        for(int i = 0;i<HASH_SET_SIZE;i++){
            hashSet.add(null);
        }
    }

    public void add(int key) {

        //Get the index of the key
        int index = getIndex(key);

        //If this is the first key with this index
        if(hashSet.get(index)==null){
            //Simply initialize
            List<Integer> linkedList = new ArrayList<>();

            //Add it and set it again
            linkedList.add(key);

            hashSet.set(index,linkedList);

        } else {
            //Check if the value is there, if it isn't then we add ut

            List<Integer> linkedList = hashSet.get(index);

            if(!linkedList.contains(key)){
                linkedList.add(key);
            }

        }

    }

    public void remove(int key) {
        //Get the index of the key
        int index = getIndex(key);

        //Try to remove it, if it isnt there it wont delete it

        List<Integer> linkedList = hashSet.get(index);

        if(linkedList!=null){
            linkedList.remove(Integer.valueOf(key));
        }

    }

    public boolean contains(int key) {
        //Get the index of the key
        int index = getIndex(key);

        //Get the bucket that it belongs to and simply do a check to see if it's null
        //and if it's there

        List<Integer> linkedList = hashSet.get(index);

        return linkedList != null && linkedList.contains(key);
    }

    private int getIndex(int key){

        //Simple formula in order to 'evenly' distribute the keys
        return key % HASH_SET_SIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
