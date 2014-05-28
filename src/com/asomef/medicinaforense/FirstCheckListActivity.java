package com.asomef.medicinaforense;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstCheckListActivity extends Activity {

	private String paso_uno = "Solicitud de la autoridad competente *";
	private String paso_dos = "Solicitar documento de identidad para verificar la identidad de la persona a examinar";
	private String paso_tres = "En caso de no poseer documento de identificación, registrar al examinado como indocumentado";
	private String paso_cuatro = "En caso de imputado se requiere: autorización del juez de control de garantías y presencia del defensor (*)";
	private String paso_cinco = "Si hay evidencia física o elementos materia de prueba, verificar embalaje, preservación y rotulación. Si se observan alteración regístrelo en el espacio de observaciones en el formato de cadena de custodia";
	private String paso_seis = "Verificar un adecuado diligenciamiento del formato de cadena de custodia. Verificar que todos los campos estén completos, si se observan espacios vacios regístrelo en el espacio de observaciones en el formato de cadena de custodia";
	private String paso_siete = "Firmar el recibido del registro de cadena de custodia";
	private String paso_ocho = "Tener en cuenta documentos asociados (Historia clínica, etc)";
	private String paso_nueve = "Radicar el número del caso (Número de radicación consecutivo)";
	private String selected = null;

	private ArrayAdapter<ListCheck> listAdapter ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_check_list);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			selected = extras.getString("selectedValue");
		}

		final ListView listviewChecklistFirstActivity = (ListView) findViewById(R.id.lst_first_activity);
		final TextView titleActivity = (TextView) findViewById(R.id.txt_first_list_activity);
		final Button buttonShowImage = (Button) findViewById(R.id.btn_show_image);

		titleActivity.setText(selected);

		final ArrayList<ListCheck> listChecklistFirstActivity;
		listChecklistFirstActivity = new ArrayList<ListCheck>();
		listChecklistFirstActivity.add(new ListCheck(paso_uno));
		listChecklistFirstActivity.add(new ListCheck(paso_dos));
		listChecklistFirstActivity.add(new ListCheck(paso_tres));
		listChecklistFirstActivity.add(new ListCheck(paso_cuatro));
		listChecklistFirstActivity.add(new ListCheck(paso_cinco));
		listChecklistFirstActivity.add(new ListCheck(paso_seis));
		listChecklistFirstActivity.add(new ListCheck(paso_siete));
		listChecklistFirstActivity.add(new ListCheck(paso_ocho));
		listChecklistFirstActivity.add(new ListCheck(paso_nueve));

		// When item is tapped, toggle checked properties of CheckBox and Planet.  
		listviewChecklistFirstActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {  
			@Override  
			public void onItemClick( AdapterView<?> parent, View item,   
					int position, long id) {  
				ListCheck lista = listAdapter.getItem( position );  
				lista.toggleChecked();  
				ListCheckRow viewHolder = (ListCheckRow) item.getTag();  
				viewHolder.getCheckBox().setChecked( lista.isChecked() );  
			}  
		});

		// Set our custom array adapter as the ListView's adapter.  
		listAdapter = new ListCheckAdapter(this, listChecklistFirstActivity);  
		listviewChecklistFirstActivity.setAdapter( listAdapter );

		buttonShowImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean flag = false;
				// TODO Auto-generated method stub
				for(int i=0; i<listAdapter.getCount(); i++){
					if(!listAdapter.getItem(i).isChecked()){
						flag = true;
						break;
					}
				}
				if(!flag){
					Intent openImage = new Intent(FirstCheckListActivity.this, ImageActivity.class);
					openImage.putExtra("selectedValue",selected);
					openImage.putExtra("last",false);
					openImage.putExtra("anexo",false);
					openImage.putExtra("numeroAnexo",0);
					startActivity(openImage);
				}
				else{
					Toast.makeText(getApplicationContext(), "Debe seleccionar todos los items para pasar a la siguiente actividad", Toast.LENGTH_SHORT).show();
				}

			}
		});
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

	/** Holds planet data. */  
	private static class ListCheck { 
		private boolean checked = false ;
		private String name = "" ;
		public ListCheck() {
			// TODO Auto-generated constructor stub
		}
		public ListCheck(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}
		public String getName() {  
			return name;  
		} 
		public void setName(String name) {  
			this.name = name;  
		}  
		public void setChecked(boolean checked) {  
			this.checked = checked;  
		}
		public boolean isChecked() {  
			return checked;  
		}  
		public void toggleChecked() {  
			checked = !checked ;  
		}  
	}

	/** Holds child views for one row. */  
	private static class ListCheckRow {  
		private CheckBox checkBox ; 
		public ListCheckRow() {
			// TODO Auto-generated constructor stub
		}  
		public CheckBox getCheckBox() {  
			return checkBox;  
		}  
		public void setCheckBox(CheckBox checkBox) {  
			this.checkBox = checkBox;  
		}   
	}

	/** Custom adapter for displaying an array of strings objects. */  
	private static class ListCheckAdapter extends ArrayAdapter<ListCheck> {  

		private LayoutInflater inflater;  

		public ListCheckAdapter( Context context, List<ListCheck> checkboxlist ) {  
			super( context, R.layout.list_first_check_activity, R.id.chb_list_first_activity, checkboxlist );  
			// Cache the LayoutInflate to avoid asking for a new one each time.  
			inflater = LayoutInflater.from(context) ;  
		}  

		@Override  
		public View getView(int position, View convertView, ViewGroup parent) {  
			// Planet to display  
			ListCheck listCheck = (ListCheck) this.getItem(position);   

			// The child views in each row.  
			CheckBox checkBox ;   

			// Create a new row view  
//			if ( convertView == null ) {  
				convertView = inflater.inflate(R.layout.list_first_check_activity, null);  

				// Find the child views.  
				checkBox = (CheckBox) convertView.findViewById( R.id.chb_list_first_activity );  

				// Optimization: Tag the row with it's child views, so we don't have to   
				// call findViewById() later when we reuse the row.  
				convertView.setTag( new ListCheckRow());  

				// If CheckBox is toggled, update the planet it is tagged with.  
				checkBox.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						ListCheck probe = (ListCheck) cb.getTag();  
						probe.setChecked( cb.isChecked() );  
					}  
				});          

				// Reuse existing row view  
				//			else {  
				//				// Because we use a ViewHolder, we avoid having to call findViewById().  
				//				ListCheckRow viewHolder = (ListCheckRow) convertView.getTag();  
				//				checkBox = viewHolder.getCheckBox() ;
				//			}  

				// Tag the CheckBox with the Planet it is displaying, so that we can  
				// access the planet in onClick() when the CheckBox is toggled.  
				checkBox.setTag( listCheck );   

				// Display planet data  
				checkBox.setChecked( listCheck.isChecked() ); 
				checkBox.setText(listCheck.getName());
//			}
			return convertView;  
		}  

	}  

}
