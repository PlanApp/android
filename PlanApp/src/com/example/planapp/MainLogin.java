package com.example.planapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainLogin extends Activity {

	//Variables del campo
	EditText correo, pass;
	Usuario user = new Usuario();
	//String edo;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main_login);
	    // Capturamos los objetos graficos que vamos a usar
		Button ButtonIngresar= (Button) findViewById(R.id.ButtonIngresar);
		Button ButtonRegistrar = (Button) findViewById(R.id.ButtonRegistrar);
		// Fijamos un evento onclick para el button ingresar, cada vez que
		// lo pulsemos se llamara a este metodo (que abrira una actividad)
	    ButtonIngresar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				correo= (EditText)  findViewById(R.id.correo);
				pass = (EditText)  findViewById(R.id.pass);
				  //NUEVO THREAD PARA ENVIAR EL POST 
				  new Thread(new Runnable() {
				  	    public void run(){
				  	    	//LLAMO A LA FUNCION QUE ENVIA LOS DATOS
					   		//user = httpLogin(correo.getText().toString(), pass.getText().toString());
				  	    	Log.v("MainLogin", "Conectando con WebService");
				  	    	Conexion conn=new Conexion();
				  	    	user=conn.httpLogin(correo.getText().toString(), pass.getText().toString());
					   							   		
					   		//VEO LA RESPUESTA DE LA FUNCION DE LOGIN
							if(user.getEdo().toString().equals("ok")){
								//CAMBIA DE VISTA SI LOS DATOS SON CORRECTOS
								Intent ir_a = new Intent (MainLogin.this, MainGenPanorama.class);
								ir_a.putExtra("id", user.getID());
								ir_a.putExtra("mail", user.getMail());
								Log.d("MainLogin", "Va el intent");
								startActivity(ir_a);
							}
							else{
								//MENSAJE EN PANTALLA DE DATOS INCORRECTOS
								MainLogin.this.runOnUiThread(new Runnable() {
								    public void run() {
								        //Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show();
								    	Toast toast = Toast.makeText(MainLogin.this, "Datos incorrectos", Toast.LENGTH_SHORT);
									    toast.show();
								    }
								});
							}
				  	    }
				  	    
				  }).start();
			}			
	    });
	      
	    //ButtonRegistrar registrarmos al nuevo usuario
	    ButtonRegistrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(MainLogin.this, MainRegistrar.class);
				startActivity(intent);
			}
		});
	}	
}
