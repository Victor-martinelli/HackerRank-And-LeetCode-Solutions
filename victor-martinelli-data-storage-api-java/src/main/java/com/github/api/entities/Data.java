package com.github.api.entities;

/**
 * Entity class that will store the required data for the application
 */
public class Data {

    /**
     * Attribute that indicates the ID of this Data object
     */
    private String id;

    /**
     * Attribute containing the actual data of the object
     */
    private byte[] data;

    /**
     * Empty constructor that will initialize the attributes to dummy values
     */
    public Data() {
        id = "";
        data = new byte[0];
    }

    /**
     * Main constructor that will initalize the attributes to their provided values
     * @param id String indicating the ID of the Data object
     * @param data Byte array indicating the actual data that the object will store
     */
    public Data(String id, byte[] data) {
        this.id = id;
        this.data = data;
    }

    /**
     * Simple getter for ID
     * @return String containing the ID for this object
     */
    public String getId() {
        return id;
    }

    /**
     * Simple getter for the data of this object
     * @return Byte Array containing the data for this object
     */
    public byte[] getData() {
        return data;
    }
}
