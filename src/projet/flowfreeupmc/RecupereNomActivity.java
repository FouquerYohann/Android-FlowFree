package projet.flowfreeupmc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecupereNomActivity extends Activity {
	private EditText et;
	private Button submit;
	private int choix_niveau;
	

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recup_nom);
		choix_niveau=getIntent().getIntExtra("choix_niveau", 0);
		
	      
	       
		et=(EditText) findViewById(R.id.et);
		submit=(Button) findViewById(R.id.submit);

		
	}
	
	public void onClickSubmit(View view){
		
		String message=et.getText().toString();
		
		Intent intent = getIntent();
		intent.putExtra("Nom", message);
		intent.putExtra("choix_niveau", choix_niveau);
		setResult(RESULT_OK, intent);
		finish();
	}

	
	
	

}
