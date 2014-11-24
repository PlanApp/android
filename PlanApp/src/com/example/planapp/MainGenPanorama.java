package com.example.planapp;

import android.app.Activity;
import android.content.Intent;
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
    String[] acompanantes = {
    	"---",	
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
        					Log.v("MainGenPanorama", "spin :"+acompanantes[+position]+" dinero :"+dinero.getText().toString());
							Intent ir_a = new Intent (MainGenPanorama.this, MainPanoramas.class);
							ir_a.putExtra("acompanantes", acompanantes[+position]);
							ir_a.putExtra("dinero", dinero.getText().toString());
							Log.d("MainGenPanoramas", "Va el intent Panoramas");
							startActivity(ir_a);
        				}
        });
	}
}
