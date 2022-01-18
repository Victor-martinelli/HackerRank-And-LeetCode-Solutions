package com.github.api.model;

/**
 * Class that indicates the response that will be sent to the client after uploading data
 */
public class DataUploadResponse {

    /**
     * Attribute indicating the ID of the data
     */
    private String oid;

    /**
     * Attribute indicating the size of the data that the object is storing
     */
    private int size;

    /**
     * Empty constructor that will initialize the attributes to dummy values
     */
    public DataUploadResponse() {
        oid = "";
        size = 0;
    }
    /**
     * Main constructor that will initalize the attributes to their provided values
     * @param oid String indicating the ID of the Data object
     * @param size int indicating the size of the data that the object will be storing
     */
    public DataUploadResponse(String oid, int size) {
        this.oid = oid;
        this.size = size;
    }

    /**
     * Simple getter that will return the id of the object
     * @return String containing the ID of the object
     */
    public String getOid() {
        return oid;
    }
}
