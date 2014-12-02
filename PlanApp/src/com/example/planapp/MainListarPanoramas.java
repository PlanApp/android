package com.example.planapp;

import java.util.ArrayList;
import java.util.List;
//import java.util.Iterator;
//import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainListarPanoramas extends Activity {

	private List<String> ids_1=new ArrayList<String>();
    private List<String> lugares_1=new ArrayList<String>();
	private List<String> ids_2=new ArrayList<String>();
    private List<String> lugares_2=new ArrayList<String>();
	private List<String> ids_3=new ArrayList<String>();
    private List<String> lugares_3=new ArrayList<String>();
    private List<String> imagenes=new ArrayList<String>();
    
    private String[] ids1;
    private String[] ids2;
    private String[] ids3;
    
    private String[] lugares;
    
    private String [] img;
    
    private String [] titulos;
    
    String id_usuario;
    
    /*
    private String[] nombre;
    private String[] image;
    private String[] ids;
    private String[] descrip;
    private String[] tipo;
    */
    
	//---new
	ListView list;
    LazyAdapter adapter;
	
    //private List<Lugar> lugares=new ArrayList<Lugar>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_listar_panoramas);
		
		Log.v("MainListarPanoramas","Entro");
		
		//OBTENER DATOS DE LA OTRA VISTA
		Intent info=getIntent();
		ids_1=info.getStringArrayListExtra("ids_1");
		ids_2=info.getStringArrayListExtra("ids_2");
		ids_3=info.getStringArrayListExtra("ids_3");
		lugares_1=info.getStringArrayListExtra("lugares_1");
		lugares_2=info.getStringArrayListExtra("lugares_2");
		lugares_3=info.getStringArrayListExtra("lugares_3");
		imagenes=info.getStringArrayListExtra("imagenes");
		id_usuario=info.getExtras().getString("id");
		
		//DEFINIR TAMANO ARREGLOS
		ids1 = new String[ids_1.size()];
		ids2 = new String[ids_2.size()];
		ids3 = new String[ids_3.size()];
		
		lugares = new String[lugares_1.size()];
		
		titulos =new String[ids_1.size()];
		
		img = new String[imagenes.size()];
		

		Log.v("MainListarPanoramas","Separando Datos, largo :"+ids_1.size());
	  	
		for( int i = 0 ; i < imagenes.size() ; i++ ){
		  Log.v("MainListarPanoramas","dato:"+imagenes.get(i));
		  ids1[i]=ids_1.get(i);
		  ids2[i]=ids_2.get(i);
		  ids3[i]=ids_3.get(i);
		  titulos[i]="Panoramas     ";
		  lugares[i]=lugares_1.get(i)+", "+lugares_2.get(i)+","+lugares_3.get(i);
		  img[i]=imagenes.get(i);
		}
			
		//IMPRIMIR LISTA
		
		Log.v("MainListarPanoramas","Imprimiendo lista");
	    list=(ListView)findViewById(R.id.list);
	    adapter=new LazyAdapter(MainListarPanoramas.this,titulos,lugares, img);
	    list.setAdapter(adapter);
	    
	  //---PRESIONAR SOBRE UN ITEM DE LA LISTA---//
	    list.setOnItemClickListener(new OnItemClickListener() {
	    	@Override
	    	public void onItemClick(AdapterView<?> parent, View view, int position,long id){
	    		//--Ir a vista : Opciones--//
	    		Log.v("OnItem", "va a intent de vista del lugar");
	    		//Notas item=NotaList2.get(position);
	    		Intent ir_a = new Intent (MainListarPanoramas.this, MainLugares.class);
	    		//PASA ID DE ACTIVIDADES/LUGARES DEL PANORAMA SELECCIONADO
	    		ir_a.putExtra("id_1", ids_1.get(position));
	    		ir_a.putExtra("id_2", ids_2.get(position));
	    		ir_a.putExtra("id_3", ids_3.get(position));
	    		ir_a.putExtra("id", id_usuario);
	    		Log.v("MainListarPanoramas","Apreto:"+(position));
	    		startActivity(ir_a);
	    	}
	    });
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
