package com.android.quadroavisos;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
 
public class LoginActivity extends Activity {
	
	private Intent mIntent;
	private EditText mEmailText;
    private EditText mPassText;
    private TextView mMessage;
    private Long mRowId;
    private NotesDbAdapter mDbHelper;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();

        setContentView(R.layout.login_activity);

        setTitle(R.string.login_activity);
        
        mEmailText = (EditText) findViewById(R.id.etEmail);
        mPassText = (EditText) findViewById(R.id.etPass);
        mMessage = (TextView) findViewById(R.id.tvMessage);

    }
    public void onPause(){
    	super.onPause();
    }
    
    public void onResume(){
    	super.onResume();
    }
    
    public void onClickButton(View v) {
    	String email = mEmailText.getText().toString();
    	String givenPass = mPassText.getText().toString();
    	Cursor user = mDbHelper.fetchUser(email);
    	if(user!= null){
    		startManagingCursor(user);
    		String regPass = user.getString(user.getColumnIndex(NotesDbAdapter.KEY_PASS));
    		if(regPass.equals(givenPass)){
    			String name = user.getString(user.getColumnIndex(NotesDbAdapter.KEY_NAME));
    			mRowId = user.getLong(user.getColumnIndex(NotesDbAdapter.KEY_ROWID));
    			mIntent = new Intent();
    			Bundle bundle = new Bundle();
    			bundle.putString(NotesDbAdapter.KEY_NAME, name);
    			bundle.putLong(NotesDbAdapter.KEY_ROWID, mRowId);
    			mIntent.putExtras(bundle);
    			setResult(RESULT_OK, mIntent);
    			finish();
    		}
    		else mMessage.setText("Login falhou: verifique suas credenciais.");
    	}
    	else mMessage.setText("Login falhou: verifique suas credenciais.");
    }
    public void onClickLink(View v){
    	Intent i = new Intent(this, RegisterActivity.class);
    	startActivity(i);
    }
    
    @Override
    public void onBackPressed() {
    }
}