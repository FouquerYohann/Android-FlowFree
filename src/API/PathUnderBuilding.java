package API;               							// CLASSE PATHUNDERBUILDING ==> CREATION DES CHEMINS EN CONSTRUCTION //

import java.util.ArrayList;

public class PathUnderBuilding {								
	private ArrayList<Case> liste;								// Classe PathUnderBuilding dont les attributs sont une liste de cases,
	private int pathState;  // 0=initial 1=en_cours 2=fini     // l'état d'un chemin et la couleur (d'un chemin en construction) sous forme d'entier.
	private String color;
	
	public PathUnderBuilding(Case A, String color){			// Constructeur d'un chemin en construction avec pour paramètres une case et une couleur
		liste = new ArrayList<Case>() ;						
		liste.add(A);									//On ajoute une case sans chemin à la liste (setCheminCase)
		A.setCheminCase(this);
		A.setEstUnePastille(true);
		this.color =color;								// Attribution d'une couleur au chemin en construction
		this.pathState = 0;								// Initialisation à "initial" du chemin en construction (l'utilisateur n'a pas posé son doigt sur une case) 
	}
	
	
	public PathUnderBuilding(){						// Constructeur d'un chemin en construction sans paramètres
		liste=new ArrayList<Case>() ;
		pathState=0;
		this.color = "";		
	}	
	
	
	public void add(Case c){							
	
			liste.add(c);                                         // ajoute la case a la liste et change le chemin de la case
			c.setCheminCase(this);
			
			if (pathState == 0) pathState =1;               // change l'etat a en cours si il etait initial
		return ;
	}
	
	
	
	
	// retire toute les case apres la case A de la liste
	public void removeDepuis(Case A){
		pathState=1;
		int i = liste.size()-1;
		
		while(liste.get(i).equals(A) == false){
			liste.get(i).setCheminCase(null);
			liste.remove(i);
			i--;
		}
		
		return ;
	}
	/*
	public void fusion(PathUnderBuilding pub){
		for (int i=0; i<pub.getListe().size(); i++)
			liste.add(pub.getListe().get(i));
		
		
		
	}
	*/
	
	
	
	
	
	
	public int getPathState() {					// Accesseur qui retourne l'état d'un chemin
		return pathState;
	}

	public void setPathState(int pathState) {  // Accesseur qui change l'état d'un chemin
		this.pathState = pathState;
	}

	public String getColor() {					  // Accesseur qui retourne la couleur
		return color;
	}

		
	public ArrayList<Case> getListe() {    // Accesseur qui retourne une liste
		return liste;
	}

	
	@Override
	public String toString() {
		return "PathUnderBuilding [liste=" + liste + ", pathState=" + pathState
				+ ", color=" + color + "]";
	}
	

}