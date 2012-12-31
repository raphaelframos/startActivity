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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonStartActivity = (Button) findViewById(R.id.buttonStartActivity);
        
        buttonStartActivity.setOnClickListener(startActivity);
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
    
}
