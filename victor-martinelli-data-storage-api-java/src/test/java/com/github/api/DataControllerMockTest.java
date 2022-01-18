package com.github.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataController.class)
public class DataControllerMockTest {

    /**
     * Attribute that will help us make HTTP request to the client
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test Method that will first create a few object and then fetch them to make sure that the upload process
     * was successful
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void createAndGetObjects() throws Exception {
        MvcResult testResult = this.mockMvc.perform(put("/data/myRepo").content(new String("testContent".getBytes(), StandardCharsets.UTF_8))).andDo(print()).andExpect(status().isCreated()).andReturn();
        assertEquals(MediaType.APPLICATION_JSON.toString(), testResult.getResponse().getContentType());
        MvcResult helloResult = this.mockMvc.perform(put("/data/myRepo").content(new String("helloWorld".getBytes(), StandardCharsets.UTF_8))).andDo(print()).andExpect(status().isCreated()).andReturn();
        assertEquals(MediaType.APPLICATION_JSON.toString(), helloResult.getResponse().getContentType());
        JsonNode testResponse = getResponseJson(testResult);
        JsonNode helloResponse = getResponseJson(helloResult);

        assertNotEquals(helloResponse.get("oid").asText(), testResponse.get("oid").asText());
        assertEquals("testContent".length(), testResponse.get("size").asLong());
        assertEquals("helloWorld".length(), helloResponse.get("size").asLong());

        MvcResult testGetResult = this.mockMvc.perform(get("/data/myRepo/" + testResponse.get("oid").asText())).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("testContent", getResponseText(testGetResult));

        MvcResult helloGetResult = this.mockMvc.perform(get("/data/myRepo/" + helloResponse.get("oid").asText())).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM)).andReturn();
        assertEquals("helloWorld", getResponseText(helloGetResult));
    }

    /**
     * Test method that will test the response of the API when a repository is not specified
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void createObjectWithEmptyRepository() throws Exception {
        MvcResult testResult = this.mockMvc.perform(put("/data").content(new String("testContent".getBytes(), StandardCharsets.UTF_8))).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals(null, testResult.getResponse().getContentType());

    }

    /**
     * Test class that will test the functionality of trying to delete an object without specifying a repository
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void deleteObjectWithEmptyRepository() throws Exception {
        MvcResult myDeleteResult = this.mockMvc.perform(delete("/data")).andExpect(status().isNotFound()).andReturn();
        assertTrue(getResponseText(myDeleteResult).isEmpty());

    }

    /**
     * Test class that will test the functionality of trying to delete an object without specifying an ID
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void deleteObjectWithEmptyId() throws Exception {
        MvcResult myDeleteResult = this.mockMvc.perform(delete("/data/myRepo")).andExpect(status().isMethodNotAllowed()).andReturn();
        assertTrue(getResponseText(myDeleteResult).isEmpty());

    }

    /**
     * Test class that will test the functionality of trying to fetch an object without specifying a repository
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void getObjectWithEmptyRepository() throws Exception {
        MvcResult testGetResult = this.mockMvc.perform(get("/data")).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertTrue(getResponseText(testGetResult).isEmpty());

    }

    /**
     * Test class that will test the functionality of trying to fetch an object without specifying an if
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void getObjectWithEmptyId() throws Exception {
        MvcResult testGetResult = this.mockMvc.perform(get("/data/myRepo")).andDo(print()).andExpect(status().isMethodNotAllowed()).andReturn();
        assertTrue(getResponseText(testGetResult).isEmpty());
    }

    /**
     * Test class that will test the functionality of trying to upload an object with empty data
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void createObjectWithEmptyData() throws Exception {
        MvcResult testResult = this.mockMvc.perform(put("/data/myRepo").content(new String("".getBytes(), StandardCharsets.UTF_8))).andDo(print()).andExpect(status().isBadRequest()).andReturn();
        assertEquals(null, testResult.getResponse().getContentType());

    }

    /**
     * Test method that will test the functionality of trying to fetch an object that is not found
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void getObjectThatDoesntExist() throws Exception {
        MvcResult testGetResult = this.mockMvc.perform(get("/data/myRepo/test")).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertTrue(getResponseText(testGetResult).isEmpty());
    }


    /**
     * Test method that will test the functionality of trying to upload some objects and then deleting them
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void deleteObjects() throws Exception {
        MvcResult myResult = this.mockMvc.perform(put("/data/myRepo").content(new String("helloWorld".getBytes(), StandardCharsets.UTF_8))).andDo(print()).andExpect(status().isCreated()).andReturn();
        MvcResult yourResult = this.mockMvc.perform(put("/data/yourRepo").content(new String("helloWorld".getBytes(), StandardCharsets.UTF_8))).andDo(print()).andExpect(status().isCreated()).andReturn();
        JsonNode myResponse = getResponseJson(myResult);
        JsonNode yourResponse = getResponseJson(yourResult);

        MvcResult myDeleteResult = this.mockMvc.perform(delete("/data/myRepo/" + myResponse.get("oid").asText())).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(getResponseText(myDeleteResult).isEmpty());

        this.mockMvc.perform(delete("/data/myRepo/" + myResponse.get("oid").asText())).andDo(print()).andExpect(status().isNotFound());

        MvcResult yourDeleteResult = this.mockMvc.perform(delete("/data/yourRepo/" + yourResponse.get("oid").asText())).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(getResponseText(yourDeleteResult).isEmpty());
    }

    /**
     * Test method that will test the functionality of trying to delete an object that hasn't been uploaded before
     * @throws Exception Exception that might be thrown if some of the asserts do not pass
     */
    @Test
    public void deleteObjectsThatDoesntExist() throws Exception {
        MvcResult myDeleteResult = this.mockMvc.perform(delete("/data/myRepo/test")).andExpect(status().isNotFound()).andReturn();
        assertTrue(getResponseText(myDeleteResult).isEmpty());
    }

    /**
     * Helper method used in order to get the response String from a response from the server
     * @param result Result Object from the server that contains the parameter that we want
     * @return String containing the body of our desired response
     * @throws Exception Exception that might be thrown of the parameter could not be found
     */
    private String getResponseText(MvcResult result) throws Exception {
        return result.getResponse().getContentAsString(StandardCharsets.UTF_8);
    }

    /**
     * Helper method used in order to get the response JsonNode from a response from the server
     * @param result Result Object from the server that contains the parameter that we want
     * @return JsonNode containing the body of our desired response
     * @throws Exception Exception that might be thrown of the parameter could not be found
     */
    private JsonNode getResponseJson(MvcResult result) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
