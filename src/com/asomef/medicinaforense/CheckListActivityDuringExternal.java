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

public class CheckListActivityDuringExternal extends Activity {
	public int id_autopsy_during_external;
	public int id_autopsy_user_selection_external;
	ArrayList<CheckLists> activityList_during_external;
	CheckLists list_check_during_external;

	MyCustomAdapter dataAdapter = null;
	private AlertDialog.Builder alert;
	Button b1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_list_activity_during_external);
		alert = new AlertDialog.Builder(CheckListActivityDuringExternal.this);
		alert.setTitle("Alerta");
		alert.setMessage("Debes completar todas las tareas para continuar");
		alert.setNegativeButton("De acuerdo", new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				
			}
		});
		
		b1 = (Button) findViewById(R.id.findSelectedDuringExternal);
		b1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// it was the 1st button

				StringBuffer responseText = new StringBuffer();
				responseText.append("The following were selected...\n");

				int allchecked=0;
				ArrayList<CheckLists> activityList_during_external = dataAdapter.activityList_during_external;
				for(int i=0;i<activityList_during_external.size();i++){
					CheckLists list_check_during_external = activityList_during_external.get(i);
					if(list_check_during_external.isSelected()){
						allchecked=allchecked+1;
						responseText.append("\n" + list_check_during_external.getName());
					}


				}
				if(allchecked==activityList_during_external.size()){

					Intent checklistduringexternal = new Intent(CheckListActivityDuringExternal.this, CheckListActivityDuringInternal.class);
					checklistduringexternal.putExtra("id_autopsy_during_external", id_autopsy_during_external);
					checklistduringexternal.putExtra("id_autopsy_user_selection_external", id_autopsy_user_selection_external);
					startActivity(checklistduringexternal);	

				}else{alert.show();}


				/*Toast.makeText(getApplicationContext(),
	    		      responseText, Toast.LENGTH_LONG).show();*/
			}
		});
		id_autopsy_during_external = getIntent().getExtras().getInt("id_autopsy_during_before");
		id_autopsy_user_selection_external= getIntent().getExtras().getInt("id_user_selection");
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

		switch(id_autopsy_during_external) {
		case 1: 
			//Arma de fuego
			activityList_during_external = new ArrayList<CheckLists>();
			list_check_during_external = new CheckLists("","Identifique y dibuje todos los orificios encontrados en el cuerpo.",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Verifique presencia de ahumamiento y tatuaje.",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Describa por cada impacto: orificio de entrada y orificio de salida.",false);
			activityList_during_external.add(list_check_during_external);
			break;
		case 2: 
			//Arma blanca
			activityList_during_external = new ArrayList<CheckLists>();
			list_check_during_external = new CheckLists("","Busque evidencia traza (pelos en las manos o en prendas de vestir)",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Verifique la correspondencia de desgarros en prendas con las heridas",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Realice una detallada descripción de las heridas: medidas, distancias, bordes, vitalidad. Use el formato de autopsia forense.",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Identifique heridas de defensa en manos, antebrazos, pies, piernas.",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Agrupe las heridas por áreas en casos de múltiples lesiones. (overkill)",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Documente todas las heridas con dibujos y fotografías (Uso obligatorio del testigo métrico)",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Si es del caso, realice el examen para delito sexual.",false);
			activityList_during_external.add(list_check_during_external);
			break;
		case 3: 
			//Adultos
			activityList_during_external = new ArrayList<CheckLists>();
			list_check_during_external = new CheckLists("","Verifique signos de trauma (asfixia).",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Revise áreas de pliegues (senos, ingles, axilas).",false);
			activityList_during_external.add(list_check_during_external);
			list_check_during_external = new CheckLists("","Revise cuidadosamente las prendas",false);
			activityList_during_external.add(list_check_during_external);
			break;
		case 4: 
			switch(id_autopsy_user_selection_external){
			case 41:
				//Recien Nacidos
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique los elementos de identificación y realice revisión del estado, posición, marca y talla de las prendas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Registre el grado de hidratación, desarrollo muscular, espesor del tejido adiposo.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique signos de trauma, lesiones patrón y deformidades, revise cuero cabelludo y uñas.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Busque petéquias y hemorragias conjuntivales (Signos de asfixia)",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Siempre tome medidas antropométricas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Mida las fontanelas, distancia intercantica interna  y externa, filtrum, verifique la simetría de los 1/3 de la cara e implantación de las orejas.",false);
				activityList_during_external.add(list_check_during_external);
				break;
			case 42:
				//Lactancia
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique los elementos de identificación y realice revisión del estado, posición, marca y talla de las prendas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Registre el grado de hidratación, desarrollo muscular, espesor del tejido adiposo.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique signos de trauma, lesiones patrón y deformidades, revise cuero cabelludo y uñas.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Busque petéquias y hemorragias conjuntivales (Signos de asfixia)",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Revise la implantación del cuero cabelludo, presencia de pediculosis o escabiosis",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Mida las fontanelas.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Realice rinoscopia y otoscopia, verifique la presencia o no de lesiones patrón. ",false);
				activityList_during_external.add(list_check_during_external);
				break;
			case 43:
				//Preescolares y escolares
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique los elementos de identificación y realice revisión del estado, posición, marca y talla de las prendas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Registre el grado de hidratación, desarrollo muscular, espesor del tejido adiposo.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique signos de trauma, lesiones patrón y deformidades, revise cuero cabelludo y uñas.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Busque petéquias y hemorragias conjuntivales (Signos de asfixia)",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la presencia de lesiones patrón y deformidades.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Realice carta dental cuando no se conoce la edad",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Revise los orificios corporales (Signos de abuso sexual)",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la presencia de lesiones autoinfligidas y de lesiones patrón",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Realice carta dental cuando no se conoce la edad",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique signos de maduración (Utilice escala de Tanner) revise orificios corporales (signos de abuso sexual)",false);
				activityList_during_external.add(list_check_during_external);
				break;
			default:
				
				break;
				
			}
			
			break;
		case 5: 
			switch(id_autopsy_user_selection_external){
			case 51:
				//Conductores
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Describa con detalle las prendas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Dibuje las lesiones encontradas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Busque  evidencia  traza  en  prendas, cuerpo, o fracturas abiertas.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during_external.add(list_check_during_external);
				break;
			case 52:
				//Peatones
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Describa con detalle las prendas",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Recoja las prendas con marcas patrón o cualquier evidencia traza",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Dibuje  los  patrones  de  lesiones  para determinar las fases del atropellamiento",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Las  fracturas  de  MMII  se  miden  al talón",false);
				activityList_during_external.add(list_check_during_external);
				break;
			default:
				
				break;
			}
			break;
		case 6: 
			switch(id_autopsy_user_selection_external){
			case 61:
				//Array list of countries
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during_external.add(list_check_during_external);
				break;
			case 62:
				//Array list of countries
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during_external.add(list_check_during_external);
				break;
			case 63:
				//Array list of countries
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during_external.add(list_check_during_external);
				break;
			case 64:
				//Array list of countries
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Verifique que el acta de inspección esté completa",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Verifique la prueba de absorción atómica.",false);
				activityList_during_external.add(list_check_during_external);
				break;
			default:
				
				break;
				
			}
			break;
		case 7:
			switch(id_autopsy_user_selection_external){
			//calor húmedo
			case 71:
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Defina el grado de compromiso de lesiones según escala de Wilson y Regla de “Nueves”." ,false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Defina porcentaje de área comprometida; sospeche otras causas de muerte.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique áreas quemadas cubiertas por prendas de vestir.",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Determine en los posible el modo de contacto con el la líquido ardiente (sumergido, salpicado, vertido)",false);
				activityList_during_external.add(list_check_during_external);
				break;
				//calor seco
			case 72:
				activityList_during_external = new ArrayList<CheckLists>();
				list_check_during_external = new CheckLists("","Defina el grado de compromiso de lesiones según escala de Wilson y Regla de “Nueves”." ,false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Defina porcentaje de área comprometida; sospechar de otras causas de muerte",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique signos de sobrevida; pus, costra, tejido de granulación",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Realice diagrama de lesiones diferenciando grados de quemadura",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique áreas quemadas cubiertas por prendas de vestir",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Diferencie lesiones antemortem de postmortem",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Observe, huela y registre si percibe sustancias acelerantes de la combustión",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique posibles lesiones desorientadoras (posición pugilística, prendas de vestir alrededor del cuello)",false);
				activityList_during_external.add(list_check_during_external);
				list_check_during_external = new CheckLists("","Identifique otras posibles causas de muerte (PAF, ACP, etc.)",false);
				activityList_during_external.add(list_check_during_external);
				break;
			
			}
			
			break;
		default: 

			break;
		}
		//Array list of countries


		//create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this,
				R.layout.info_country_during_externaly, activityList_during_external);
		ListView listView = (ListView) findViewById(R.id.listView_duringExternal);
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

		private ArrayList<CheckLists> activityList_during_external;

		public MyCustomAdapter(Context context, int textViewResourceId, 
				ArrayList<CheckLists> countryList) {
			super(context, textViewResourceId, countryList);
			this.activityList_during_external = new ArrayList<CheckLists>();
			this.activityList_during_external.addAll(countryList);
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
				convertView = vi.inflate(R.layout.info_country_during_externaly, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code_during_external);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox_during_external);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						CheckLists list_check_during_external = (CheckLists) cb.getTag();  
						
						list_check_during_external.setSelected(cb.isChecked());
					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			CheckLists list_check_during_external = activityList_during_external.get(position);
			holder.code.setText(list_check_during_external.getCode());
			holder.name.setText(list_check_during_external.getName());
			holder.name.setChecked(list_check_during_external.isSelected());
			holder.name.setTag(list_check_during_external);

			return convertView;

		}
	}
}
