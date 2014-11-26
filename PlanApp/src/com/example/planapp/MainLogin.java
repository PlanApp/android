package com.example.planapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
	
	//INICIO GEO//
	LocationManager locManager;
	LocationListener locListener;

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
	    ButtonIngresar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				correo= (EditText)  findViewById(R.id.correo);
				pass = (EditText)  findViewById(R.id.pass);
				  //NUEVO THREAD PARA ENVIAR EL POST 
				  new Thread(new Runnable() {
				  	    public void run(){
				  	    	//LLAMO A LA FUNCION QUE ENVIA LOS DATOS
					   		//user = httpLogin(correo.getText().toString(), pass.getText().toString());
				  	    	Log.v("MainLogin", "Conectando con WebService");
				  	    	Conexion conn=new Conexion();
				  	    	user=conn.httpLogin(correo.getText().toString(), pass.getText().toString());
					   							   		
					   		//VEO LA RESPUESTA DE LA FUNCION DE LOGIN
							if(user.getEdo().toString().equals("ok")){
								//CAMBIA DE VISTA SI LOS DATOS SON CORRECTOS
								Intent ir_a = new Intent (MainLogin.this, MainGenPanorama.class);
								ir_a.putExtra("id", user.getID());
								ir_a.putExtra("mail", user.getMail());
								Log.d("MainLogin", "Va el intent");
								startActivity(ir_a);
							}
							else{
								//MENSAJE EN PANTALLA DE DATOS INCORRECTOS
								MainLogin.this.runOnUiThread(new Runnable() {
								    public void run() {
								        //Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show();
								    	Toast toast = Toast.makeText(MainLogin.this, "Datos incorrectos", Toast.LENGTH_SHORT);
									    toast.show();
								    }
								});
							}
				  	    }
				  	    
				  }).start();
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
	
	
	 void comenzarLocalizacion()
	    {
	    	//Obtenemos una referencia al LocationManager
	    	locManager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
	    	
	    	//Obtenemos la �ltima posici�n conocida
	    	Location loc =locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	    	
	    	//Mostramos la �ltima posici�n conocida
	    	//mostrarPosicion(loc);
	    	
	    	//Nos registramos para recibir actualizaciones de la posici�n
	    	this.locListener = new LocationListener() {
		    	public void onLocationChanged(Location location) {
		    		//mostrarPosicion(location);
		    		Log.v("MainLogin",  String.valueOf(location.getLatitude())+" "+String.valueOf(location.getLongitude()));
		    	}
		    	public void onProviderDisabled(String provider){
		    		Log.v("", "Provider OFF ");
		    		/*
		    		Toast toast = Toast.makeText(this, "Provider OFF", Toast.LENGTH_SHORT);
				    toast.show();
				    */
		    		//this.estado.setText("Provider OFF");
		    	}
		    	public void onProviderEnabled(String provider){
		    		Log.v("", "Provider ON ");
		    		/*
		    		Toast toast = Toast.makeText(this, "Provider ON ", Toast.LENGTH_SHORT);
				    toast.show();
				    */	    		
		    		//this.estado.setText("Provider ON ");
		    	}
		    	
		    	
		    	public void onStatusChanged(String provider, int status, Bundle extras){
		    		Log.v("", "Provider Status: " + status);
		    		
		    		//Toast toast = Toast.makeText(this, "Provider Status: " + status, Toast.LENGTH_SHORT);
				    //toast.show();
				    
		    		//estado.setText("Provider Status: " + status);
		    	}
	    	};
	    	
	    	locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locListener);
	    }
	    /* 
	    private void mostrarPosicion(Location loc) {
	    	if(loc != null){
	    		//lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
	    		//lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
	    		//lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
	    		Log.i("", String.valueOf(loc.getLatitude() + " - " + String.valueOf(loc.getLongitude())));
	    		latitud=String.valueOf(loc.getLatitude());
	    		longitud=String.valueOf(loc.getLongitude());
	    		presicion=String.valueOf(loc.getAccuracy());
	    	}
	    	else
	    	{
	    		//lblLatitud.setText("Latitud: (sin_datos)");
	    		//lblLongitud.setText("Longitud: (sin_datos)");
	    		//lblPrecision.setText("Precision: (sin_datos)");
	    		latitud="SinDatos";
	    		longitud="SinDatos";
	    		presicion="SinDatos";
	    	}
	    }*/
}
