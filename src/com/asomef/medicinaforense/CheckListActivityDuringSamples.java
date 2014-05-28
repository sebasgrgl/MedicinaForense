package com.asomef.medicinaforense;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CheckListActivityDuringSamples extends Activity {
	public int id_autopsy_during_samples;
	ArrayList<CheckLists> activityList_during_samples;
	CheckLists list_check_during_samples;

	MyCustomAdapter dataAdapter = null;
	private AlertDialog.Builder alert;
	Button b1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_list_activity_during_samples);
		alert = new AlertDialog.Builder(CheckListActivityDuringSamples.this);
		alert.setTitle("Alerta");
		alert.setMessage("Debes completar todas las tareas para continuar");
		alert.setNegativeButton("De acuerdo", new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				
			}
		});
		
		b1 = (Button) findViewById(R.id.findSelectedDuringSamples);
		b1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// it was the 1st button

				StringBuffer responseText = new StringBuffer();
				responseText.append("The following were selected...\n");

				int allchecked=0;
				ArrayList<CheckLists> activityList_during_samples = dataAdapter.activityList_during_samples;
				for(int i=0;i<activityList_during_samples.size();i++){
					CheckLists list_check_during_samples = activityList_during_samples.get(i);
					if(list_check_during_samples.isSelected()){
						allchecked=allchecked+1;
						responseText.append("\n" + list_check_during_samples.getName());
					}


				}
				if(allchecked==activityList_during_samples.size()){

					Intent checklistduringsamples = new Intent(CheckListActivityDuringSamples.this, CheckListActivityAfter.class);
					checklistduringsamples.putExtra("id_autopsy_during_samples", id_autopsy_during_samples);
					startActivity(checklistduringsamples);	

				}else{alert.show();}


				/*Toast.makeText(getApplicationContext(),
	    		      responseText, Toast.LENGTH_LONG).show();*/
			}
		});
		id_autopsy_during_samples = getIntent().getExtras().getInt("id_autopsy_during");
		//Generate list View from ArrayList
		displayListView();
		
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
	
	private void displayListView() {

		switch(id_autopsy_during_samples) {
		case 1: 
			//Array list of countries
			activityList_during_samples = new ArrayList<CheckLists>();
			list_check_during_samples = new CheckLists("","En carga múltiple recupere la mayor cantidad de perdigones o postas y el pistón de potencia.",false);
			activityList_during_samples.add(list_check_during_samples);
			break;
		case 2: 
			//Array list of countries
			activityList_during_samples = new ArrayList<CheckLists>();
			list_check_during_samples = new CheckLists("","Tome sangre en tubo tapa lila para hemoclasificación y posible cotejo con muestras provenientes de la escena",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome sangre en dos tubos tapa gris: una para alcoholemia y otra para reserva",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome orina en contenedor plástico para estudio de estupefacientes.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestras de uñas de todos los dedos de las manos en busca de evidencia traza.",false);
			activityList_during_samples.add(list_check_during_samples);
			break;
		case 3: 
			//Array list of countries
			activityList_during_samples = new ArrayList<CheckLists>();
			list_check_during_samples = new CheckLists("","Tome sangre en tubo tapa gris para alcoholemia.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome sangre en tubo tapa lila para hemoclasificación y/o genética.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome dos tubos tapa roja para otros tóxicos.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestra de orina o lavado vesical para estupefacientes.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestra de humor vítreo de cada ojo en tubo tapa roja para glucosa y electrolitos.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestras de hígado (200gr), riñon (una mitad sin capsula), y contenido gástrico (60 cc) para estudio toxicológico.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestras histopatológicas (2x2x0,5 cm) de cerebro, pulmones, corazón, riñones, hígado, bazo, páncreas, piel, musculo y demás estructuras corporales.",false);
			activityList_during_samples.add(list_check_during_samples);
			break;
		case 4: 
			//Array list of countries
			activityList_during_samples = new ArrayList<CheckLists>();
			list_check_during_samples = new CheckLists("","Tome muestras de pelo y uñas en sospecha de intoxicación por metales pesados.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestra con escobillón (oral y genital si sospecha abuso sexual y de mordeduras).",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome sangre en tubo tapa gris para alcoholemia en adolescentes y escolares.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome sangre en tubo tapa lila para hemoclasificación y/o genética.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome dos tubos tapa roja para otros tóxicos.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestra de orina o lavado vesical para estupefacientes.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestra de contenido gástrico para tóxicos.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome muestra de humor vítreo de cada ojo en tubo tapa roja para glucosa y electrolitos.",false);
			activityList_during_samples.add(list_check_during_samples);
			break;
		case 5: 
			//Array list of countries
			activityList_during_samples = new ArrayList<CheckLists>();
			list_check_during_samples = new CheckLists("","Tome sangre en tubo tapa lila para hemoclasificación y posible cotejo.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome sangre en dos tubos tapa gris: una para alcoholemia y otra para reserva",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Tome orina en contenedor plástico para estudio de estupefacientes.",false);
			activityList_during_samples.add(list_check_during_samples);
			list_check_during_samples = new CheckLists("","Recolecte cabellos para comparación con cabellos adheridos al vehículo (carro fantasma )",false);
			activityList_during_samples.add(list_check_during_samples);
			break;
		case 6: 

			break;
		case 7:
			
			break;
		default: 

			break;
		}
		//Array list of countries


		//create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this,
				R.layout.info_country_during_samples, activityList_during_samples);
		ListView listView = (ListView) findViewById(R.id.listView_duringsamples);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);


		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				CheckLists list_check = (CheckLists) parent.getItemAtPosition(position);
				
			}
		});

	}
	private class MyCustomAdapter extends ArrayAdapter<CheckLists> {

		private ArrayList<CheckLists> activityList_during_samples;

		public MyCustomAdapter(Context context, int textViewResourceId, 
				ArrayList<CheckLists> countryList) {
			super(context, textViewResourceId, countryList);
			this.activityList_during_samples = new ArrayList<CheckLists>();
			this.activityList_during_samples.addAll(countryList);
		}



		private class ViewHolder {
			TextView code;
			CheckBox name;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			
			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater)getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.info_country_during_samples, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code_during_samples);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox_during_samples);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						CheckLists list_check_during_samples = (CheckLists) cb.getTag();  
						
						list_check_during_samples.setSelected(cb.isChecked());
					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			CheckLists list_check_during_samples = activityList_during_samples.get(position);
			holder.code.setText(list_check_during_samples.getCode());
			holder.name.setText(list_check_during_samples.getName());
			holder.name.setChecked(list_check_during_samples.isSelected());
			holder.name.setTag(list_check_during_samples);

			return convertView;

		}
	}
}
