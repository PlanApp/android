package com.example.glock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//NEW
//import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class AgregarActivity extends ActionBarActivity {

	//---Variables formulario---//
	EditText titulo, contenido;
	String datos[];
	
	// Ruta y Nombre de la activad a la cual voy a enviar la info.
	final static String ACT_INFO = "com.example.glock.InsertarActivity.java"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar);
		
		//---Pasar variables ---//
		titulo=(EditText)findViewById(R.id.titulo);
		contenido=(EditText)findViewById(R.id.contenido);
		datos=new String[2];
	}
	
	public void InsertarNota(View v){
		//Obtengo el valor que hay en las cajas de texto
		datos[0]=titulo.getText().toString();
		datos[1]=contenido.getText().toString();
		
		//Creao y asigno la información a enviar
		Intent ir_a=new Intent(this, InsertarActivity.class);
		ir_a.putExtra(ACT_INFO, datos);
		startActivity(ir_a);
	}

/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agregar, menu);
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
	}
*/
}
