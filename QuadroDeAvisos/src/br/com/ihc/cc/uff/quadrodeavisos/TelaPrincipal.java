package br.com.ihc.cc.uff.quadrodeavisos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class TelaPrincipal extends Activity {

	ImageView quadro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_principal);
		
		quadro = (ImageView)findViewById(R.id.quadro);
		quadro.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent touch) {
				
				switch(touch.getAction()){
				
					case MotionEvent.ACTION_UP:
						
						Class<?> menuzao = null;
						try {
							menuzao = Class.forName("br.com.ihc.cc.uff.quadrodeavisos.Menuzao");
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						Intent intent = new Intent(TelaPrincipal.this,menuzao);
						startActivity(intent);
	
				}
				return true;
			
			}
			
		});
		
		
		
	}

}
