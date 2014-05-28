package com.asomef.medicinaforense;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Menu_HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.autopsy, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_Home:
	           	Intent intent = new Intent(this, Menu_HomeActivity.class);
	            startActivity(intent);

	        break;

	    default:
	        break;
	    }
		return false;
	}

	public void goPhorensicChecklist (View view) {
		Intent openPhorensicChecklist = new Intent(this, AutopsyActivity.class);
		startActivity(openPhorensicChecklist);	
	}
	public void goPhorensic (View view) {
		Intent openPhorensic = new Intent(this, PhorensicClinicActivity.class);
		startActivity(openPhorensic);	
	}
}
