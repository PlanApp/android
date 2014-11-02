package com.example.planapp;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.nio.charset.Charset;
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
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


//import com.google.gson.Gson;

//import com.example.planapp.Main.MyAsyncTask;

import android.app.Activity;
import android.content.Intent;
//import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;


public class MainLogin extends Activity {

	//Variables del campo
	EditText correo, pass;
	String edo="mal";
	Usuario user;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main_login);
	    // Capturamos los objetos gr�ficos que vamos a usar
		Button ButtonIngresar= (Button) findViewById(R.id.ButtonIngresar);
		Button ButtonRegistrar = (Button) findViewById(R.id.ButtonRegistrar);
		// Fijamos un evento onclick para el button ingresar, cada vez que
		// lo pulsemos se llamar� a este m�todo (que abrir� una actividad)
	    Log.d("MainLogin", "Cargando Boton Ingresar");
	    ButtonIngresar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Log.d("MainLogin", "Entro");
				correo= (EditText)  findViewById(R.id.correo);
				pass = (EditText)  findViewById(R.id.pass);
				Log.d("MainLogin", "Paso EditText");
				
				//Conexion conn = new Conexion();
				Log.v("MainLogin", "Paso New Conexion");
				//new Login().execute(correo);
				//String id=conn.login(correo.getText().toString(), pass.getText().toString());
				
				//-----------------------
				//Instanciamos y ejecutamos el proceso Asnyctask
				//new usersJson().execute();
				//-----------------------
				
				
				//-------------------------
				  new Thread(new Runnable() {
					    public void run(){ 
					   				postData();
					    }
				  }).start();

				//-------------------------
				
				//Log.d("MainLogin", "ID :"+id);
				Log.d("MainLogin", "Va el intent");
				//Intent intent = new Intent(MainLogin.this, MainGenPanorama.class);
				//obtener los parametros de user y pass
				//startActivity(intent);				
			}
			
		    public void postData() {
		    	HttpClient httpclient = new DefaultHttpClient();
		    	HttpPost httppost = new HttpPost("http://www.planapp.cl:5000/login");

		    	try {
		    		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		    		nameValuePairs.add(new BasicNameValuePair("mail", "lala@mail.cl"));
		    		nameValuePairs.add(new BasicNameValuePair("password", "123456"));
		    		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		    		
		    		HttpResponse response = httpclient.execute(httppost);
		    		String responseAsText = EntityUtils.toString(response.getEntity());
		    		
		    	    try {
		    	          JSONObject json = new JSONObject(responseAsText);
		    	          Log.v("MainLogin", json.getString("edo"));
		    	        
		    	      } catch (Exception e) {
		    	        e.printStackTrace();
		    	      }
		    		
		    		/*
		    		String json=Html.fromHtml(EntityUtils.toString(response.getEntity())).toString();
		    		JSONTokener tokener=new JSONTokener(json);
		    		//Log.v("MainLogin", "edo :"+tokener.
		    		JSONArray jsonArray=new JSONArray(tokener);
		    		ArrayList<String> items = new ArrayList<String>();
		    		
		    		for (int i=0; i < jsonArray.length(); i++) {
		    		      JSONObject object=jsonArray.getJSONObject(i);
		    		      Log.v("MainLogin", "EDO :"+object.getString("edo"));
		    		      //String id=object.getString("pk");
		    		      //JSONObject fields=object.getJSONObject("fields");
		    		      
		    		      //Log.v("MainLogin", "EDO :"+fields.getString("sender")+fields.getString("mail"));
		    		     // items.add(new ReuseItem(id,fields.getString("sender"),fields.getString("title"),fields.getString("description"),fields.getString("location"),fields.getString("time"),fields.getInt("latitude"),fields.getInt("longitude")));
		    		    }
		    		*/
		    
		    		Log.v("MainLogin", "Response from server: " + response.toString());
		    		Log.v("MainLogin", "String :"+responseAsText);
		    		//-----------
		    		/*
		    		JSONObject mainObject = new JSONObject(responseAsText);

		    		JSONObject universityObject = mainObject.getJsonObject("login");
		    		JSONString name = universityObject.getJsonString("mail");  
		    		JSONString edo = universityObject.getJsonString("edo");
		    		*/
		    		//-----------
		    		
		    		
		    		/*
		    		try{
		    			//JSONObject obj = new JSONObject(responseAsText);
		    			JSONObject obj = (new JSONObject(responseAsText)).getJSONObject("obj");
		    			Log.v("MainLogin",obj.getString("edo"));
		    		}
		    		catch (Throwable t) {
		    		    Log.v("MainLogin", "Could not parse malformed JSON: \"+responseAsText");
		    		}*/
		    		
		    		
		    		

		    		//Log.v("MainLogin", "GETcontent :"+response.getEntity().getContent());

		    	} catch (ClientProtocolException e) {
		    		
		    	} catch (IOException e) {

		    	}
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
	
	
	/*
	 * Crear proceso para consultar el jSon del servidor
	 */
	/*
	class usersJson extends AsyncTask<Void, Void, Boolean> {
		private Intent pasar;

		protected void onPostExecute(Boolean result) {

			if (result) {
				pasar = new Intent(getApplicationContext(), MainGenPanorama.class);
				startActivity(pasar);
			} else {
				InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
			    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
				//TextView error = (TextView) findViewById(R.id.textError);
				//error.setText("Login incorrecto");
			    Log.v("MainLogin", "Login Incorrecto");
			}

		}
		*/
		/*
		@Override
		protected Boolean doInBackground(Void... arg0) {
			try {
				EditText userEdit = (EditText) findViewById(R.id.correo);
				EditText passEdit = (EditText) findViewById(R.id.pass);
				  // Creamos el objeto Gson al que le pasamos una URL
				  
				Gson miGson = new Gson();
				URL url = new URL("www.planapp.cl:5000/login");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(url.openStream(),
								Charset.forName("UTF-8")));

				//Pasamos la info del json a un objeto para consultarlo
				//Usuarios data = miGson.fromJson(reader, Usuarios.class);
				Usuario data = miGson.fromJson(reader, Usuario.class);
				//List<Usuario> users = data.getUsers();

			    //for (int i = 0; i < users.size(); i++) {

			 		if (userEdit.getText().toString()
							.equals(data.getMail().toString())
							&& passEdit.getText().toString()
									.equals(data.getPassword().toString())) {
						return true;
					}
					
					else
						return false;
				//}

			} catch (Exception e) {
				Log.i("valores", "Error al leer el json de internetria");
				e.printStackTrace();
			}

			return false;
		}

	}*/
	//}
	
	
}
