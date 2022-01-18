package com.github.api.model;

import com.github.api.entities.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Class that will handle the persistence of data
 */
@Service
public class DataPersistence {

    /**
     * HashMap that will store all the data, the structure will be the following
     *
     * <repositoryName,repositoryData>
     *            |
     *            |
     *            --------------> <objectID,actualData>
     *
     */
    private HashMap<String,HashMap<String, Data>> storage;

    /**
     * Simple ID counter that will increment every time we insert an object
     */
    private int idCounter;

    /**
     * Simple object constructor. It will initialize the HashMap and start the id counter to 0
     */
    public DataPersistence() {
        storage = new HashMap<>();
        idCounter = 0;
    }

    /**
     * Method that will get the requested data according to the repo and id provided. The method will work the following way:
     *
     *  1. Check if the data exists.
     *  2. If it does exist, it will fetch it and return it.
     *  3. If it doesn't exist, it will return null.
     *
     * @param repository String containing the name of the repository which has the data stored
     * @param id String containing the id of the object we want to fetch
     * @return The Data Object containing the requested data
     */
    public Data getData(String repository,String id) {

        Data result = null;

        //Check if the repository is there
        if(doesDataExist(repository,id)){
            //Fetch the data
            result = storage.get(repository).get(id);
        }

        return result;
    }

    /**
     * Method that will store the requested data according to the repo provided and return it. The method follows these steps:
     *
     *  1. It will first check if desired repo to store the data is already there.
     *  2. If it isn't, it will initialize it and fetch it.
     *  3. if it is, it will simply fetch it.
     *  4. Once we have the repo, we will get the new ID for this new object and store it.
     *  5. Once this is done, we will return it upstream
     *
     * @param repository String containing the name of the repository where we will store the desired data
     * @param data Byte array containing the data that we will be storing
     * @return Data object containing the id given and the data that we have stored
     */
    public Data storeData(String repository,byte[] data){
        Data result = null;

            //Check if the repository exists
            if(!storage.containsKey(repository)){
                //Create it if it doesn't
                storage.put(repository,new HashMap<>());
            }

            //Create the counter for the new object
            String id = String.valueOf(idCounter++);

            //Create the Object that will store the data
            result = new Data(id,data);

            //Get the repository and store
            storage.get(repository).put(id,result);

        return result;
    }

    /**
     * Method that will delete the desired data according to the repository and id's provided. The method will follow these steps
     *
     *  1. It will first check if the object is even there.
     *  2. If it is, it will delete the object
     *  3. If it isn't, it won't delete the object
     * @param repository String containing the name of the repository that is storing the object we want to delete
     * @param id String containing the id of the object that we want to delete
     * @return Boolean indicating if the object was deleted
     */
    public boolean deleteData(String repository,String id){

        //Check if the object is even there
        boolean result = doesDataExist(repository,id);

        if(result){
            //Delete the object
            storage.get(repository).remove(id);
        }

        return result;
    }

    /**
     * Helper method that will check if an object exists according to a given repository and object ID. The method follows these
     * steps:
     *
     *  1. It will first check if the desired repository exists.
     *  2. If it doesn't, it will return false.
     *  3. If it does, we will check if the desired object exists.
     *  4. If it doesn't we return false.
     *  5. If it does, we return true
     *
     * @param repository String containing the name of the repository that we want to check
     * @param id String containing the id of the object we want to check
     * @return Boolean indicating if the repository as well as the object exists
     */
    public boolean doesDataExist(String repository,String id){
        boolean result = true;

        //Check if the repository is there
        HashMap<String,Data> repositoryData = storage.get(repository);

        if(repositoryData!=null){

            //Try to get the data with that id
            Data temp = repositoryData.get(id);

            if(temp==null){
                //Object doesn't exist
                result = false;
            }

        } else {
            //Repository doesn't exist
            result = false;
        }

        return result;
    }
}
