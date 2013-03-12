package com.android.quadroavisos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity{
	private NotesDbAdapter mDbHelper;
	private EditText mEmailText;
    private EditText mPassText;
    private EditText mFullnameText;
    private TextView mMessage;
    private long RowId;
    
    private AlertDialog.Builder mBuilder;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();

        setContentView(R.layout.register_activity);
        setTitle(R.string.register_activity);
        
        mEmailText = (EditText) findViewById(R.id.etRegEmail);
        mPassText = (EditText) findViewById(R.id.etRegPass);
        mFullnameText = (EditText) findViewById(R.id.etRegFullname);
        mMessage = (TextView) findViewById(R.id.tvRegMessage);
        
        mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Registro");
        mBuilder.setMessage("Usuário registrado com sucesso!");
        mBuilder.setCancelable(false);
        mBuilder.setNeutralButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
				finish();
            }
        });
    }
    public void onPause(){
    	super.onPause();
    }
    
    public void onResume(){
    	super.onResume();
    }
    
    public void onClickButton(View v) {
    		String pass = mPassText.getText().toString();;
    		String email = mEmailText.getText().toString();
    		String name = mFullnameText.getText().toString();
    		Cursor user = mDbHelper.fetchUser(email);
    		if(user==null){
    			RowId = mDbHelper.createUser(name, email, pass);
    			if(RowId==-1) mMessage.setText("Erro Fatal ao criar conta.");
    			else{
    		        AlertDialog alert = mBuilder.create();
    		        alert.show();  
    			}
    		}else{
        		startManagingCursor(user);
    			mMessage.setText("Usuário já existe.");
    		}
    }
    
    public void OnClickLink(View v){
    	finish();
    }
    
    
}
