package com.example.glock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//New
import android.content.Intent;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class InsertarActivity extends ActionBarActivity {

	String[] datos; //Para recibir la información
	TextView titulo, contenido, edo; //Para mostrar en pantalla

	Button volver=(Button)findViewById(R.id.volver);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar);
		
		//--Boton Volver--//
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent button_volver = new Intent (InsertarActivity.this, MainActivity.class);
                startActivity(button_volver);
            }
        });
		
		//--Recibir parametro--//
		titulo=(TextView)findViewById(R.id.mostrarTitulo);
		edo=(TextView)findViewById(R.id.mostrarEdo);
		
		//Obtengo la información de la actividad anterior y se la asigno a la variable info
		Intent info=getIntent();
		datos=info.getStringArrayExtra(AgregarActivity.ACT_INFO);
		
		//Muestreo la información en la interfaz
		titulo.setText(datos[0]);
		contenido.setText(datos[0]);
		
		//Abrimos la Base de datos
		Sqlite user_db=new Sqlite(this, "DBUsuario", null, 1);
		SQLiteDatabase db=user_db.getWritableDatabase();
		db.execSQL("INSERT INTO notas (titulo, contenido) VALUES ('"+datos[0]+"', '"+datos[1]+"')");
		db.close();
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertar, menu);
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
