package com.example.planapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainLugares extends Activity {

	private List<String> nombres=new ArrayList<String>();
	private List<String> imagenes=new ArrayList<String>();
	private List<String> ids=new ArrayList<String>();
	private List<String> descrip=new ArrayList<String>();
	private List<String> tipo=new ArrayList<String>();
	
	private List<Lugar> lugares=new ArrayList<Lugar>();
	
	String id1;
	String id2;
	String id3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_lugares);
		
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		id1=info.getExtras().getString("id_1");
		id2=info.getExtras().getString("id_2");
		id3=info.getExtras().getString("id_3");
		
		//CONEXION CON EL WEBSERVICE
		new Thread(new Runnable() {
	  	    public void run(){
	  	    	//LLAMO A LA FUNCION QUE ENVIA LOS DATOS

	  	    	Log.v("MainLogin", "new thread");
	  	    	Conexion conn=new Conexion();
	  	    	lugares=conn.httpGetRecomendacionLugares(id1,id2,id3);
	  	    	Log.v("MainPanoramas","Lugares cargados");
				

				//int cont=0;
	  	    	Log.v("MainPanoramas","Separando info");
	  	    	for( int i = 0 ; i < 3 ; i++ ){
	  	    		Lugar l = lugares.get(i);
	  	    		Log.v("MainPanoramas","Gaurdando"+l.getNombre()+"-"+l.getImagen());
	  	    		nombres.add(l.getNombre());
	  	    		imagenes.add(l.getImagen());
	  	    		ids.add(l.getID());
	  	    		descrip.add(l.getDescrip());
	  	    		tipo.add(l.getTipo());
	  	    		//cont=cont+1;
	  	    	}
	  	    	Log.v("MainPanoramas","Generando Intent");
	  	    	Intent ir_a = new Intent (MainLugares.this, MainListarLugares.class);
	  	    	ir_a.putStringArrayListExtra("nombres", (ArrayList<String>) nombres);
	  	    	ir_a.putStringArrayListExtra("imagenes", (ArrayList<String>)imagenes);
	  	    	ir_a.putStringArrayListExtra("ids", (ArrayList<String>)ids);
	  	    	ir_a.putStringArrayListExtra("descrip", (ArrayList<String>)descrip);
	  	    	ir_a.putStringArrayListExtra("tipo", (ArrayList<String>)tipo);
	  	    	//ir_a.putExtra("mail", user.getMail());
	  	    	Log.v("MainPanoramas", "Va el intent MainListPanoramas");
	  	    	startActivity(ir_a);		   							   		
	  	    }
	  	    
	  }).start();
		
		
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_lugares, menu);
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
