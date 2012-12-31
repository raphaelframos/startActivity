package br.com.powell.tutorial.startactivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button buttonStartActivity;
	private Button buttonStartActivityForResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonStartActivity = (Button) findViewById(R.id.buttonStartActivity);
        buttonStartActivityForResult = (Button) findViewById(R.id.buttonStartActivityForResult);
        
        buttonStartActivity.setOnClickListener(startActivity);
        buttonStartActivityForResult.setOnClickListener(startActivityForResult);
    }
    
    private OnClickListener startActivity = new OnClickListener() {
		
		public void onClick(View arg0) {
			try{
				startActivity(new Intent(MainActivity.this, TelaStartActivity.class));
			}catch(ActivityNotFoundException e){
				Log.e("MainActivity", e.getMessage());
			}
		}
	};
	
	private OnClickListener startActivityForResult = new OnClickListener() {
		
		public void onClick(View arg0) {
			
			try{
				startActivity(new Intent(MainActivity.this, TelaUm.class));
			}catch(ActivityNotFoundException e){
				Log.e("MainActivity", e.getMessage());
			}
		}
	};
    
}
