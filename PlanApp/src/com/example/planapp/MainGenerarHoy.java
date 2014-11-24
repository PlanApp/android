package com.example.planapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainGenerarHoy extends Activity {

	Spinner spacompanantes;
    String[] acompanantes = {
    	"Trabajo",
    	"Amiga",
        "Amigo",
        "Amigos",
        "Pareja",
        "Cita"
    };
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generarhoy);
        
        spacompanantes = (Spinner)findViewById(R.id.spinner_acompanante);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, acompanantes);
        
        		spacompanantes.setAdapter(adapter);
        		
        		spacompanantes.setOnItemSelectedListener(
        				new AdapterView.OnItemSelectedListener() {
        					@Override
        					public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
        						int position = spacompanantes.getSelectedItemPosition();
        						Toast.makeText(getApplicationContext(),"You have selected "+acompanantes[+position],Toast.LENGTH_LONG).show();
        						// TODO Auto-generated method stub
        					}
        					@Override
        					public void onNothingSelected(AdapterView<?> arg0) {
        						// TODO Auto-generated method stub
        					}
        				}
        		);
	}
}
