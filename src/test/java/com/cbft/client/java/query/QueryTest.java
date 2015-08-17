package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import com.cbft.client.java.util.ClusterDependentTest;
import com.cbft.client.java.CbftRestCall;

import java.io.IOException;

import org.junit.Test;

public class QueryTest extends ClusterDependentTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    
    @Test
    public void shouldGetIndexMetrics(){
        String indexDocCounts = "http://localhost:8095/api/index/beer-index/count";

        try {
            assertEquals(200,cbftRest.get_request(indexDocCounts));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldQueryIndex(){
        String queryDocs = "http://localhost:8095/api/index/beer-index/query";
        String body = "{\"query\": {\"query\": \"beer\" , \"boost\" : 1}}";
        String contentType = "application/json";

        try {
            assertEquals(200,cbftRest.post_request(queryDocs, body,contentType));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
