package com.asomef.medicinaforense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PhorensicClinicActivity extends Activity {

	public static String lesiones_personales = "Lesiones Personales";
	public static String delito_sexual = "Delito Sexual";
	public static String edad_clinica = "Edad Clinica";
	public static String embriaguez = "Embriaguez";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phorensic_clinic);
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
	
	public void goPersonalInjuries(View view){
		Intent openList1 = new Intent(this, FirstCheckListActivity.class);
		openList1.putExtra("selectedValue",lesiones_personales);
		startActivity(openList1);
		
	}
	public void goDrunk(View view){
		Intent openList2 = new Intent(this, FirstCheckListActivity.class);
		openList2.putExtra("selectedValue",embriaguez);
		startActivity(openList2);
		
	}
	public void goSexual(View view){
		Intent openList3 = new Intent(this, FirstCheckListActivity.class);
		openList3.putExtra("selectedValue",delito_sexual);
		startActivity(openList3);
		
	}
	public void goClinicAge(View view){
		Intent openList4 = new Intent(this, FirstCheckListActivity.class);
		openList4.putExtra("selectedValue",edad_clinica);
		startActivity(openList4);
		
	}

}