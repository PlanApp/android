package com.example.planapp;

import java.util.ArrayList;

import android.view.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainListarLugares extends Activity {

	 private ArrayList<String> lista_nombres;
	 private ArrayList<String> lista_imagenes;
	 private ArrayList<String> lista_ids;
	 private ArrayList<String> lista_descrip;
	 private ArrayList<String> lista_tipo;
	 
	 private String[] nombre;
	 private String[] image;
	 //private String[] ids;
	 //private String[] descrip;
	 private String[] tipo;
	 
		//---new
	 ListView list;
	 LazyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_listar_lugares);
		
		Log.v("MainListarLugares","Entro");
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		lista_nombres=info.getStringArrayListExtra("nombres");
		lista_imagenes=info.getStringArrayListExtra("imagenes");
		lista_ids=info.getStringArrayListExtra("ids");
		lista_descrip=info.getStringArrayListExtra("descrip");
		lista_tipo=info.getStringArrayListExtra("tipo");
		
		nombre = new String[lista_nombres.size()];
		image = new String[lista_imagenes.size()];
		//ids = new String[lista_ids.size()];
		//descrip = new String[lista_descrip.size()];
		tipo = new String[lista_tipo.size()];

		Log.v("MainListarLugares","Separando Datos, largo :"+lista_nombres.size());
		for( int i = 0 ; i < lista_nombres.size() ; i++ ){
			Log.v("MainListarPanoramas","dato:"+lista_nombres.get(i)+"-"+lista_imagenes.get(i));
			nombre[i]=lista_nombres.get(i);
			image[i]=lista_imagenes.get(i);
			//ids[i]=lista_ids.get(i);
			//descrip[i]=lista_descrip.get(i);
			tipo[i]=lista_tipo.get(i);
		}
		
		Log.v("MainListarPanoramas","Imprimiendo lista");
		list=(ListView)findViewById(R.id.list);
		adapter=new LazyAdapter(MainListarLugares.this,nombre, tipo, image );
		list.setAdapter(adapter);
		//---PRESIONAR SOBRE UN ITEM DE LA LISTA---//
		list.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id){
		//--Ir a vista : Opciones--//
		Log.v("OnItem", "va a intent de vista del lugar");
		//Notas item=NotaList2.get(position);
		Intent ir_a = new Intent (MainListarLugares.this, MainVerPanorama.class);
		ir_a.putExtra("nombre", lista_nombres.get(position));
		ir_a.putExtra("img", lista_imagenes.get(position));
		ir_a.putExtra("descrip", lista_descrip.get(position));
		ir_a.putExtra("tipo", lista_tipo.get(position));
		ir_a.putExtra("id_lugar", lista_ids.get(position));
		Log.v("MainListarPanoramas","Apreto:"+lista_nombres.get(position)+" pos :"+position);
		startActivity(ir_a);
		}
		});
	}
	

	
	
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_listar_lugares, menu);
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
