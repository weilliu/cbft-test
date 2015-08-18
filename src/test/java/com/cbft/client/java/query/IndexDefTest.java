package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.cbft.client.java.CbftRestCall;
import com.cbft.client.java.util.ClusterDependentTest;
import com.cbft.client.java.util.TestProperties;

public class IndexDefTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    private String cbftNode = TestProperties.cbftNode();
    
    
    @Test
    public void shouldGetAllIndexDefinition() {
        
        String allIndexDef = "http://"+cbftNode+":8095/api/index";
        try {
            assertEquals(200,cbftRest.get_request(allIndexDef));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetIndexDefinition() {
        
        String allIndexDef = "http://"+cbftNode+":8095/api/index/beer-index";
        try {
            assertEquals(200,cbftRest.get_request(allIndexDef));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void shouldGetIndexCount() {
        
        String indexCount = "http://"+cbftNode+":8095/api/index/beer-index/count";
        try {
            assertEquals(200,cbftRest.get_request(indexCount));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldCreateIndex() {
        
        String createIndex = "http://"+cbftNode+":8095/api/index/default-index?indexType=bleve&sourceType=couchbase&sourceName=http://default@172.23.107.174:8091/pools/default/buckets/default";
        try {
            assertEquals(200,cbftRest.put_request(createIndex));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        //deleteIndex after create
        String deleteIndex = "http://"+cbftNode+":8095/api/index/default-index";
        try {
            cbftRest.delete_request(deleteIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void shouldDeleteIndex() {
        
        //create index before delete
        String createIndex = "http://"+cbftNode+":8095/api/index/another-index?indexType=blackhole&sourceType=nil";
        try {
            cbftRest.put_request(createIndex);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        String deleteIndex = "http://"+cbftNode+":8095/api/index/another-index";
        try {
            assertEquals(200, cbftRest.delete_request(deleteIndex));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
