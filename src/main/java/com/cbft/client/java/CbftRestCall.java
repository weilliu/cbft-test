package com.cbft.client.java;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.logging.*;

public class CbftRestCall {
    
    static HttpClient httpClient = new DefaultHttpClient();
    //private final Logger fLogger=Logger.getLogger(this.getClass().getPackage().getName());
    static {
        // set a system property such that Simple Logger will include timestamp
        System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
 
        // set a system property such that Simple Logger will include timestamp in the given format
        System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", "dd-MM-yy HH:mm:ss");
 
        // set minimum log level for SLF4J Simple Logger at warn
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
 
        // configure SLF4J Simple Logger to redirect output to a file
       // System.setProperty("org.slf4j.simpleLogger.logFile", "SLF4J-File.log");
    }
    private static org.slf4j.Logger fLogger = org.slf4j.LoggerFactory.getLogger("CbftRestCall");
    
    
    public int get_request(String URI) throws ClientProtocolException, IOException
    {   
        HttpGet httpGet = new HttpGet(URI);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String ResponseText = IOUtils.toString(httpResponse.getEntity().getContent());
        
        fLogger.debug("Get API:"+URI);
        fLogger.debug("\n =========== Return result ========\n"+ ResponseText +"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        
        if (statusCode !=200){
            fLogger.warn("Error Calling Get API:"+URI);
            fLogger.warn("\n =========== Return result ========\n"+ ResponseText+"\n\n");
        }
        
        return statusCode;  
    }
    
    public int post_request(String URI, String body, String contentType) throws IOException
    {        
        HttpPost httpPost = new HttpPost(URI);   
        
        if (body != null){
            StringEntity userEntity = new StringEntity(body);
            httpPost.setEntity(userEntity);
        }
        if (contentType != null){
            httpPost.addHeader("content-type", contentType);
        }
        
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String ResponseText = IOUtils.toString(httpResponse.getEntity().getContent());
        
        fLogger.debug("Post API:"+URI);
        fLogger.debug("\n =========== Return result ========\n"+ ResponseText +"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
 
        if (statusCode !=200){
            fLogger.warn("Error Calling Post API:"+URI);
            fLogger.warn("\n =========== Return result ========\n"+ResponseText+"\n\n");
        }
        
        return statusCode;  
    }
        
    public int delete_request(String URI) throws IOException
    {        
        HttpDelete httpDelete = new HttpDelete(URI);   
        HttpResponse httpResponse = httpClient.execute(httpDelete);
        String ResponseText = IOUtils.toString(httpResponse.getEntity().getContent());
        
        fLogger.debug("Delete API:"+URI);
        fLogger.debug("\n =========== Return result ========\n"+ResponseText +"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
 
        if (statusCode !=200){
            fLogger.warn("Error Calling Delete API:"+URI);
            fLogger.warn("\n =========== Return result ========\n"+ ResponseText +"\n\n");
        }
        return statusCode;  
    }
    
    public int put_request(String URI) throws IOException
    {        
        HttpPut httpPut = new HttpPut(URI);   
        HttpResponse httpResponse = httpClient.execute(httpPut);
        String ResponseText = IOUtils.toString(httpResponse.getEntity().getContent());
        
        fLogger.debug("Put API:"+URI);
        fLogger.debug("\n =========== Return result ========\n"+ ResponseText +"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
 
        if (statusCode !=200){
            fLogger.warn("Error Calling Put API:"+URI);
            fLogger.warn("\n =========== Return result ========\n"+ ResponseText +"\n\n");
        }
        return statusCode;  
    }
}
