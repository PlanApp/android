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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainGenPanorama extends Activity {
	int position=0;
	Spinner spacompanantes;
	EditText dinero;
	LocationManager locManager;
	LocationListener locListener;
	
    String[] acompanantes = {
    	"---",	
    	"Trabajo",
    	"Amiga",
        "Amigo",
        "Amigos",
        "Pareja",
        "Cita"
    };
    
    String latitud;
    String longitud;
    String id_usuario;
    String mail;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		id_usuario=info.getExtras().getString("id");
		mail=info.getExtras().getString("mail");
		
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genpanorama);
        
        //VARIABLES
        spacompanantes = (Spinner)findViewById(R.id.spinner_acompanante);
        dinero= (EditText)  findViewById(R.id.dinero);
        Button ButtonGenerar= (Button) findViewById(R.id.BotonGenerar);
        
        
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, acompanantes);
        
     	spacompanantes.setAdapter(adapter);
     	spacompanantes.setOnItemSelectedListener(
        				new AdapterView.OnItemSelectedListener() {
        					@Override
        					public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
        						position = spacompanantes.getSelectedItemPosition();
        						Toast.makeText(getApplicationContext(),"You have selected "+acompanantes[+position],Toast.LENGTH_LONG).show();
        						// TODO Auto-generated method stub
        					}
        					@Override
        					public void onNothingSelected(AdapterView<?> arg0) {
        						// TODO Auto-generated method stub
        					}
        				}
       	);
     	
        ButtonGenerar.setOnClickListener(new OnClickListener(){
        				@Override
        				public void onClick(View v) {
        					
        					//--LOCALIZACIÓN--//
        					//Obtenemos una referencia al LocationManager
        					locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        					
        					//Obtenemos la ultima posicion conocida
        			    	Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        			    	
        			    	//Mostramos la ultima posicion conocida
        			    	if(loc != null){
        			    		Log.v("MainGenPanorama", "Latitud"+String.valueOf(loc.getLatitude())+"Longitud"+String.valueOf(loc.getLongitude())+"Presicion"+String.valueOf(loc.getAccuracy()));
        			    		latitud=String.valueOf(loc.getLatitude());
        			    		longitud=String.valueOf(loc.getLongitude());
        			    	}
        			    	else{
        			    		Log.v("MainGenPanorama", "Latitud: SinDatos, Longitud: SinDatos, Presicion:SinDatos");
        			    		latitud="SinDatos";
        			    		longitud="SinDatos";
        			    	}
        			    	
        			    	
        					//-- FIN LOCALIZACIÓN--//
        					
        					Log.v("MainGenPanorama", "spin :"+acompanantes[+position]+" dinero :"+dinero.getText().toString());
							Intent ir_a = new Intent (MainGenPanorama.this, MainPanoramas.class);
							ir_a.putExtra("acompanante", acompanantes[+position]);
							ir_a.putExtra("dinero", dinero.getText().toString());
							ir_a.putExtra("latitud", latitud);
							ir_a.putExtra("longitud", longitud);
							ir_a.putExtra("id", id_usuario);
							ir_a.putExtra(mail, mail);
							Log.d("MainGenPanoramas", "Va el intent Panoramas");
							startActivity(ir_a);
        				}
        });
	}
}
