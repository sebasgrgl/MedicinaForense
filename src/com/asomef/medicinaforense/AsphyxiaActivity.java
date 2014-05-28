package com.asomef.medicinaforense;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class AsphyxiaActivity extends Activity {

	public int id_autopsy_during_asphyxia;
	public int id_autopsy_user_selection_asphyxia;
	ArrayList<CheckLists> activityList_during_asphyxia;
	CheckLists list_check_during_asphyxia;

	MyCustomAdapter dataAdapter = null;
	private AlertDialog.Builder alert;
	Button b1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asphyxia);
		alert = new AlertDialog.Builder(AsphyxiaActivity.this);
		alert.setTitle("Alerta");
		alert.setMessage("Debes completar todas las tareas para continuar");
		alert.setNegativeButton("De acuerdo", new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				
			}
		});
		
		b1 = (Button) findViewById(R.id.findSelectedAsphyxia);
		b1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// it was the 1st button

				StringBuffer responseText = new StringBuffer();
				responseText.append("The following were selected...\n");

				int allchecked=0;
				ArrayList<CheckLists> activityList_during_asphyxia = dataAdapter.activityList_during_asphyxia;
				for(int i=0;i<activityList_during_asphyxia.size();i++){
					CheckLists list_check_during_external = activityList_during_asphyxia.get(i);
					if(list_check_during_external.isSelected()){
						allchecked=allchecked+1;
						responseText.append("\n" + list_check_during_external.getName());
					}


				}
				if(allchecked==activityList_during_asphyxia.size()){

					Intent checklistduringasphyxia = new Intent(AsphyxiaActivity.this, CheckListActivityAfter.class);
					checklistduringasphyxia.putExtra("id_autopsy_during_samples", id_autopsy_during_asphyxia);
					startActivity(checklistduringasphyxia);	

				}else{alert.show();}


				/*Toast.makeText(getApplicationContext(),
	    		      responseText, Toast.LENGTH_LONG).show();*/
			}
		});
		id_autopsy_during_asphyxia = getIntent().getExtras().getInt("id_autopsy_during_before");
		id_autopsy_user_selection_asphyxia= getIntent().getExtras().getInt("id_user_selection");
		//Generate list View from ArrayList
		displayListView();
		
	}
	
	private void displayListView() {

		switch(id_autopsy_during_asphyxia) {
		case 1: 
			break;
		case 2: 
			
			break;
		case 3: 
			
			break;
		case 4: 

			break;
		case 5: 
			
			break;
		case 6: 
			switch(id_autopsy_user_selection_asphyxia){
			case 61:
				//Array list of countries
				activityList_during_asphyxia = new ArrayList<CheckLists>();
				list_check_during_asphyxia = new CheckLists("","Registre signos generales de asfixia.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Busque estigmas de lucha (pelos, abrasiones, mordeduras)",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Registre fotográficamente todas las lesiones evidenciadas con testigo métrico.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa características del fluido sanguíneo",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Revise posición e integridad del lazo o soga (Asfixia por ligadura).",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa detalladamente el surco de presión.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Determine si el surco es vital o no vital",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Realice siempre técnica de disección de cuello anterior y según el caso técnica de disección de cuello posterior",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				break;
			case 62:
				activityList_during_asphyxia = new ArrayList<CheckLists>();
				list_check_during_asphyxia = new CheckLists("","Registre signos generales de asfixia.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Busque estigmas de lucha (pelos, abrasiones, mordeduras)",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Registre fotográficamente todas las lesiones evidenciadas con testigo métrico.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa características del fluido sanguíneo",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa la presencia de petequias en conjuntivas y escleras.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Verifique signos de presión sobre la cara.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Determine si hubo obstrucción de la vía aérea",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				break;
			case 63:
				activityList_during_asphyxia = new ArrayList<CheckLists>();
				list_check_during_asphyxia = new CheckLists("","Registre signos generales de asfixia.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Busque estigmas de lucha (pelos, abrasiones, mordeduras)",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Registre fotográficamente todas las lesiones evidenciadas con testigo métrico.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa características del fluido sanguíneo",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Observe la presencia de livideces rojizas (monóxido de carbono)",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Verifique si hay necrosis de los núcleos basales del cerebro.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa la presencia de edema laríngeo",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				break;
			case 64:
				activityList_during_asphyxia = new ArrayList<CheckLists>();
				list_check_during_asphyxia = new CheckLists("","Registre signos generales de asfixia.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Busque estigmas de lucha (pelos, abrasiones, mordeduras)",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Registre fotográficamente todas las lesiones evidenciadas con testigo métrico.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa características del fluido sanguíneo",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Describa lesiones en regiones prominentes: codos, arco zigomático, talones, rodillas.",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Verifique hemorragias periósticas en hueso temporal",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				list_check_during_asphyxia = new CheckLists("","Determine si hay dilatación de la cámara gástrica",false);
				activityList_during_asphyxia.add(list_check_during_asphyxia);
				break;
			default:
				
				break;
				
			}
			break;
		case 7:
			
			break;
		default: 

			break;
		}
		//Array list of countries


		//create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this,
				R.layout.info_country_asphyxia, activityList_during_asphyxia);
		ListView listView = (ListView) findViewById(R.id.listView_Asphyxia);
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

		private ArrayList<CheckLists> activityList_during_asphyxia;

		public MyCustomAdapter(Context context, int textViewResourceId, 
				ArrayList<CheckLists> countryList) {
			super(context, textViewResourceId, countryList);
			this.activityList_during_asphyxia = new ArrayList<CheckLists>();
			this.activityList_during_asphyxia.addAll(countryList);
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
				convertView = vi.inflate(R.layout.info_country_asphyxia, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code_asphyxia);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox_asphyxia);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						CheckLists list_check_during_asphyxia = (CheckLists) cb.getTag();  
						
						list_check_during_asphyxia.setSelected(cb.isChecked());
					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			CheckLists list_check_during_external = activityList_during_asphyxia.get(position);
			holder.code.setText(list_check_during_external.getCode());
			holder.name.setText(list_check_during_external.getName());
			holder.name.setChecked(list_check_during_external.isSelected());
			holder.name.setTag(list_check_during_external);

			return convertView;

		}
	}
}
