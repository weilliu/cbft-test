package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.cbft.client.java.CbftRestCall;
import com.cbft.client.java.util.ClusterDependentTest;

public class IndexDefTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    
    @Test
    public void shouldGetAllIndexDefinition() {
        
        String allIndexDef = "http://localhost:8095/api/index";
        try {
            assertEquals(200,cbftRest.get_request(allIndexDef));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetIndexDefinition() {
        
        String allIndexDef = "http://localhost:8095/api/index/beer-index";
        try {
            assertEquals(200,cbftRest.get_request(allIndexDef));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void shouldGetIndexCount() {
        
        String indexCount = "http://localhost:8095/api/index/beer-index/count";
        try {
            assertEquals(200,cbftRest.get_request(indexCount));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldCreateIndex() {
        
        String createIndex = "http://localhost:8095/api/index/default-index?indexType=bleve&sourceType=couchbase&sourceName=http://default@172.23.107.174:8091/pools/default/buckets/default";
        try {
            assertEquals(200,cbftRest.post_request(createIndex , null, null));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDeleteIndex() {
        
        String deleteIndex = "http://localhost:8095/api/index/another-index";
        try {
            assertEquals(200, cbftRest.delete_request(deleteIndex));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
