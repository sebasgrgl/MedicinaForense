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

public class CheckListActivityAfter extends Activity {

	public int id_autopsy_after;
	ArrayList<CheckLists> activityList_after;
	CheckLists list_check_after;

	MyCustomAdapter dataAdapter = null;
	private AlertDialog.Builder alert;
	Button b1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_list_after);
		alert = new AlertDialog.Builder(CheckListActivityAfter.this);
		alert.setTitle("Alerta");
		alert.setMessage("Debes completar todas las tareas para continuar");
		alert.setNegativeButton("De acuerdo", new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				
			}
		});
				
		b1 = (Button) findViewById(R.id.findSelectedAfter);
		b1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// it was the 1st button

				StringBuffer responseText = new StringBuffer();
				responseText.append("The following were selected...\n");

				int allchecked=0;
				ArrayList<CheckLists> activityList_after = dataAdapter.activityList_after;
				for(int i=0;i<activityList_after.size();i++){
					CheckLists list_check_after = activityList_after.get(i);
					if(list_check_after.isSelected()){
						allchecked=allchecked+1;
						responseText.append("\n" + list_check_after.getName());
					}


				}
				if(allchecked==activityList_after.size()){

					Intent checklistafter = new Intent(CheckListActivityAfter.this, FinishCheckListsActivity.class);
					startActivity(checklistafter);	

				}else{alert.show();}


				
			}
		});
		id_autopsy_after = getIntent().getExtras().getInt("id_autopsy_during_samples");
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

		switch(id_autopsy_after) {
		case 1: 
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional y copia para su archivo).",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envié las muestras a la sede de Medicina Legal mas cercana con Cadena de Custodia individual y solicitud del examen requerido.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia en el protocolo del destino del cadáver.",false);
			activityList_after.add(list_check_after);
			break;
		case 2: 
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional, copia para su archivo)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envíe las muestras a la sede de Medicina Legal más cercana con Cadena de Custodia individual y solicitud del examen requerido",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia en el protocolo del destino del cadáver",false);
			activityList_after.add(list_check_after);
			break;
		case 3: 
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","No entregue el cuerpo antes de consultar una segunda opinión forense (llame a Medicina legal)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional, copia para su archivo)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envié las muestras a la sede de Medicina Legal más cercana con Cadena de Custodia individual y solicitud del examen requerido.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia del protocolo del destino del cadáver",false);
			activityList_after.add(list_check_after);
			break;
		case 4: 
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","No entregue el cuerpo antes de consultar una segunda opinión forense (llame a Medicina legal)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional, copia para su archivo)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envié las muestras a la sede de Medicina Legal más cercana con Cadena de Custodia individual y solicitud del examen requerido.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia del protocolo del destino del cadáver",false);
			activityList_after.add(list_check_after);
			break;
		case 5:
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","No entregue el cuerpo antes de consultar una segunda opinión forense (llame a Medicina legal)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional, copia para su archivo)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envié las muestras a la sede de Medicina Legal más cercana con Cadena de Custodia individual y solicitud del examen requerido.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia del protocolo del destino del cadáver",false);
			activityList_after.add(list_check_after);
			break;
		case 6: 
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional, copia para su archivo)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envié las muestras a la sede de Medicina Legal más cercana con Cadena de Custodia individual y solicitud del examen requerido.",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia del protocolo del destino del cadáver",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Tome Muestras para estupefacientes",false);
			activityList_after.add(list_check_after);
			break;
		case 7: 
			//Array list of countries
			activityList_after = new ArrayList<CheckLists>();
			list_check_after = new CheckLists("","Tome muestras de las prendas para detección de acelerantes",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Tome muestras de sangre en tubo tapa roja para carboxihemoglobina",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Tome muestra para saturación de monóxido de carbono en sangre",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Tome muestra de sangre y orina para toxicología",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Tome muestras de histopatología (bordes de quemadura)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Refrigere las muestras biológicas inmediatamente después de tomadas, aún estando en la autopsia",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Elabore y remita el protocolo de autopsia lo más pronto posible (original y copia a la autoridad, copia para la seccional, copia para su archivo)",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Envié las muestras a la sede de medicina legal más cercanas con cadena de custodia individual y solicitud del examen requerido",false);
			activityList_after.add(list_check_after);
			list_check_after = new CheckLists("","Deje constancia en el protocolo del destino del cadáver.",false);
			activityList_after.add(list_check_after);
			break;
		default: 

			break;
		}
		//Array list of countries


		//create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this,
				R.layout.info_country_after, activityList_after);
		ListView listView = (ListView) findViewById(R.id.listView_after);
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

		private ArrayList<CheckLists> activityList_after;

		public MyCustomAdapter(Context context, int textViewResourceId, 
				ArrayList<CheckLists> countryList) {
			super(context, textViewResourceId, countryList);
			this.activityList_after = new ArrayList<CheckLists>();
			this.activityList_after.addAll(countryList);
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
				convertView = vi.inflate(R.layout.info_country_after, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code_after);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox_after);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						CheckLists list_check_after = (CheckLists) cb.getTag();  
						
						list_check_after.setSelected(cb.isChecked());
					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			CheckLists list_check_after = activityList_after.get(position);
			holder.code.setText(list_check_after.getCode());
			holder.name.setText(list_check_after.getName());
			holder.name.setChecked(list_check_after.isSelected());
			holder.name.setTag(list_check_after);

			return convertView;

		}
	}
}


