package com.asomef.medicinaforense;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.asomef.medicinaforense.TouchImageView.OnTouchImageViewListener;

public class ImageActivity extends Activity {

	private TouchImageView image;
	private String selected = null;
	private boolean last = false;
	private boolean anexo = false;
	private int numeroAnexo = 0;
	Intent nextStep;

	private static final int MENU_PRIMER_ANEXO= Menu.FIRST; 
	private static final int MENU_SEGUNDO_ANEXO= Menu.FIRST+1;
	private static final int MENU_TERCER_ANEXO= Menu.FIRST+2;
	private static final int MENU_CUARTO_ANEXO= Menu.FIRST+3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		Button buttonNext = (Button) findViewById(R.id.btn_next);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			selected = extras.getString("selectedValue");
			last = extras.getBoolean("last");
			anexo = extras.getBoolean("anexo");
			numeroAnexo = extras.getInt("numeroAnexo");
		}
		// Any implementation of ImageView can be used!
		image = (TouchImageView) findViewById(R.id.image_reglamento);
		//mImageView = (ImageView) findViewById(R.id.image_reglamento);
		// Set the Drawable displayed
		Drawable bitmap;

		if(!anexo){

			if(selected.equals(PhorensicClinicActivity.lesiones_personales)){
				bitmap = getResources().getDrawable(R.drawable.reg_lesiones_personales_50);
			}
			else if(selected.equals(PhorensicClinicActivity.delito_sexual)){
				if(!last)
					bitmap = getResources().getDrawable(R.drawable.reg_delito_sexual_1_50);
				else
					bitmap = getResources().getDrawable(R.drawable.reg_delito_sexual_2_50);			
			}
			else if(selected.equals(PhorensicClinicActivity.edad_clinica)){
				bitmap = getResources().getDrawable(R.drawable.reg_edad_clinica_50);
			}
			else{
				if(!last)
					bitmap = getResources().getDrawable(R.drawable.reg_embriaguez_1_50);
				else
					bitmap = getResources().getDrawable(R.drawable.reg_embriaguez_2_50);	
			}

			buttonNext.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {

					if(selected.equals(PhorensicClinicActivity.lesiones_personales)){
						goLastCheckList();
					}
					else if(selected.equals(PhorensicClinicActivity.delito_sexual)){
						goSecondImage();		
					}
					else if(selected.equals(PhorensicClinicActivity.edad_clinica)){
						goLastCheckList();
					}
					else{
						goSecondImage();			
					}
					nextStep.putExtra("selectedValue",selected);
					nextStep.putExtra("last",last);
					startActivity(nextStep);	
				}
			});
		}
		else{
			buttonNext.setVisibility(4);
			// Select the image to show, depending selected item an if it's the first 
			if(selected.equals(PhorensicClinicActivity.lesiones_personales)){
				switch (numeroAnexo) {
				case 1:
					bitmap = getResources().getDrawable(R.drawable.anx_lesiones_personales_1_50);
					break;
				case 2:
					bitmap = getResources().getDrawable(R.drawable.anx_lesiones_personales_2_50);
					break;
				case 3:
					bitmap = getResources().getDrawable(R.drawable.anx_lesiones_personales_3_50);
					break;
				case 4:
					bitmap = getResources().getDrawable(R.drawable.anx_lesiones_personales_4_50);
					break;
				default:
					bitmap = getResources().getDrawable(R.drawable.blue_arrow);
					break;
				}	
			}
			else if(selected.equals(PhorensicClinicActivity.delito_sexual)){
				switch (numeroAnexo) {
				case 1:
					bitmap = getResources().getDrawable(R.drawable.anx_delito_sexual_1_50);
					break;
				case 2:
					bitmap = getResources().getDrawable(R.drawable.anx_delito_sexual_2_50);
					break;
				case 3:
					bitmap = getResources().getDrawable(R.drawable.anx_delito_sexual_3_50);
					break;
				case 4:
					bitmap = getResources().getDrawable(R.drawable.anx_delito_sexual_4_50);
					break;
				default:
					bitmap = getResources().getDrawable(R.drawable.blue_arrow);
					break;
				}			
			}
			else if(selected.equals(PhorensicClinicActivity.edad_clinica)){
				switch (numeroAnexo) {
				case 1:
					bitmap = getResources().getDrawable(R.drawable.anx_edad_clinica_1_50);
					break;
				case 2:
					bitmap = getResources().getDrawable(R.drawable.anx_edad_clinica_2_50);
					break;
				case 3:
					bitmap = getResources().getDrawable(R.drawable.anx_edad_clinica_3_50);
					break;
				default:
					bitmap = getResources().getDrawable(R.drawable.blue_arrow);
					break;
				}			
			}
			else{
				switch (numeroAnexo) {
				case 1:
					bitmap = getResources().getDrawable(R.drawable.anx_embriaguez_50);
					break;
				default:
					bitmap = getResources().getDrawable(R.drawable.blue_arrow);
					break;
				}			
			}

		}
		image.setImageDrawable(bitmap);
		// Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
			image.setOnTouchImageViewListener(new OnTouchImageViewListener() {
			
			@Override
			public void onMove() {
				PointF point = image.getScrollPosition();
				RectF rect = image.getZoomedRect();
				float currentZoom = image.getCurrentZoom();
				boolean isZoomed = image.isZoomed();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		if(!anexo){
			if(selected.equals(PhorensicClinicActivity.lesiones_personales)){
				menu.add(0, MENU_PRIMER_ANEXO, 0, "Anexo 1").setShowAsAction(8);
				menu.add(0, MENU_SEGUNDO_ANEXO, 0, "Anexo 2").setShowAsAction(8);
				menu.add(0, MENU_TERCER_ANEXO, 0, "Anexo 3").setShowAsAction(8);
				menu.add(0, MENU_CUARTO_ANEXO, 0, "Anexo 4").setShowAsAction(8);
			}
			else if(selected.equals(PhorensicClinicActivity.delito_sexual)){
				menu.add(0, MENU_PRIMER_ANEXO, 0, "Anexo 1").setShowAsAction(8);
				menu.add(0, MENU_SEGUNDO_ANEXO, 0, "Anexo 2").setShowAsAction(8);
				menu.add(0, MENU_TERCER_ANEXO, 0, "Anexo 3").setShowAsAction(8);
				menu.add(0, MENU_CUARTO_ANEXO, 0, "Anexo 4").setShowAsAction(8);
			}
			else if(selected.equals(PhorensicClinicActivity.edad_clinica)){
				menu.add(0, MENU_PRIMER_ANEXO, 0, "Anexo 1").setShowAsAction(8);
				menu.add(0, MENU_SEGUNDO_ANEXO, 0, "Anexo 2").setShowAsAction(8);
				menu.add(0, MENU_TERCER_ANEXO, 0, "Anexo 3").setShowAsAction(8);
			}
			else{
				menu.add(0, MENU_PRIMER_ANEXO, 0, "Anexo 1").setShowAsAction(8);	
			}
		}
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) { 
		case MENU_PRIMER_ANEXO:
			numeroAnexo = 1;
			
			break; 
		case MENU_SEGUNDO_ANEXO:  
			numeroAnexo = 2;
	
			break;
		case MENU_TERCER_ANEXO:  
			numeroAnexo = 3;
			
			break;
		case MENU_CUARTO_ANEXO:  
			numeroAnexo = 4;
		
			break;
		}

		Intent openAnexo = new Intent(ImageActivity.this, ImageActivity.class);
		openAnexo.putExtra("selectedValue",selected);
		openAnexo.putExtra("last",false);
		openAnexo.putExtra("anexo",true);
		openAnexo.putExtra("numeroAnexo",numeroAnexo);
		startActivity(openAnexo);
		return false;
	}


	private void goSecondImage(){
		if(!last){
			last = true;
			nextStep = new Intent(ImageActivity.this, ImageActivity.class);
		}
		else{
			nextStep = new Intent(ImageActivity.this, LastCheckListActivity.class);
		}
	}

	private void goLastCheckList(){
		last = true;
		nextStep = new Intent(ImageActivity.this, LastCheckListActivity.class);
	}

}
