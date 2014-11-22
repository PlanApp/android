package com.example.planapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainRegistrar extends Activity {

	//
	EditText nombre, correo, pass, passconfirmar, fecha;
	RadioGroup radioGender;
	Usuario user = new Usuario();
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main_registrar);
	    
	    
	    // TODO Auto-generated method stub
	    //RadioGroup radioGender = (RadioGroup) findViewById(R.id.radioGender);
	    radioGender = (RadioGroup) findViewById(R.id.radioGender);
	    Button ButtonRegistrar= (Button) findViewById(R.id.BotonRegistrar);  
	    
	    //Registro
	    ButtonRegistrar.setOnClickListener(new OnClickListener(){	
			@Override
			public void onClick(View v) {
				//Capturar variables de formulario
				nombre= (EditText)  findViewById(R.id.nombre);
				correo= (EditText)  findViewById(R.id.correo);
				pass = (EditText)  findViewById(R.id.pass);
				passconfirmar= (EditText)  findViewById(R.id.passconfirmar);
				fecha= (EditText)  findViewById(R.id.fecha);
				int selectedId = radioGender.getCheckedRadioButtonId();
				
				RadioButton  radioSexButton = (RadioButton) findViewById(selectedId);
				final String sexo=radioSexButton.getText().toString();
				
				//Log.v("Main Registrar","id_radio :"+ radioSexButton.getText());
				
				//NUEVO THREAD PARA ENVIAR EL POST 
				 new Thread(new Runnable() {
				  	    public void run(){
				  	    	//LLAMO A LA FUNCION QUE ENVIA LOS DATOS
					   		//user = httpLogin(correo.getText().toString(), pass.getText().toString());
	
				  	    	Log.v("MainLogin", "Conectando con WebService");
				  	    	Conexion conn=new Conexion();
				  	    	user=conn.httpRegistro(correo.getText().toString(),  nombre.getText().toString(), pass.getText().toString(), fecha.getText().toString(), sexo);
					   							   		
					   		//VEO LA RESPUESTA DE LA FUNCION DE LOGIN
							if(user.getEdo().toString().equals("ok")){
								//CAMBIA DE VISTA SI LOS DATOS SON CORRECTOS
								Intent ir_a = new Intent (MainRegistrar.this, MainGenPanorama.class);
								ir_a.putExtra("id", user.getID());
								ir_a.putExtra("mail", user.getMail());
								Log.d("MainLogin", "Va el intent");
								startActivity(ir_a);
							}
							else{
								//MENSAJE EN PANTALLA DE DATOS INCORRECTOS
								MainRegistrar.this.runOnUiThread(new Runnable() {
								    public void run() {
								        //Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show();
								    	Toast toast = Toast.makeText(MainRegistrar.this, "Error", Toast.LENGTH_SHORT);
									    toast.show();
								    }
								});
							}
				  	    }
				  	    
				  }).start();
			}
	    });
	}

}
