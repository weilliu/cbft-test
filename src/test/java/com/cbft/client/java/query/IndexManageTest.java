package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.cbft.client.java.CbftRestCall;
import com.cbft.client.java.util.ClusterDependentTest;
import com.cbft.client.java.util.TestProperties;

public class IndexManageTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    private String cbftNode = TestProperties.cbftNode();
    
    @Test
    public void shouldPausesIndexUpdate() {
        
        String pauseIndex = "http://"+cbftNode+":8095/api/index/beer-index/ingestControl/pause";
        String resumeIndex = "http://"+cbftNode+":8095/api/index/beer-index/ingestControl/resume";
        try {
            assertEquals(200,cbftRest.post_request(pauseIndex, null, null));
            assertEquals(200,cbftRest.post_request(resumeIndex, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldFreezePlanIndex() {
        
        String indexfreezeplan = "http://"+cbftNode+":8095/api/index/beer-index/planFreezeControl/freeze";
        String indexUnfreezeplan = "http://"+cbftNode+":8095/api/index/beer-index/planFreezeControl/unfreeze";
        try {
            assertEquals(200,cbftRest.post_request(indexfreezeplan, null, null));
            assertEquals(200,cbftRest.post_request(indexUnfreezeplan, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldDisallowQuery() {
        
        String disallowQuery = "http://"+cbftNode+":8095/api/index/beer-index/queryControl/disallow";
        String allowQuery = "http://"+cbftNode+":8095/api/index/beer-index/queryControl/allow";
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
        String getIndexStats = "http://"+cbftNode+":8095/api/stats";

        try {
            assertEquals(200,cbftRest.get_request(getIndexStats));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldReturnIndex(){
        String getSingleIndexStats = "http://"+cbftNode+":8095/api/stats/index/beer-index";

        try {
            assertEquals(200,cbftRest.get_request(getSingleIndexStats));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}