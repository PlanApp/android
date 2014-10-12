package com.example.glock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent; //OBJETOS QUE PUEDEN SER USADOS POR UNA ACTIVIDAD (CONTENER DATOS)
import android.view.View; //VISTAS
import android.widget.Button; //SOPORTE BOTONES
//import android.view.Menu;
//import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//---BOTONES: Asociar Boton con una variable---//
		Button boton_agregar=(Button)findViewById(R.id.agregar);
		Button boton_ver=(Button)findViewById(R.id.ver);
		
		//---BOTONES: Accion a reliazar.---//
		
		//boton agregar
		boton_agregar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					//Transición del MainActivity a la vista de AgregarActivity
					Intent ir_a=new Intent (MainActivity.this, AgregarActivity.class);
					startActivity(ir_a);
			}
		});
		
		//boton ver
		boton_ver.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					//Transición del MainActivity a la vista de AgregarActivity
					Intent ir_a=new Intent (MainActivity.this, VerActivity.class);
					startActivity(ir_a);
			}
		});
	}
	
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
	}*/
}
