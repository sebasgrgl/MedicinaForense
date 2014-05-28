package com.asomef.medicinaforense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AutopsyActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_autopsies);
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

	public void goCheckList1 (View view) {
		Intent openChecklist1 = new Intent(this, CheckListActivityBefore.class);
		openChecklist1.putExtra("id_autopsy_type", "1");
		startActivity(openChecklist1);	
	}
	
	public void goCheckList2 (View view) {
		Intent openChecklist2 = new Intent(this, CheckListActivityBefore.class);
		openChecklist2.putExtra("id_autopsy_type", "2");
		startActivity(openChecklist2);	
	}
	public void goCheckList3 (View view) {
		Intent openChecklist3 = new Intent(this, CheckListActivityBefore.class);
		openChecklist3.putExtra("id_autopsy_type", "3");
		startActivity(openChecklist3);	
	}
	public void goCheckList4 (View view) {
		Intent openChecklist4 = new Intent(this, CheckListActivityBefore.class);
		openChecklist4.putExtra("id_autopsy_type", "4");
		startActivity(openChecklist4);	
	}
	public void goCheckList5 (View view) {
		Intent openChecklist5 = new Intent(this, CheckListActivityBefore.class);
		openChecklist5.putExtra("id_autopsy_type", "5");
		startActivity(openChecklist5);	
	}
	public void goCheckList6 (View view) {
		Intent openChecklist6 = new Intent(this, CheckListActivityBefore.class);
		openChecklist6.putExtra("id_autopsy_type", "6");
		startActivity(openChecklist6);	
	}
	public void goCheckList7 (View view) {
		Intent openChecklist7 = new Intent(this, CheckListActivityBefore.class);
		openChecklist7.putExtra("id_autopsy_type", "7");
		startActivity(openChecklist7);	
	}
	
}
