package com.android.quadroavisos;

import android.app.Activity;
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
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();

        setContentView(R.layout.register_activity);
        
        mEmailText = (EditText) findViewById(R.id.etRegEmail);
        mPassText = (EditText) findViewById(R.id.etRegPass);
        mFullnameText = (EditText) findViewById(R.id.etRegFullname);
        mMessage = (TextView) findViewById(R.id.tvRegMessage);
        
    }
    
    public void onClickButton(View v) {
    		String pass = mPassText.getText().toString();;
    		String email = mEmailText.getText().toString();
    		String name = mFullnameText.getText().toString();
    		Cursor user = mDbHelper.fetchUser(email);
    		startManagingCursor(user);
    		if(user==null){
    			RowId = mDbHelper.createUser(name, email, pass);
    			if(RowId==-1) mMessage.setText("Erro Fatal ao criar conta.");
    			else{
    				mDbHelper.close();
    				finish();
    			}
    		}else{
    			mMessage.setText("Usuário já existe.");
    		}
    }
    
    public void OnClickLink(View v){
    	mDbHelper.close();
    	finish();
    }
    
    
}
