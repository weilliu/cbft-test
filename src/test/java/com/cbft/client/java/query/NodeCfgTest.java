package com.cbft.client.java.query;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.cbft.client.java.CbftRestCall;
import com.cbft.client.java.util.TestProperties;

public class NodeCfgTest {
    
    CbftRestCall cbftRest = new CbftRestCall();
    private String cbftNode = TestProperties.cbftNode();
        
    @Test
    public void shouldGetClusterCfg() {
        
        String nodecfg = "http://"+cbftNode+":8095/api/cfg";
        try {
            assertEquals(200,cbftRest.get_request(nodecfg));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldRefreshClusterCfg() {
        
        String nodecfgRefresh = "http://"+cbftNode+":8095/api/cfgRefresh";
        try {
            assertEquals(200,cbftRest.post_request(nodecfgRefresh, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldReplanResource() {
        
        String nodeReplanResource= "http://"+cbftNode+":8095/api/managerKick";
        try {
            assertEquals(200,cbftRest.post_request(nodeReplanResource, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetNodeCapabilities() {
        
        String nodeCapabilities = "http://"+cbftNode+":8095/api/managerMeta";
        try {
            assertEquals(200,cbftRest.get_request(nodeCapabilities));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldDiagNode() {
        
        String nodeDiag = "http://"+cbftNode+":8095/api/diag";
        try {
            assertEquals(200,cbftRest.get_request(nodeDiag));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldLogNode() {
        
        String nodeLog = "http://"+cbftNode+":8095/api/log";
        try {
            assertEquals(200,cbftRest.get_request(nodeLog));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetNodeInfo() {
        
        String nodeInfo = "http://"+cbftNode+":8095/api/runtime";
        try {
            assertEquals(200,cbftRest.get_request(nodeInfo));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetNodeCpu() {
        
        String nodeCpu = "http://"+cbftNode+":8095/api/runtime/profile/cpu";
        try {
            assertEquals(200,cbftRest.post_request(nodeCpu, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetNodeArg() {
        
        String nodeArg = "http://"+cbftNode+":8095/api/runtime/args";
        try {
            assertEquals(200,cbftRest.get_request(nodeArg));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetNodeMem() {
        
        String nodemem = "http://"+cbftNode+":8095/api/runtime/profile/memory";
        try {
            assertEquals(200,cbftRest.post_request(nodemem, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGCNode() {
        
        String nodegc = "http://"+cbftNode+":8095/api/runtime/gc";
        try {
            assertEquals(200,cbftRest.post_request(nodegc, null, null));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetLowLevelNodeStats() {
        
        String nodelowlevelstats = "http://"+cbftNode+":8095/api/runtime/stats";
        try {
            assertEquals(200,cbftRest.get_request(nodelowlevelstats));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldGetLowLevelMemNodeStats() {
        
        String nodelowlevelmemstats = "http://"+cbftNode+":8095/api/runtime/statsMem";
        try {
            assertEquals(200,cbftRest.get_request(nodelowlevelmemstats));
        } 
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
