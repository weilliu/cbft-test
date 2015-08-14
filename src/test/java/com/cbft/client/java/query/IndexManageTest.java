package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.cbft.client.java.CbftRestCall;
import com.cbft.client.java.util.ClusterDependentTest;

public class IndexManageTest extends ClusterDependentTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    
    @Test
    public void shouldPausesIndexUpdate() {
        
        String pauseIndex = "http://localhost:8095/api/index/beer-index/ingestControl/pause";
        String resumeIndex = "http://localhost:8095/api/index/beer-index/ingestControl/resume";
        try {
            assertEquals(200,cbftRest.post_request(pauseIndex));
            assertEquals(200,cbftRest.post_request(resumeIndex));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldFreezePlanIndex() {
        
        String indexfreezeplan = "http://localhost:8095/api/index/beer-index/planFreezeControl/freeze";
        String indexUnfreezeplan = "http://localhost:8095/api/index/beer-index/planFreezeControl/unfreeze";
        try {
            assertEquals(200,cbftRest.post_request(indexfreezeplan));
            assertEquals(200,cbftRest.post_request(indexUnfreezeplan));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldDisallowQuery() {
        
        String disallowQuery = "http://localhost:8095//api/index/beer-index/queryControl/disallow";
        String allowQuery = "http://localhost:8095//api/index/beer-index/queryControl/allow";
        try {
            assertEquals(200,cbftRest.get_request(disallowQuery));
            assertEquals(200,cbftRest.get_request(allowQuery));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetIndexMetrics(){
        String getIndexStats = "http://localhost:8095//api/stats";

        try {
            assertEquals(200,cbftRest.get_request(getIndexStats));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldReturnIndex(){
        String getSingleIndexStats = "http://localhost:8095//api/stats/index/beer-index";

        try {
            assertEquals(200,cbftRest.get_request(getSingleIndexStats));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}