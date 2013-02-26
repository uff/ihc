package br.com.ihc.cc.uff.quadrodeavisos;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Menuzao extends Activity {
	
	private Button not;
	private Button sync;
	private Button opcoes;
	private Button sair;
	
	
	//FUNCKING GITHUB TEST
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menuzao);
		
		not = (Button)findViewById(R.id.menuzao_not);
		sync = (Button)findViewById(R.id.menuzao_sync);
		opcoes = (Button)findViewById(R.id.menuzao_opcoes);
		sair = (Button)findViewById(R.id.menuzao_sair);
		
		not.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				Class<?> nova_nota = null;
				try {
					nova_nota = Class.forName("br.com.ihc.cc.uff.quadrodeavisos.NovaNota");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				Intent intent = new Intent(Menuzao.this,nova_nota);
				startActivity(intent);
				
			}});
		
		
		
	}	

}
