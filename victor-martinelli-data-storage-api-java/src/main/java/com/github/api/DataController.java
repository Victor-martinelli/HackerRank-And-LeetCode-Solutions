package com.github.api;

import com.github.api.entities.Data;
import com.github.api.model.DataUploadResponse;
import com.github.api.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Controller class that will handle the incoming requests for the application
 */
@RestController
@RequestMapping("/data")
public class DataController {

    /**
     * Service class that will handle all the data related operations for us
     */
    @Autowired
    DataService dataService;

    /**
     * Method that will get an object for the client. The method follows these steps.
     *
     *  1. First check if the data exists.
     *  2. If it doesn't, return a not found.
     *  3. Otherwise, get the data and return it to the client.
     *
     * @param repository String containing the repository that has stored our desired data
     * @param objectID String containing the id of the object that we wish to get
     * @return Object containing our response to the client, which contains the requested data
     */
    @GetMapping(value = "/{repository}/{objectID}")
    public Object getObject(@PathVariable("repository") String repository, @PathVariable("objectID") String objectID) {

        //Check if the data is even there
        boolean foundData = dataService.doesDataExist(repository, objectID);

        //If the data is not stored
        if (foundData) {
            //Get the data and return the appropriate response
            Data result = dataService.getData(repository,objectID);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(result.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method that will upload the requested data into the desired repository. In order to do this, the method follows these steps:
     *
     *  1. Store the data in the backend and get the result.
     *  2. Return the result to the client
     *
     * @param repository String containing the repository where we wish to store the data
     * @param data Byte array containing the data that we wish to upload
     * @param builder Builder used in order to construct the response to the client to indicate where we have stored the object
     * @return Upload response to the client
     */
    @PutMapping(value = "/{repository}", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public Object uploadObject(@PathVariable("repository") String repository, @RequestBody byte[] data, UriComponentsBuilder builder) {
        //Store the data directly and return the result
        DataUploadResponse result = dataService.storeData(repository, data);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/" + repository + "/{id}").buildAndExpand(result.getOid()).toUri());
        //Check if the data was correctly uploaded
        if(!result.getOid().isEmpty()){
            return new ResponseEntity<>(result, headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, headers, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    /**
     * Method that will delete the desired object in the specified repository. The method will follow these steps:
     *
     *  1. Directly make a call to the backend in order to delete the object. We will store the response from the backend.
     *  2. If it was able to delete it, return an OK to the client.
     *  3. If it was not able to delete it, return NOT_FOUND to the client.
     * @param repository String containing the name of the repository of the object that we wish to delete
     * @param objectID String containing the ID of the object that we wish to delete.
     * @return Response code to the client indicating of the object was deleted or not
     */
    @DeleteMapping(value = "/{repository}/{objectID}")
    public Object deleteObject(@PathVariable("repository") String repository, @PathVariable("objectID") String objectID) {

        //Directly make the call, it will return a boolean indicating if it deleted
        //the object or not and return it to the client
        boolean couldDeleteObject = dataService.deleteData(repository,objectID);

        if (couldDeleteObject) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
