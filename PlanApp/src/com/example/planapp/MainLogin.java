package com.example.planapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainLogin extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main_login);
	    // TODO Auto-generated method stub
	    
	      // Capturamos los objetos gr�ficos que vamos a usar
	    Button ButtonIngresar= (Button) findViewById(R.id.ButtonIngresar);
	    Button ButtonRegistrar = (Button) findViewById(R.id.ButtonRegistrar);
	    
	 // Fijamos un evento onclick para el button ingresar, cada vez que
	 // lo pulsemos se llamar� a este m�todo (que abrir� una actividad)
	    
	    ButtonIngresar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainLogin.this, MainGenPanorama.class);
				
				//obtener los parametros de user y pass

				startActivity(intent);				
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
