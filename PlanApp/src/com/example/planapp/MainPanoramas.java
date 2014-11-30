package com.example.planapp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
	
	private List<Lugar> lugares=new ArrayList<Lugar>();
	
	//---new
//	ListView list;
//    LazyAdapter adapter;
    
    //private String texto[];
	private List<String> nombres=new ArrayList<String>();
    //private String imageUrls[];
    private List<String> imagenes=new ArrayList<String>();
    
    /*
    private String texto[]={
    		"Tux",
    		"Fedora",
    		"Debian"
    };

    private String imageUrls[] = {
            "http://izaak.jellinek.com/tuxes/images/black%20and%20white%20tux.gif",
            "http://4vector.com/i/free-vector-svg-globe-green-clip-art_106713_Svg_Globe_Green_clip_art_hight.png",
            "http://blog.tenstral.net/wp-content/uploads/2013/03/Debian-duologo.png"
             
    };*/
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_panoramas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_panoramas, menu);
		
//INTENTTTTTT
		
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
	  	    	Log.v("MainPanoramas","Lugares cargados");
				
	  	    	//Iterator iter = lugares.iterator();
				int cont=0;
				Log.v("MainPanoramas","Separando info");
				//while (iter.hasNext()){
				for( int i = 0 ; i < 3 ; i++ ){
				  Lugar l = lugares.get(cont);
				  Log.v("MainPanoramas","Gaurdando"+l.getNombre()+"-"+l.getImagen());
				  nombres.add(l.getNombre());
				  //texto[cont]=l.getNombre();
				  //imageUrls[cont]=l.getImagen();
				  imagenes.add(l.getImagen());
				  //System.out.println(iter.next());
				  cont=cont+1;
				}
				
				Log.v("MainPanoramas","Generando Intent");
				Intent ir_a = new Intent (MainPanoramas.this, MainListarPanoramas.class);
				ir_a.putStringArrayListExtra("nombres", (ArrayList<String>) nombres);
				ir_a.putStringArrayListExtra("imagenes", (ArrayList<String>)imagenes);
				//ir_a.putExtra("mail", user.getMail());
				Log.v("MainPanoramas", "Va el intent MainListPanoramas");
				startActivity(ir_a);
		   							   		
	  	    }
	  	    
	  }).start();        
		
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
	   /*
	    @Override
	    public void onDestroy()
	    {
	        list.setAdapter(null);
	        super.onDestroy();
	    }*/
	     
 

}
