package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import com.cbft.client.java.CbftRestCall;
import java.io.IOException;
import org.junit.Test;
import com.cbft.client.java.util.ClusterDependentTest;


public class QueryTest extends ClusterDependentTest {

    CbftRestCall cbftRest = new CbftRestCall();
    
    @Test
    public void shouldGetIndexDefinition() {
        
        String popular = "http://localhost:8095/api/index";
        try {
            assertEquals(200,cbftRest.get_request(popular));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetIndexCount() {
        
        String recent = "http://localhost:8095/api/index/beer-index/count";
        try {
            assertEquals(200,cbftRest.get_request(recent));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
