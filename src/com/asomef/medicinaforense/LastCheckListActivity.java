package com.asomef.medicinaforense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LastCheckListActivity extends Activity {

//	private String paso_uno = "Firma del informe pericial";
//	private String paso_dos = "Garantizar conservación, preservación, reserva e integridad de los documentos";
//	private String paso_tres = "Toda evidencia física o elemento materia de prueba debe ser adecuadamente embalado y rotulado antes del envío, con el respectivo diligenciamiento del registro de cadena de custodia";
//
//	private String recomendaciones_uno = "Informe pericial";
//	private String recomendaciones_dos = "Consentimiento informado diligenciado";
//	private String recomendaciones_tres = "Adjuntar diagramas, calcos, material fotográfico y radiografías que ilustren el caso";
//	private String recomendaciones_cuatro = "Reporte de interconsultas a otros servicios y laboratorios";
//	private String recomendaciones_cinco = "Oficio petitorio y documentos asociados: copia de la denuncia, historia clínica, acta de inspección de la escena";
//
//	private String copias_uno = "Original y una copia se enviara a la autoridad";
//	private String copias_dos = "Otra copia para el archivo";

	private String selected = null;

//	private ArrayAdapter<ListCheck> listAdapterLast;
//	private ArrayAdapter<ListCheck> listAdapterRecommendations;
//	private ArrayAdapter<ListCheck> listAdapterCopies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_check_list);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			selected = extras.getString("selectedValue");
		}
		final Button comeBack = (Button) findViewById(R.id.btn_come_back);
        comeBack.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent openMenu = new Intent(LastCheckListActivity.this, Menu_HomeActivity.class);
                        startActivity(openMenu);
                }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.last_check_list, menu);
		return true;
	}
	
	

	

}
