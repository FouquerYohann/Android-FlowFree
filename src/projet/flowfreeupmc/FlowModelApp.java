package projet.flowfreeupmc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import API.FlowModel;
import API.HTMLParser;
import API.XMLreader;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.DisplayMetrics;

public class FlowModelApp extends Application {
	FlowModel fm;	
	ArrayList<FlowModel> fm_liste;
	private int niveau_cur;
	private int score=0;
	private String nom;
	int screen_height;
	int screen_width;
	
	public void onCreate(){
		super.onCreate();
	
		Context context= this.getApplicationContext();
		HTMLParser paul=new HTMLParser(context);
		Thread t = new Thread(paul) ;
		t.start();
		try {
			t.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AssetManager am=getAssets();
		InputStream is;
		FileInputStream fis;
		try {
			fis= context.openFileInput("sample_internet.xml");
			XMLreader read= new XMLreader(fis);
			fm_liste=read.getListeFlowPuzzle();
		   
		} catch (IOException e) {
			try {
				is = am.open("sample3_2.xml");
				XMLreader read= new XMLreader(is);
				fm_liste=read.getListeFlowPuzzle();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
public void saveScore(){
		
		String filename ="Grille"+getNiveau_cur()+".txt";
		FileOutputStream outputStream;
		String aEcrire= getNom() +" a obtenu le score de "+getScore();
	
		
		try {
			  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			  outputStream.write(aEcrire.getBytes());
			  outputStream.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}	
	}

public String readScore(){
	int  i;
	char c;
	String filename ="Grille"+getNiveau_cur()+".txt";
	String lecture="";
	FileInputStream inputStream;
	
	try {
		  inputStream = openFileInput(filename);
		  while((i=inputStream.read())!=-1){
			  c=(char)i;
			  lecture+=c;
		  }	
			  inputStream.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	return lecture;
}


	public int getScreen_height() {
	return screen_height;
}


public void setScreen_height(int screen_height) {
	this.screen_height = screen_height;
}


public int getScreen_width() {
	return screen_width;
}


public void setScreen_width(int screen_width) {
	this.screen_width = screen_width;
}


	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public void incrementScore(){
		score++;
	}
	
	public int getScore() {
		return score;
	}

	

	public int getNiveau_cur() {
		return niveau_cur;
	}

	public void setNiveau_cur(int niveau_cur) {
		this.niveau_cur = niveau_cur;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public FlowModel getFlowModel(){
		return fm;
	}
	public void setFm(FlowModel fm) {
		this.fm = fm;
	}
	public ArrayList<FlowModel> getFm_liste() {
		return fm_liste;
	}
	public void setFm_liste(ArrayList<FlowModel> fm_liste) {
		this.fm_liste = fm_liste;
	}
	
	
	
}
