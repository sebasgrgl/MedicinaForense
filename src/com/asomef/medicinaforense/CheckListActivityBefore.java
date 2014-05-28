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

public class CheckListActivityBefore extends Activity {

	public String id_autopsy_type;
	public int id_autopsy;
	ArrayList<CheckLists> activityList;
	CheckLists list_check;
	
	
	MyCustomAdapter dataAdapter = null;
	private AlertDialog.Builder alert;
    private Button btAbout;
	Button b1;
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_check_list);
	  
	  alert = new AlertDialog.Builder(CheckListActivityBefore.this);
	  alert.setTitle("Alerta");
      alert.setMessage("Debes completar todas las tareas para continuar");
      alert.setNegativeButton("De acuerdo", new DialogInterface.OnClickListener() {
          public void onClick (DialogInterface dialog, int id) {
              
          }
      });

            
	  b1 = (Button) findViewById(R.id.findSelected);
      b1.setOnClickListener(new OnClickListener(){
    	  
    	  public void onClick(View v) {
		      // it was the 1st button
    		     		  
    		  StringBuffer responseText = new StringBuffer();
    		    responseText.append("The following were selected...\n");
    		 
    		    int allchecked=0;
    		    ArrayList<CheckLists> activityList = dataAdapter.activityList;
    		    for(int i=0;i<activityList.size();i++){
    		    	CheckLists list_check = activityList.get(i);
    		     if(list_check.isSelected()){
    		    	 allchecked=allchecked+1;
    		      responseText.append("\n" + list_check.getName());
    		     }
    		     
     		    
    		    }
    		    if(allchecked==activityList.size()){
    		    	
    		    	if((id_autopsy==1)||(id_autopsy==2)||(id_autopsy==3)){
    		    		int user_selection=0;
    		    		Intent checklistduring = new Intent(CheckListActivityBefore.this, CheckListActivityDuringExternal.class);
        		    	checklistduring.putExtra("id_autopsy_during_before", id_autopsy);
        		    	checklistduring.putExtra("id_user_selection", user_selection);
        		    	startActivity(checklistduring);	
    		    	
    		    	}
    		    	else if((id_autopsy==4)||(id_autopsy==5)||(id_autopsy==6)||(id_autopsy==7)){
    		    		Intent checklistduring = new Intent(CheckListActivityBefore.this, MenuActivityDuring.class);
        		    	checklistduring.putExtra("id_autopsy_during_before", id_autopsy);
        		    	startActivity(checklistduring);	
    		    	} 		    	
     		    	
     		    }else{alert.show();}
    		    
    		    
    		    /*Toast.makeText(getApplicationContext(),
    		      responseText, Toast.LENGTH_LONG).show();*/
		    }
    	  });
	  id_autopsy_type = getIntent().getExtras().getString("id_autopsy_type");
	  id_autopsy = Integer.parseInt(id_autopsy_type);
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
	 
		 switch(id_autopsy) {
		 case 1: 
			 //Array list of countries
			  activityList = new ArrayList<CheckLists>();
			  CheckLists list_check = new CheckLists("","Verifique que el acta de inspección esté completa",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Verifique, asegure y continúe con el proceso de cadena de custodia de evidencia balística.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Recolecte las prendas con evidencia balística.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Identifique y documente fotográficamente las heridas o impactos antes de limpiarlos, utilizando el testigo métrico.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Verifique la prueba de absorción atómica.",false);
			  activityList.add(list_check);
		     break;
		 case 2: 
			  activityList = new ArrayList<CheckLists>();
			  list_check = new CheckLists("","Verifique  el  adecuado  manejo  de  la  Cadena  de  Custodia,  elementos  materia  de  prueba  de  la escena o del hospital.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Revise en Acta de Inspección si hubo cuantificación o medición del lago hemático en la escena.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Lea toda la Historia Clínica remitida , si hubo atención hospitalaria.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Procure tomar radiografías en caso de heridas múltiples por si hay fragmentos metálicos internos.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Prepare Diagramas o Dibujos para la autopsia.",false);
			  activityList.add(list_check);
		     break;
		 case 3: 
			  activityList = new ArrayList<CheckLists>();
			  list_check = new CheckLists("","Verifique que el acta de inspección esté completa",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Documente fotográficamente el embalaje del cuerpo",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Entreviste familiares.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Lea la historia clínica.",false);
			  activityList.add(list_check);
			  break;
		 case 4: 
			  activityList = new ArrayList<CheckLists>();
			  list_check = new CheckLists("","Verifique que el acta de inspección este completa",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Documente fotográficamente el embalaje del cuerpo",false);
			  activityList.add(list_check);
			  break;
		 case 5:
			  activityList = new ArrayList<CheckLists>();
			  list_check = new CheckLists("","Confirme que el Acta de Inspección contenga toda la información del hecho.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Compruebe las condiciones de embalaje y rotulación del cuerpo.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Lea toda la Historia Clínica remitida.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Procure tomar Radiografía de las extremidades para documentar puntos de impacto.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Documente fotográficamente con testigo métrico todas las lesiones, en especial si hay lesiones patrón ( use el calco en acetato )",false);
			  activityList.add(list_check);
			  break;
		 case 6: 
			  activityList = new ArrayList<CheckLists>();
			  list_check = new CheckLists("","Verifique que el acta de inspección esté completa.",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Verifique, asegure y continúe con la Cadena de Custodia y los elementos materia de prueba de la escena y del hospital",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Revise el acta de inspección si hubo atención medica en escena ",false);
			  activityList.add(list_check);
			  break;
		 case 7: 
			  activityList = new ArrayList<CheckLists>();
			  list_check = new CheckLists("","Defina las circunstancias en que fue encontrado",false);
			  activityList.add(list_check);
			  list_check = new CheckLists("","Determine si recibió alguna intervención médica antemortem",false);
			  activityList.add(list_check);
			  break;
		 default: 
		     
		     break;
		 }
		 //Array list of countries
	  
		 
	  //create an ArrayAdaptar from the String Array
	  dataAdapter = new MyCustomAdapter(this,
	    R.layout.info_country, activityList);
	  ListView listView = (ListView) findViewById(R.id.listView1);
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
	 
	  private ArrayList<CheckLists> activityList;
	 
	  public MyCustomAdapter(Context context, int textViewResourceId, 
	    ArrayList<CheckLists> countryList) {
	   super(context, textViewResourceId, countryList);
	   this.activityList = new ArrayList<CheckLists>();
	   this.activityList.addAll(countryList);
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
	   convertView = vi.inflate(R.layout.info_country, null);
	 
	   holder = new ViewHolder();
	   holder.code = (TextView) convertView.findViewById(R.id.code);
	   holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
	   convertView.setTag(holder);
	 
	    holder.name.setOnClickListener( new View.OnClickListener() {  
	     public void onClick(View v) {  
	      CheckBox cb = (CheckBox) v ;  
	      CheckLists list_check = (CheckLists) cb.getTag();  
	     
	      list_check.setSelected(cb.isChecked());
	     }  
	    });  
	   } 
	   else {
	    holder = (ViewHolder) convertView.getTag();
	   }
	 
	   CheckLists list_check = activityList.get(position);
	   holder.code.setText(list_check.getCode());
	   holder.name.setText(list_check.getName());
	   holder.name.setChecked(list_check.isSelected());
	   holder.name.setTag(list_check);
	 
	   return convertView;
	 
	  }
	 
	 }
	 
	 
	 
}

