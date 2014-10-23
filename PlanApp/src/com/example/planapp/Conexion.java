package com.example.planapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


public class Conexion{
	
	//String datos[];
	
	public static String POST(String url, Usuario usuario){
		InputStream inputStream = null;
		String result = "";
		try {
		// 1. create HttpClient
		HttpClient httpclient = new DefaultHttpClient();
		// 2. make POST request to the given URL
		HttpPost httpPost = new HttpPost(url);
		String json = "";
		// 3. build jsonObject
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("mail", usuario.getMail());
		jsonObject.accumulate("password", usuario.getPassword());
		//jsonObject.accumulate("twitter", person.getTwitter());
		// 4. convert JSONObject to JSON to String
		json = jsonObject.toString();
		// ** Alternative way to convert Person object to JSON string usin Jackson Lib
		// ObjectMapper mapper = new ObjectMapper();
		// json = mapper.writeValueAsString(person);
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
		// 10. convert inputstream to string
		if(inputStream != null)
			result = convertInputStreamToString(inputStream);
		else
			result = "Did not work!";
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}
		// 11. return result
		return result;
	}
	
	//@Override
	public String login(String mail, String pass) {
		/*
		switch(view.getId()){
		case R.id.btnPost:
			if(!validate())
				Toast.makeText(getBaseContext(), "Enter some data!", Toast.LENGTH_LONG).show();
			// call AsynTask to perform network operation on separate thread
			new HttpAsyncTask().execute("http://hmkcode.appspot.com/jsonservlet");
			break;
		}*/
		new HttpAsyncTask().execute("www.planapp.cl:5000/login");
		return "ok";
		
	}
	
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {

		
		
		@Override
		protected String doInBackground(String... urls) {
			 Usuario usuario = new Usuario();
			 usuario.setMail("LALA");
			 usuario.setPassword("123");
			 //person.setTwitter(etTwitter.getText().toString());
			 return POST(urls[0],usuario);
		 }		
		
		 // onPostExecute displays the results of the AsyncTask.
		 @Override
		 protected void onPostExecute(String result) {
			 //Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();
			 Log.d("Conexion", "Enviado");
		 }
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