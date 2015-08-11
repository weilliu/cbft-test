package com.cbft.client.java;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class CbftRestCall {
    
    static HttpClient httpClient = new DefaultHttpClient();

    public int get_request(String URI) throws ClientProtocolException, IOException
    {   
        HttpGet httpGet = new HttpGet(URI);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        
        System.out.println("Get API:"+URI+"\n =========== Return result ========");
        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent())+"\n\n");
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        
        return statusCode;  
    }
    
    public int post_request(String URI) throws IOException
    {        
        HttpPost httpPost = new HttpPost(URI);   
        HttpResponse httpResponse = httpClient.execute(httpPost);
        
        System.out.println("Post API:"+URI+"\n =========== Return result ========");
        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
        
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        
        return statusCode;  
    }
}
