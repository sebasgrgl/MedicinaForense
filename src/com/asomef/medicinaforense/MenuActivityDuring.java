package com.asomef.medicinaforense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MenuActivityDuring extends Activity {

	public int id_autopsy_menu;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		id_autopsy_menu = getIntent().getExtras().getInt("id_autopsy_during_before");
		if(id_autopsy_menu==4){
			setContentView(R.layout.activity_menu_activity_during_4);
		}
		else if(id_autopsy_menu==5){
			setContentView(R.layout.activity_menu_activity_during_5);
		}
		else if(id_autopsy_menu==6){
			setContentView(R.layout.activity_menu_activity_during_6);
		}
		else if(id_autopsy_menu==7){
			setContentView(R.layout.activity_menu_activity_during_7);
		}
		
		
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
	public void goRecien (View view) {
		int user_selection=41;
		Intent openRecienChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openRecienChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openRecienChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openRecienChecklist);	
	}
	public void goLactante (View view) {
		int user_selection=42;
		Intent openLactanteChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openLactanteChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openLactanteChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openLactanteChecklist);	
	}
	public void goEscolar (View view) {
		int user_selection=43;
		Intent openEscolarChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openEscolarChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openEscolarChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openEscolarChecklist);	
	}
	
	public void goDriver (View view) {
		int user_selection=51;
		Intent openDriverChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openDriverChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openDriverChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openDriverChecklist);	
	}
	public void goPedestrian (View view) {
		int user_selection=52;
		Intent openPedestrianChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openPedestrianChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openPedestrianChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openPedestrianChecklist);	
	}
	
	public void goCompression (View view) {
		int user_selection=61;
		Intent openCompressionChecklist = new Intent(this, AsphyxiaActivity.class);
		openCompressionChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openCompressionChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openCompressionChecklist);	
	}
	public void goRestriction (View view) {
		int user_selection=62;
		Intent openRestrictionChecklist = new Intent(this, AsphyxiaActivity.class);
		openRestrictionChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openRestrictionChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openRestrictionChecklist);	
	}
	public void goIntoxication (View view) {
		int user_selection=63;
		Intent openIntoxicationChecklist = new Intent(this, AsphyxiaActivity.class);
		openIntoxicationChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openIntoxicationChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openIntoxicationChecklist);	
	}
	public void goInmersion (View view) {
		int user_selection=64;
		Intent openInmersionChecklist = new Intent(this, AsphyxiaActivity.class);
		openInmersionChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openInmersionChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openInmersionChecklist);	
	}
	public void goHumidity (View view) {
		int user_selection=71;
		Intent openHumidityChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openHumidityChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openHumidityChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openHumidityChecklist);	
	}
	public void goDry (View view) {
		int user_selection=72;
		Intent openDryChecklist = new Intent(this, CheckListActivityDuringExternal.class);
		openDryChecklist.putExtra("id_autopsy_during_before", id_autopsy_menu);
		openDryChecklist.putExtra("id_user_selection", user_selection);
		startActivity(openDryChecklist);	
	}


	
        

}
