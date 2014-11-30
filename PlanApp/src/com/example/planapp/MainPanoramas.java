package com.example.planapp;

import java.util.ArrayList;
import java.util.List;

import com.example.planapp.app.adater.CustomListAdapter;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainPanoramas extends Activity {
	
	 String id_usuario;
	 String mail;
	 String dinero;
	 String acompanante;
	 String latitud;
	 String longitud;
	 String presicion;
	 
	LocationManager locManager;
	LocationListener locListener;
	
	List<Lugar> lugares=new ArrayList<Lugar>();
	
	
	//-----new
    private ListView listView;
    private CustomListAdapter adapter;
    //--

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_panoramas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_panoramas, menu);
		
		//GEOLOCALIZACION
		comenzarLocalizacion();
		
		//CONEXION CON EL WEBSERVICE
		new Thread(new Runnable() {
	  	    public void run(){
	  	    	//LLAMO A LA FUNCION QUE ENVIA LOS DATOS
		   		//user = httpLogin(correo.getText().toString(), pass.getText().toString());
	  	    	Log.v("MainLogin", "new thread");
	  	    	Conexion conn=new Conexion();
	  	    	lugares=conn.httpGetRecomendacion(id_usuario, longitud, latitud, acompanante, dinero);
		   							   		
	  	    	//IMPRIMIR LISTA
	  	    	
	  	    }
	  	    
	  }).start();
		
		//---NEW
		listView = (ListView) findViewById(R.id.list);
		adapter = new CustomListAdapter(this, lugares );
		listView.setAdapter(adapter);
		//---
		
		
		return true;
	}

	 // --- GEOLOCALIZACION ---//
	 void comenzarLocalizacion()
	 {
	    	//Obtenemos una referencia al LocationManager
		 
	    	locManager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
	    	
	    	//Obtenemos la �ltima posici�n conocida
	    	Location loc =locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	    	
	    	//Mostramos la �ltima posici�n conocida
	    	mostrarPosicion(loc);
	    	
	    	//Nos registramos para recibir actualizaciones de la posici�n
	    	this.locListener = new LocationListener() {
		    	public void onLocationChanged(Location location) {
		    		mostrarPosicion(location);
		    	}
		    	public void onProviderDisabled(String provider){
		    		Log.i("", "Provider OFF ");
		    	}
		    	public void onProviderEnabled(String provider){
		    		Log.i("", "Provider ON ");
		    	}
		    	
		    	
		    	public void onStatusChanged(String provider, int status, Bundle extras){
		    		Log.v("", "Provider Status: " + status);
		    	}
	    	};
	    	
	    	locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locListener);
	    }
	     
	    private void mostrarPosicion(Location loc) {
	    	if(loc != null){
	    		Log.v("MainPanoramas", String.valueOf(loc.getLatitude() + " - " + String.valueOf(loc.getLongitude())));
	    		latitud=String.valueOf(loc.getLatitude());
	    		longitud=String.valueOf(loc.getLongitude());
	    		presicion=String.valueOf(loc.getAccuracy());
	    	}
	    	else
	    	{
	    		latitud="SinDatos";
	    		longitud="SinDatos";
	    		presicion="SinDatos";
	    		Log.v("MainPanoramas", "SinDatos - SinDatos");
	    	}
	    }
	    //---FIN GEOLOCALIZACIÓN ---//
	
	/*
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
}
