package projet.flowfreeupmc;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FlowModelActivity extends Activity {
	FlowModelApp fma;
	TextView tw;
	int height;
	int width;
	projet.flowfreeupmc.FlowGridView FGW;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {  
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fma=(FlowModelApp)this.getApplication();
        Bundle b=getIntent().getExtras();
        int choix_niveau=0;
        if (b != null)
            choix_niveau = b.getInt("choix_niveau");
        fma.setFm(fma.getFm_liste().get(choix_niveau));
        fma.setNiveau_cur(choix_niveau);
        String bonjour = "BONJOUR "+fma.getNom();
        Toast.makeText(getApplicationContext(), bonjour,Toast.LENGTH_SHORT ).show();
        tw=(TextView) findViewById(R.id.Best_score);
        tw.setText("Meilleur Score :\n " + fma.readScore());
    	
		
        
    }

	
	
	public void onClickEXIT(View view){
	fma.getFlowModel().reset();
	fma.setScore(0);
	finish();
	}
	public void onClickNEW(View view){
		fma.getFlowModel().reset();
		fma.setScore(0);
		 tw.setText("Meilleur Score : \n" + fma.readScore());
	}
	public void onClickMENU(View view){
			fma.getFlowModel().reset();	
			fma.setScore(0);
			finish();
	}
	public void onClickNEXT(View view){
		fma.getFlowModel().reset();
		int niveau_suiv =fma.getNiveau_cur() +1;
		if (niveau_suiv >= fma.getFm_liste().size())
			niveau_suiv=0;
		fma.setFm(fma.getFm_liste().get(niveau_suiv));
		fma.setNiveau_cur(niveau_suiv);
		fma.setScore(0);
		tw.setText("Meilleur Score : \n" + fma.readScore());
	}
	
	public void onClickPREVIOUS(View view){
		fma.getFlowModel().reset();
		int niveau_prev = fma.getNiveau_cur() -1;
		if (niveau_prev < 0)
			niveau_prev = fma.getFm_liste().size() -1;
		fma.setFm(fma.getFm_liste().get(niveau_prev));
		fma.setNiveau_cur(niveau_prev);
		fma.setScore(0);
		tw.setText("Meilleur Score : \n" + fma.readScore());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
