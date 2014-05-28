package com.asomef.medicinaforense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinishCheckListsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finish_check_lists);
	}

	public void goHome (View view) {
		Intent openHome = new Intent(this, Menu_HomeActivity.class);
		startActivity(openHome);	
	}
	public void goAutopsies (View view) {
		Intent openAutopsies = new Intent(this, AutopsyActivity.class);
		startActivity(openAutopsies);	
	}

}
