package com.cbft.client.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CbftServices {
    
    public void connect_cbft(String cbft_path, String redirect_path ){
        FileOutputStream fileOut = null;
        InputStream procOut = null;
        
        try {      
            fileOut = new FileOutputStream(redirect_path);
            Process ps = Runtime.getRuntime().exec(cbft_path);
            procOut = ps.getInputStream();
            pipeStream(procOut, fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void pipeStream(InputStream input, OutputStream output) throws IOException
    {
            byte buffer[] = new byte[1024];
            int numRead = 0;

            do{
               numRead = input.read(buffer);
               output.write(buffer, 0, numRead);
            } while (input.available() > 0);

            output.flush();
    }

}
