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

public class CheckListActivityDuringInternal extends Activity {
	public int id_autopsy_during;
	public int id_autopsy_userid_from_external;
	ArrayList<CheckLists> activityList_during;
	CheckLists list_check_during;

	MyCustomAdapter dataAdapter = null;
	private AlertDialog.Builder alert;
	Button b1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_list_during);
		alert = new AlertDialog.Builder(CheckListActivityDuringInternal.this);
		alert.setTitle("Alerta");
		alert.setMessage("Debes completar todas las tareas para continuar");
		alert.setNegativeButton("De acuerdo", new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				
			}
		});
		
		b1 = (Button) findViewById(R.id.findSelectedDuring);
		b1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// it was the 1st button

				StringBuffer responseText = new StringBuffer();
				responseText.append("The following were selected...\n");

				int allchecked=0;
				ArrayList<CheckLists> activityList_during = dataAdapter.activityList_during;
				for(int i=0;i<activityList_during.size();i++){
					CheckLists list_check_during = activityList_during.get(i);
					if(list_check_during.isSelected()){
						allchecked=allchecked+1;
						responseText.append("\n" + list_check_during.getName());
					}


				}
				if(allchecked==activityList_during.size()){
					
					if((id_autopsy_during==1)||(id_autopsy_during==2)||(id_autopsy_during==3)||(id_autopsy_during==4)||(id_autopsy_during==5)){
						Intent checklistduring = new Intent(CheckListActivityDuringInternal.this, CheckListActivityDuringSamples.class);
						checklistduring.putExtra("id_autopsy_during", id_autopsy_during);
						startActivity(checklistduring);	
					}
					else{
						Intent checklistduring = new Intent(CheckListActivityDuringInternal.this, CheckListActivityAfter.class);
						checklistduring.putExtra("id_autopsy_during_samples", id_autopsy_during);
						startActivity(checklistduring);	
					}

					

				}else{alert.show();}


				/*Toast.makeText(getApplicationContext(),
	    		      responseText, Toast.LENGTH_LONG).show();*/
			}
		});
		id_autopsy_during = getIntent().getExtras().getInt("id_autopsy_during_external");
		id_autopsy_userid_from_external= getIntent().getExtras().getInt("id_autopsy_user_selection_external");
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

		switch(id_autopsy_during) {
		case 1: 
			//Array list of countries
			activityList_during = new ArrayList<CheckLists>();
			list_check_during = new CheckLists("","Verifique las lesiones causadas por cada proyectil",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Verifique la trayectoria para cada proyectil.",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","En ausencia de orificio de salida siempre recupere el proyectil.",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Examine todos los órganos, aún los no lesionados. ",false);
			activityList_during.add(list_check_during);
			
			break;
		case 2: 
			//Array list of countries
			activityList_during = new ArrayList<CheckLists>();
			list_check_during = new CheckLists("","Describa para cada herida o grupo de heridas las estructuras comprometidas. ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Cuantifique el sangrado en cada cavidad (expresarlo en cc o ml ) ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Busque, diseque y documente el vaso lesionado causante de la hemorragia. ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Realice disección de cuello anterior y/o posterior si hay heridas en esas zonas. ",false);
			activityList_during.add(list_check_during);
			
			break;
		case 3: 
			//Array list of countries
			activityList_during = new ArrayList<CheckLists>();
			list_check_during = new CheckLists("","Siempre extraiga el bloque visceral completo. ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Explore detalladamente el corazón (mida el grosor de los ventrículos). ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Explore los tres vasos coronarios. ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Explore vasos pulmonares. ",false);
			activityList_during.add(list_check_during);
			list_check_during = new CheckLists("","Recuerde hacer disección de cuello posterior, si al termino de la autopsia no ha encontrado la causa de muerte",false);
			activityList_during.add(list_check_during);
			break;
			
		case 4: 
			switch(id_autopsy_userid_from_external){
			case 41: 
				//Recien Nacidos
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Examine el oído medio (hágalo retirando el peñasco del temporal), trompa de Eustaquio y coanas posteriores, timo." ,false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección en X posterior en todos los casos.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección en Y de cuello anterior para verificar obstrucción de vía aérea superior.  ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice levantamiento facial en caso de signos o sospecha de violencia en rostro. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recuerde hacer la disección en cuello posterior si no hay diagnóstico al terminar la autopsia. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Haga inspección in situ de las estructuras en búsqueda de malformaciones  ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Extraiga los ojos en caso de signos o sospecha de violencia (Niño zarandeado).",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique la presencia de testículos en bolsa escrotal. ",false);
				activityList_during.add(list_check_during);
				break;
			case 42: 
				//Lactantes
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Examine el oído medio (hágalo retirando el peñasco del temporal), trompa de Eustaquio y coanas posteriores, timo." ,false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección en X posterior en todos los casos.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección en Y de cuello anterior para verificar obstrucción de vía aérea superior.  ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice levantamiento facial en caso de signos o sospecha de violencia en rostro. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recuerde hacer la disección en cuello posterior si no hay diagnóstico al terminar la autopsia. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Haga inspección in situ de las estructuras en búsqueda de malformaciones. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice extracción de ojos (zarandeo) y revisión de arcos costales (sospecha de violencia). ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique la presencia de testículos en bolsa escrotal. ",false);
				activityList_during.add(list_check_during);
				break;
			case 43: 
				//preescolares y escolares
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Examine el oído medio (hágalo retirando el peñasco del temporal), trompa de Eustaquio y coanas posteriores, timo." ,false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección en X posterior en todos los casos.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección en Y de cuello anterior para verificar obstrucción de vía aérea superior.  ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice levantamiento facial en caso de signos o sospecha de violencia en rostro. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recuerde hacer la disección en cuello posterior si no hay diagnóstico al terminar la autopsia. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Determine alteraciones cardiovasculares",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice examen cuidadoso del bazo",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Realice disección cardiaca cuidadosa y detallada.",false);
				activityList_during.add(list_check_during);
				break;
			default: 

				break;
			
			}			
			break;
		case 5: 
			switch(id_autopsy_userid_from_external){
			case 51: 
				//conductor
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Valore la presencia de trauma craneofacial (realice descenso facial)",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("",". Realice disección de cuello posterior si se sospecha de trauma raquimedular cervical",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Describa lesiones relacionadas con el uso del cinturón de seguridad ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Valore posibles traumas con el timón.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Explore y documente todas las fracturas presentes ",false);
				activityList_during.add(list_check_during);
				break;
			case 52: 
				//peaton
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Identifique la presencia de golpe-contragolpe en el cráneo. ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Examine la presencia de contusiones no visibles en el examen externo ",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Busque evidencia traza en las heridas(pintura, grasa, vidrios)",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Explore y documente todas las fractúras presentes ",false);
				break;
			default: 

				break;
			
			}	
			break;
		case 6: 
			switch(id_autopsy_userid_from_external){
			case 61: 
				//Array list of countries
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during.add(list_check_during);
				break;
			case 62: 
				//Array list of countries
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during.add(list_check_during);
				break;
			case 63: 
				//Array list of countries
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during.add(list_check_during);
				break;
			case 64: 
				//Array list of countries
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during.add(list_check_during);
				break;
			default: 

				break;
			
			}	
			break;
		case 7:
			switch(id_autopsy_userid_from_external){
			//Calor Húmedo
			case 71:
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Identifique la presencia de pulmón de choque" ,false);
				activityList_during.add(list_check_during);
				break;
			//Calor Seco
			case 72:
				activityList_during = new ArrayList<CheckLists>();
				list_check_during = new CheckLists("","Identifique el grado de exposición a altas temperaturas.",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Estudie cuidadosamente la via aérea (presencia de Hollín)",false);
				activityList_during.add(list_check_during);
				list_check_during = new CheckLists("","Identifique posibles lesiones desorientadoras (Fractura de cráneo, Hematoma subdural) ",false);
				activityList_during.add(list_check_during);
				break;
			}
			
			break;
		default: 

			break;
		}
		//Array list of countries

		
		//create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this,
				R.layout.info_country_during, activityList_during);
		ListView listView = (ListView) findViewById(R.id.listView_during);
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

		private ArrayList<CheckLists> activityList_during;

		public MyCustomAdapter(Context context, int textViewResourceId, 
				ArrayList<CheckLists> countryList) {
			super(context, textViewResourceId, countryList);
			this.activityList_during = new ArrayList<CheckLists>();
			this.activityList_during.addAll(countryList);
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
				convertView = vi.inflate(R.layout.info_country_during, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code_during);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox_during);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						CheckLists list_check_during = (CheckLists) cb.getTag();  
						
						list_check_during.setSelected(cb.isChecked());
					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			CheckLists list_check_during = activityList_during.get(position);
			holder.code.setText(list_check_during.getCode());
			holder.name.setText(list_check_during.getName());
			holder.name.setChecked(list_check_during.isSelected());
			holder.name.setTag(list_check_during);

			return convertView;

		}
	}
}

