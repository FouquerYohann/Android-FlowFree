package projet.flowfreeupmc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NiveauxEasy extends Activity implements OnClickListener{
	private FlowModelApp fma;
	Button G1;
	Button G2;
	Button G3;
	
	protected void onCreate(Bundle savedInstanceState) {  
		super.onCreate(savedInstanceState);
		setContentView(R.layout.niveaux_easy);
		fma = (FlowModelApp)this.getApplicationContext() ;
		G1=(Button)findViewById(R.id.Bouton_g1);
	    G2=(Button)findViewById(R.id.Bouton_g2);
	    G3=(Button)findViewById(R.id.Bouton_g3);

	    G1.setOnClickListener(this);
	    G2.setOnClickListener(this);
	    G3.setOnClickListener(this);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		int choix_niveau=0;
		if(requestCode ==0 && resultCode==RESULT_OK){
			
			String message=data.getStringExtra("Nom");
			choix_niveau=data.getIntExtra("choix_niveau", 0);
			fma.setNom(message);
		}
		Intent intent= new Intent(this, FlowModelActivity.class);
		intent.putExtra("choix_niveau", choix_niveau);
		startActivity(intent);
		finish();
	}
	
    public void onClick(View view) {
    	Intent intent = new Intent(this,RecupereNomActivity.class);
    	
    	
    	if (view.equals(G1)){
    		intent.putExtra("choix_niveau", 0);
        }else if (view.equals(G2)){
        	intent.putExtra("choix_niveau", 1);
        }else if (view.equals(G3)){
            intent.putExtra("choix_niveau", 2);
        }
    	startActivityForResult(intent, 0);
    
		
    }
	 

	 public void onClickReturn(View view){
		 finish();
	 }

}
