package com.github.api.service;

import com.github.api.entities.Data;
import com.github.api.model.DataPersistence;
import com.github.api.model.DataUploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class that will serve as a controller class for the application
 */
@Service
public class DataService {

    /**
     * Service class that will handle all of our data operations
     */
    @Autowired
    DataPersistence dataPersistence;

    /**
     *  Method that will fetch data according to the provided repository and objectID. The method will follow these steps.
     *
     *  1. First check if the data exists, along with the repository and objectid
     *  2. If they do, then we fetch the data.
     *  3. If the don't, return empty Data Object.
     *
     * @param repository String containing the repository that stores the data that we want to fetch
     * @param objectId String containing the ID of the object that we want to fetch.
     * @return Object containing the desired fetched data
     */
    public Data getData(String repository,String objectId) {
        Data result = new Data();

        //Check if data exist
        if(doesDataExist(repository,objectId)){
            //Get the data and then prepare the result
            result = dataPersistence.getData(repository,objectId);

        }

        return result;
    }

    /**
     * Method that will store the provided data in the desired repository and will return the DataUploadResponse Object
     * to show to the client. The method will follow these steps:
     *
     *  1. First check if the provided repository is empty.
     *  2. If it is, return empty response.
     *  3. Otherwise, store the data in the desired repository and prepare the response to the client and return
     *
     * @param repository String containing the desired repository to store the data
     * @param data Byte array containing the data to store
     * @return DataUploadResponse containing the response to send to the client
     */
    public DataUploadResponse storeData(String repository,byte[] data) {

        DataUploadResponse result = new DataUploadResponse();

        //Check if repository exists and there's data to upload
        if(!repository.isEmpty() && data.length>0){
            //Get the data and then prepare the result
            Data temp = dataPersistence.storeData(repository,data);

            result = new DataUploadResponse(temp.getId(),data.length);

        }

        return result;
    }

    /**
     * Method that will delete the object with the desired ID in the desired repository and return a boolean indicating
     * if the operation was successful or not. The method follows these steps:
     *
     *  1. Check if the data exist.
     *  2. If it doesn't return false indicating that the data could not be deleted.
     *  3. If it is there, delete it and return a boolean indicating if the operation was successful.
     *
     * @param repository String containing the repository that has the object that we want to delete
     * @param objectId String containing the id of the object that we want to delete.
     * @return Boolan indicating if the delete operation was successful
     */
    public boolean deleteData(String repository,String objectId){

        boolean result = true;

        //Check if data exist
        if(doesDataExist(repository,objectId)){

            //Delete the data
            result = dataPersistence.deleteData(repository,objectId);

        } else {
            //Delete operation not successful
            result = false;
        }

        return result;
    }


    /**
     * Helper method that return a boolean indicating of the provided object ID is stored in the desired repository.
     * The method follows these steps:
     *
     *  1. First check if the provided repository and object id not empty and not null.
     *  2. If they are, return false.
     *  3. If they are not, check if the requested data exists and return the result.
     *
     * @param repository String containing the repository that contains the object that we want to perform operations on
     * @param objectId String containing the id the object that we want to perform operations on.
     * @return Boolean indicating if the request data exists
     */
    public boolean doesDataExist(String repository,String objectId) {
        boolean result;

        //Check if either is null or emty
        if(repository!=null && !repository.isEmpty() && objectId!=null && !objectId.isEmpty()){
            //Check if the data exists
            result = dataPersistence.doesDataExist(repository,objectId);

        } else {
            //Data cannot exist
            result = false;
        }

        return result;
    }

}
