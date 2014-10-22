package com.example.planapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;
import android.widget.EditText;

public class Conexion{
	private String server="http://www.planapp.cl:5000/";
	
	public String login(EditText correo, EditText pass){
        InputStream inputStream = null;
        String result = "";
		try{
			// 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(this.server);
            
            String json = "";
            
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("correo", correo);
            jsonObject.accumulate("pass", pass);
            
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();
            
            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
            
            // 6. set httpPost Entity
            httpPost.setEntity(se);
            
            // 7. Set some headers to inform server about the type of the content   
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
            
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
            
            if(inputStream != null){
            	
                result = convertInputStreamToString(inputStream);
                Log.d("Conexion", result);
            }
            else{
            	
                result = "0";
                Log.d("Conexion", result);
            }
	
		}
		catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
		return result;
		
	}
	
	
	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }  
	
}