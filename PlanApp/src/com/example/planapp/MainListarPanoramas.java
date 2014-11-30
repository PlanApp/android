package com.example.planapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainListarPanoramas extends Activity {

    private ArrayList<String> nombres;
    private ArrayList<String> imagenes;
    
    private String[] texto;
    private String[] imageUrls;
    
	//---new
	ListView list;
    LazyAdapter adapter;
	
    private List<Lugar> lugares=new ArrayList<Lugar>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_listar_panoramas);
		
		Log.v("MainListarPanoramas","Entro");
		
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		nombres=info.getStringArrayListExtra("nombres");
		imagenes=info.getStringArrayListExtra("imagenes");
		
		//Iterator iter = lugares.iterator();
		//int cont=0;
		//while (iter.hasNext()){
		Log.v("MainListarPanoramas","Separando Datos, largo :"+nombres.size());
	  	
		for( int i = 0 ; i < nombres.size() ; i++ ){
		  //Lugar l = lugares.get(cont);
		  //nombres.add(l.getNombre());
		  Log.v("MainListarPanoramas","dato:"+nombres.get(i));
		  texto[i]=nombres.get(i);
		  //imageUrls[cont]=l.getImagen();
		  imageUrls[i]=imagenes.get(i);
		  //imagenes.add(l.getImagen());
		  //System.out.println(iter.next());
		 // cont=cont+1;
		}
			
		//IMPRIMIR LISTA
		Log.v("MainListarPanoramas","Imprimiendo lista");
	    list=(ListView)findViewById(R.id.listView1);
	    adapter=new LazyAdapter(MainListarPanoramas.this, imageUrls, texto);
	    list.setAdapter(adapter);
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_listar_panoramas, menu);
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
    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }
}
