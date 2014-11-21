package com.example.planapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainGenPanorama extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_genpanorama);
	    // TODO Auto-generated method stub
	    
	    Button ButtonGenerar= (Button) findViewById(R.id.buttongenerar);
	    
	    ButtonGenerar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainGenPanorama.this, MainGenerarHoy.class);
				
				//obtener los parametros de user y pass

				startActivity(intent);				
			}
	    	
	    });
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_inicio, menu);
        return true;
	}
}
