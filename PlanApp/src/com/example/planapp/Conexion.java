package com.example.planapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.util.Log;


class Conexion{
	private String url="http://www.planapp.cl:5000/";

    public Usuario httpLogin(String mail, String pass) {
    	Usuario u= new Usuario();
    	HttpClient httpclient = new DefaultHttpClient();
    	Log.v("Conexion", "Espenado respuesta ...");
    	HttpPost httppost = new HttpPost(url+"login");

    	try {
    		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
    		nameValuePairs.add(new BasicNameValuePair("mail", mail));
    		nameValuePairs.add(new BasicNameValuePair("password", pass));
    		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

    		HttpResponse response = httpclient.execute(httppost);
    		String responseAsText = EntityUtils.toString(response.getEntity());

    	    try {
    	          JSONObject json = new JSONObject(responseAsText);

    	          u.setEdo(json.getString("edo"));
    	          u.setID(json.getString("id"));
    	          u.setMail(json.getString("mail"));
    	      } catch (Exception e) {
    	        e.printStackTrace();
    	      }
    	} catch (ClientProtocolException e) {

    	} catch (IOException e) {

    	}
		return u;
    }



		public Usuario httpRegistro(String mail, String nombre, String pass, String fecha_naci, String sexo) {
			Usuario u= new Usuario();
			HttpClient httpclient = new DefaultHttpClient();
			Log.v("Conexion", "Espenado respuesta ...");
			HttpPost httppost = new HttpPost(url+"registro");

			try {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("mail", mail));
				nameValuePairs.add(new BasicNameValuePair("nombre", nombre));
				nameValuePairs.add(new BasicNameValuePair("password", pass));
				nameValuePairs.add(new BasicNameValuePair("fecha_nacimiento", fecha_naci));
				nameValuePairs.add(new BasicNameValuePair("sexo", sexo));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse response = httpclient.execute(httppost);
				String responseAsText = EntityUtils.toString(response.getEntity());

					try {
								//CAPTURA DE RESPUESTA
								JSONObject json = new JSONObject(responseAsText);
								u.setEdo(json.getString("edo"));
						} catch (Exception e) {
							e.printStackTrace();
						}
			} catch (ClientProtocolException e) {

			} catch (IOException e) {

			}
		return u;
		}

}
