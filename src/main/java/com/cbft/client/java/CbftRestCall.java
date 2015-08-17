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
    private final Logger fLogger=Logger.getLogger(this.getClass().getPackage().getName());
    
    public int get_request(String URI) throws ClientProtocolException, IOException
    {   
        HttpGet httpGet = new HttpGet(URI);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        
        fLogger.log(Level.INFO, "Get API:"+URI);
        fLogger.log(Level.FINE, "\n =========== Return result ========\n"+ IOUtils.toString(httpResponse.getEntity().getContent())+"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        
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
        
        fLogger.log(Level.INFO, "Post API:"+URI);
        fLogger.log(Level.FINE, "\n =========== Return result ========\n"+ IOUtils.toString(httpResponse.getEntity().getContent())+"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
 
        return statusCode;  
    }
        
    public int delete_request(String URI) throws IOException
    {        
        HttpDelete httpDelete = new HttpDelete(URI);   
        HttpResponse httpResponse = httpClient.execute(httpDelete);
        
        fLogger.log(Level.INFO, "Delete API:"+URI);
        fLogger.log(Level.FINE, "\n =========== Return result ========\n"+ IOUtils.toString(httpResponse.getEntity().getContent())+"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
 
        return statusCode;  
    }
    
    public int put_request(String URI) throws IOException
    {        
        HttpPut httpPut = new HttpPut(URI);   
        HttpResponse httpResponse = httpClient.execute(httpPut);
        
        fLogger.log(Level.INFO, "Put API:"+URI);
        fLogger.log(Level.FINE, "\n =========== Return result ========\n"+ IOUtils.toString(httpResponse.getEntity().getContent())+"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
 
        return statusCode;  
    }
}
