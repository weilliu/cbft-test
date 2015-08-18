package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.cbft.client.java.CbftRestCall;
import com.cbft.client.java.util.TestProperties;

public class PartitionIndexTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    private String cbftNode = TestProperties.cbftNode();
    
    @Test
    public void shouldGetPartitionIndex(){
        String partitionIndex = "http://"+cbftNode+":8095/api/pindex";

        try {
            assertEquals(200,cbftRest.get_request(partitionIndex));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetPartitionBeerIndex(){
        String partitionBeerIndex = "http://"+cbftNode+":8095/api/pindex/beer-index_569ede7ac34061fb_185bbfd";

        try {
            assertEquals(200,cbftRest.get_request(partitionBeerIndex));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetPartitionBeerIndexCount(){
        String partitionBeerIndexCount = "http://"+cbftNode+":8095/api/pindex/beer-index_569ede7ac34061fb_185bbfd/count";

        try {
            assertEquals(200,cbftRest.get_request(partitionBeerIndexCount));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldQueryPartitionBeerIndex(){
        String partitionBeerIndexQuery = "http://"+cbftNode+":8095/api/pindex/beer-index_569ede7ac34061fb_185bbfd/query";
        String body = "{\"query\": {\"query\": \"beer\" , \"boost\" : 1}}";
        String contentType = "application/json";

        try {
            assertEquals(200,cbftRest.post_request(partitionBeerIndexQuery, body,contentType));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
