package br.com.powell.tutorial.startactivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaDois extends Activity {

    private static final int TELA_2 = 2;
	public static final String TAG = "Tela 2";
	private Button buttonSubtrair;
	private EditText editNumero;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_dois);
        
        buttonSubtrair = (Button) findViewById(R.id.buttonSubtrair);
        editNumero = (EditText) findViewById(R.id.editText1);
        
        Toast.makeText(getApplicationContext(), "Tela " + TELA_2, Toast.LENGTH_SHORT).show();
        
        buttonSubtrair.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				try{
					if(valida()){
						String numero = editNumero.getText().toString();
						Intent itResultado = getIntent();
						
						int resultado = itResultado.getExtras().getInt(TelaUm.TAG) - Integer.valueOf(numero);
			        	Log.i(TAG, "Resultado " + resultado);
						Intent it = new Intent(TelaDois.this, TelaTres.class);
			        	it.putExtra(TAG, resultado);

			        	startActivityForResult(it, TELA_2);
					}
					
		        }catch(ActivityNotFoundException e){
		        	Log.e(TAG, e.getMessage());
		        }
			}

			private boolean valida() {
				if(editNumero.getText().toString().equals("")){
					return false;
				}
				return true;
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		
		if(TELA_2 == requestCode){
			if(resultCode == RESULT_OK){
				setResult(RESULT_OK);
				finish();
				Log.d(TAG, "Resultado da tela tres");
			}
		}
	}
        
}
