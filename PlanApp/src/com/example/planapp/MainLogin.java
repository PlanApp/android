package com.example.planapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainLogin extends Activity {

	//Variables del campo
	EditText correo, pass;
	Usuario user = new Usuario();
	//String edo;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main_login);
	    // Capturamos los objetos graficos que vamos a usar
		Button ButtonIngresar= (Button) findViewById(R.id.ButtonIngresar);
		Button ButtonRegistrar = (Button) findViewById(R.id.ButtonRegistrar);
		// Fijamos un evento onclick para el button ingresar, cada vez que
		// lo pulsemos se llamara a este metodo (que abrira una actividad)
	    Log.d("MainLogin", "Cargando Boton Ingresar");
	    ButtonIngresar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Log.d("MainLogin", "Entro");
				correo= (EditText)  findViewById(R.id.correo);
				pass = (EditText)  findViewById(R.id.pass);
				Log.d("MainLogin", "Paso EditText");
				
				Log.v("MainLogin", "Paso New Conexion");
				//new Login().execute(correo);
				
				  new Thread(new Runnable() {
				  	    public void run(){ 
					   		user = httpLogin(correo.getText().toString(), pass.getText().toString());
					    	//httpLogin(correo.getText().toString(), pass.getText().toString());
					   		Log.v("MainLogin","edo antes:"+user.getEdo() );
					   		//###########
							Log.v("MainLogin","edo fuera:"+user.getEdo() );
							//if(user.getEdo().toString() == "ok"){
							if(user.getEdo().toString().equals("ok")){
								Log.v("MainLogin", "Entro");
								//CAMBIA DE VISTA
								Intent ir_a = new Intent (MainLogin.this, MainGenPanorama.class);
								ir_a.putExtra("id", user.getID());
								ir_a.putExtra("mail", user.getMail());
								Log.d("MainLogin", "Va el intent");
								startActivity(ir_a);
							}
							//############
				  	    }
				  	    
				  }).start();
				  
				/*  
				Log.v("MainLogin","edo fuera:"+user.getEdo() );
				if(user.getEdo().toString() == "ok"){
					//CAMBIA DE VISTA
					Intent ir_a = new Intent (MainLogin.this, MainGenPanorama.class);
					ir_a.putExtra("id", user.getID());
					ir_a.putExtra("mail", user.getMail());
					Log.d("MainLogin", "Va el intent");
					startActivity(ir_a);
				}
				else{
					//MENSAJE EN PANTALLA
				    Toast toast = Toast.makeText(MainLogin.this, "Datos incorrectos", Toast.LENGTH_SHORT);
				    toast.show();
				}*/
				
			}
			
		    public Usuario httpLogin(String mail, String pass) {
			//public void httpLogin(String mail, String pass) {
		    	Usuario u= new Usuario();
		    	HttpClient httpclient = new DefaultHttpClient();
		    	HttpPost httppost = new HttpPost("http://www.planapp.cl:5000/login");

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
		    	          Log.v("MainLogin", "EDO INTERNO:"+json.getString("edo"));
		    	          	
		    	          //--------
		    	          //--------
		    	          
		    	          
		    	      } catch (Exception e) {
		    	        e.printStackTrace();
		    	      }
		    		
		    		//Log.v("MainLogin", "Response from server: " + response.toString());
		    		//Log.v("MainLogin", "String :"+responseAsText);

		    	} catch (ClientProtocolException e) {
		    		
		    	} catch (IOException e) {

		    	}
				return u;
		    }
	    	
	    });
	      
	    //ButtonRegistrar registrarmos al nuevo usuario
	    ButtonRegistrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(MainLogin.this, MainRegistrar.class);
				startActivity(intent);
			}
		});

	
	

	}	
}
