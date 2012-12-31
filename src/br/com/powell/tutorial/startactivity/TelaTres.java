package br.com.powell.tutorial.startactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TelaTres extends Activity {

    private static final int TELA_3 = 3;
	private static final String TAG = "Tela 3";
	private TextView textResultado;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_tres);
        
        textResultado = (TextView) findViewById(R.id.textView1);
        
        Toast.makeText(getApplicationContext(), "Tela " + TELA_3, Toast.LENGTH_SHORT).show();
        
        Intent it = getIntent();
        textResultado.setText("Resultado: " + it.getExtras().getInt(TelaDois.TAG));
       
    }
	
	@Override
	public void onBackPressed(){
		setResult(RESULT_OK);
		 finish();
        Log.d(TAG, "finalizado Tela 3");
	}
}