package br.com.ihc.cc.uff.quadrodeavisos;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class NovaNota extends Activity {

	Notificacoes nota;
	private String assunto;
	private String texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_nota);
	}
	
	public void notificacaoPronta(View view){
		
		EditText edit_assunto = (EditText)findViewById(R.id.not_assunto);
		EditText edit_texto = (EditText)findViewById(R.id.not_texto);
		
		assunto = edit_assunto.getText().toString();
		texto = edit_texto.getText().toString();
		
		//Bom momento para testar se os campos são válidos
		
		Notificacoes novaNota = new Notificacoes(true, false, false, assunto, texto, null, null);
	
	}

}
