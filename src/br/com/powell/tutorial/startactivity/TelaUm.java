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

public class TelaUm extends Activity {

    private static final int TELA_1 = 1;
	public static final String TAG = "Tela 1";
	private Button buttonSomar;
	private EditText editNumero1;
	private EditText editNumero2;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_um);
        
        buttonSomar = (Button) findViewById(R.id.buttonSomar);
        editNumero1 = (EditText) findViewById(R.id.editText1);
        editNumero2 = (EditText) findViewById(R.id.editText2);
        
        buttonSomar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				 try{
					 if(valida()){
						 String numero = editNumero1.getText().toString();
						 String numero2 = editNumero2.getText().toString();
						 
						 int somatorio = Integer.valueOf(numero) + Integer.valueOf(numero2);
						 Log.i(TAG, "Soma: " + somatorio);
						 Intent it = new Intent(TelaUm.this, TelaDois.class);
						 
						 it.putExtra(TAG, somatorio);
				         startActivityForResult(it, TELA_1);
				         Log.d(TAG, "Tela 1");
					 }else{
						 
					 }
					 
					 
			        }catch(ActivityNotFoundException e){
			        	Log.e(TAG, e.getMessage());
			        }
			}

			private boolean valida() {
				if(editNumero1.getText().toString().equals("")){
					return false;
				}
				
				if(editNumero2.getText().toString().equals("")){
					return false;
				}
				return true;
			}
		});
    }
	
	
	//Método de retorno do método startActivityForResult
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		
		//Código enviado
		if(TELA_1 == requestCode){
			//Código resultado
			if(resultCode == RESULT_OK){
				finish();
				Log.d(TAG, "Resultado da tela dois");
			}
		}
	}
}
