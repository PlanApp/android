package com.example.planapp;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainGenPanorama extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_genpanorama);
	    // TODO Auto-generated method stub
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_inicio, menu);
        return true;
	}
}
