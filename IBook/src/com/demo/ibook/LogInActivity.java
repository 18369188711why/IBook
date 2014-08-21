package com.demo.ibook;

import java.util.HashMap;
import java.util.Map;




import dataType.SerializableMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity{
private TextView userName,password;
	
	private EditText userNameText,passwordText;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		userName = (TextView)findViewById(R.id.userName);
		userName.setText("ÓÃ»§Ãû");
	    userNameText=(EditText) findViewById(R.id.userNameText);
	    password = (TextView)findViewById(R.id.password);
	    password.setText("ÃÜÂë");
	    passwordText = (EditText)findViewById(R.id.passwordText);
		login = (Button) findViewById(R.id.login);
		login.setText("µÇÂ½");
		login.setOnClickListener(new searchBookListener());
		
		
	}

	
	
	private static Map<String,String> getValue(EditText userName,EditText password){
		Map<String,String> map = new HashMap<String,String>();
		String key = userName.getText().toString();
		String value = password.getText().toString();
		map.put(key, value);
		return map;
	}




private static Map<String, String> extracted(Map<String, String> map) {
	return map;
}
	
class searchBookListener implements OnClickListener{
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		
		Map<String, String> map = LogInActivity.getValue(userNameText,passwordText);
		SerializableMap tmpMap=new SerializableMap();
		tmpMap.setMap(map);
		Bundle bundle =new Bundle();
		bundle.putSerializable("name", tmpMap);
		intent.putExtras(bundle);
		intent.setClass(LogInActivity.this, CommentsActivity.class);
		LogInActivity.this.startActivity(intent);
		
	}
	
}


}
