package com.example.planapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainPanoramas extends Activity {

	 TextView text_id_usuario;
	 TextView text_mail;
	 TextView text_latitud;
	 TextView text_longitud;
	 TextView text_acompanante;
	 
	 String id_usuario;
	 String mail;
	 String dinero;
	 String acompanante;
	 String latitud;
	 String longitud;

	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_panoramas);
		
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		id_usuario=info.getExtras().getString("id");
		mail=info.getExtras().getString("mail");
		acompanante=info.getExtras().getString("acompanante");
		latitud=info.getExtras().getString("latitud");
		longitud=info.getExtras().getString("longitud");
		dinero=info.getExtras().getString("dinero");
		
		
		
		text_id_usuario = (TextView)findViewById(R.id.text_id_valor);
		text_latitud = (TextView)findViewById(R.id.text_latitud);
		text_longitud = (TextView)findViewById(R.id.text_longitud);
		
		//SETEO DE VALORES EN LA VISTA
		text_id_usuario.setText(id_usuario);
		text_latitud.setText(latitud);
		text_longitud.setText(longitud);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_panoramas, menu);
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
}
