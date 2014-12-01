package com.example.planapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainVerPanorama extends Activity {
	
    String nombre;
    String img;
    String id_lugar;
    String descrip;
    String tipo;
    
    private TextView  textnombre;
    private TextView  texttipo;
    private TextView  textdescrip;
    
    private ImageView imgView;
    private ImageLoader imgLoader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v("MainVerPanoramas","Entro");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_ver_panorama);

		Log.v("MainVerPanoramas","Capturando Datos Intent");
		
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		id_lugar=info.getExtras().getString("id_lugar");
		img=info.getExtras().getString("img");
		nombre=info.getExtras().getString("nombre");
		descrip=info.getExtras().getString("descrip");
		tipo=info.getExtras().getString("tipo");
		
		Log.v("MainVerPanoramas","Seteando Texto");
		
		textnombre = (TextView)findViewById(R.id.textnombre);
		texttipo = (TextView)findViewById(R.id.texttipo);
		textdescrip = (TextView)findViewById(R.id.textdescrip);
		
		textnombre.setText(nombre);
		texttipo.setText(tipo);
		textdescrip.setText(descrip);
		
		Log.v("MainVerPanoramas","Seteando IMG");
		imgView = (ImageView) findViewById(R.id.imagen);
        imgLoader = new ImageLoader(this);
        imgLoader.DisplayImage(img, imgView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_ver_panorama, menu);
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
