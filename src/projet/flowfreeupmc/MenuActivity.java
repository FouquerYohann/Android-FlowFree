package projet.flowfreeupmc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity implements OnClickListener{
	private FlowModelApp fma;
    Button Easy;
    Button Medium;
    Button Hard;

	
	
	protected void onCreate(Bundle savedInstanceState) {  
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		fma = (FlowModelApp)this.getApplicationContext() ;
        Medium=(Button)findViewById(R.id.Bouton_1);
        Easy=(Button)findViewById(R.id.Bouton_2);
        Hard=(Button)findViewById(R.id.Bouton_3);

        Easy.setOnClickListener(this);
        Medium.setOnClickListener(this);
        Hard.setOnClickListener(this);
        
        DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		fma.setScreen_height(metrics.heightPixels);
		fma.setScreen_width(metrics.widthPixels);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

    @Override
    public void onClick(View view) {
    	Intent intent = new Intent();
    	
    	
    	if (view.equals(Easy)){
    		intent = new Intent(MenuActivity.this,NiveauxEasy.class);
        }else if (view.equals(Medium)){
        	intent = new Intent(MenuActivity.this,NiveauxMedium.class);
        }else if (view.equals(Hard)){
            intent = new Intent(MenuActivity.this,NiveauxHard.class);
        }
    	startActivity(intent);
    	
		
    }
}
