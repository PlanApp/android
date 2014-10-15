package com.example.glock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//NEW
import java.util.List;
import java.util.ArrayList;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class VerActivity extends ActionBarActivity {

	List<String> NotaList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ver);
		
		//--Consulta SQL (Todos los Usuarios)--//
		Sqlite user_db=new Sqlite(this, "DBUsuario", null, 1);
		SQLiteDatabase db=user_db.getWritableDatabase();
		Cursor c=db.rawQuery("SELECT * FROM notas", null);
		Notas n = new Notas();
		if(c.moveToFirst()){
			do{
				n.setId(c.getString(0));
				n.setTitulo(c.getString(1));
				n.setContenido(c.getString(2));
				String msg=n.getId()+" "+n.getTitulo()+" "+n.getContenido();
				String tag="Datos";
				Log.v(tag, msg);
				//Agregando la Nota a la lista
				NotaList.add(msg);
			}while(c.moveToNext());
		}
		final ListView listview=(ListView)findViewById(R.id.listaNotas);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, NotaList);
		listview.setAdapter(adapter);
		db.close();
	}
		
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ver, menu);
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
