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
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONException;
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

	/*
		public List<Lugar>  httpGetRecomendacion(String id_usuario, String longitud, String latitud, String acompanante, String dinero){
			
			List<Lugar> lugares=new ArrayList<Lugar>();
			
			HttpClient httpclient = new DefaultHttpClient();
			
			HttpPost httppost = new HttpPost(url+"recomienda");
			try {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("id", id_usuario));
				nameValuePairs.add(new BasicNameValuePair("longitud", longitud));
				nameValuePairs.add(new BasicNameValuePair("latitud", latitud));
				nameValuePairs.add(new BasicNameValuePair("acompanante", acompanante));
				nameValuePairs.add(new BasicNameValuePair("dinero", dinero));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				Log.v("Conexion", "Espenado respuesta ...");
				HttpResponse response = httpclient.execute(httppost);
				Log.v("Conexion","Respuesta recebida");
				String responseAsText = EntityUtils.toString(response.getEntity());
				Log.v("Conexion", "Separando el JSON");
				Log.v("Conexion", "R:"+responseAsText);
				
				JSONArray respJSON;
				
				try {
					respJSON = new JSONArray(responseAsText);
					//String[] string_lugares = new String[respJSON.length()];

					
				    for(int i=0; i<respJSON.length(); i++){
				    	Lugar lugar = new Lugar();
				    	JSONObject obj = respJSON.getJSONObject(i);
				    	lugar.setID(obj.getString("id"));
				    	lugar.setNombre(obj.getString("nombre"));
				    	lugar.setUbicacion(obj.getString("ubicacion"));
				    	lugar.setMonto(obj.getString("monto"));
				    	lugar.setImagen(obj.getString("img"));
				    	Log.v("LUGARES", "ID :"+lugar.getID()+" nombre :"+lugar.getNombre());
				    	lugares.add(lugar);
				    }
				    
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
						
						
				
			} catch (ClientProtocolException e) {

			} catch (IOException e) {

			}
			
			return lugares;
		}
*/
}
