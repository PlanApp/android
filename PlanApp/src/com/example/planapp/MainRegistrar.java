package com.example.planapp;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainRegistrar extends Activity {

	//
	EditText nombre, correo, pass, passconfirmar, fecha;
	RadioGroup radioGender;
	
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
				correo= (EditText)  findViewById(R.id.nombre);
				correo= (EditText)  findViewById(R.id.correo);
				pass = (EditText)  findViewById(R.id.pass);
				passconfirmar= (EditText)  findViewById(R.id.passconfirmar);
				fecha= (EditText)  findViewById(R.id.fecha);
				int selectedId = radioGender.getCheckedRadioButtonId();
				
				RadioButton  radioSexButton = (RadioButton) findViewById(selectedId);
				Log.v("Main Registrar","id_radio"+ radioSexButton.getText());
			}
	    });
	}

}
