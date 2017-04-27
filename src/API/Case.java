package API;								// CLASSE CASE //

public class Case {                           // Création d'une classe Case avec comme variables d'instances un chemin en construction, et des coordonées de case. //
	private PathUnderBuilding cheminCase;
	private boolean estUnePastille;
	private int ligne;
	private int colonne;
	
	public Case(){								// Constructeur sans paramètres pour initialiser une grille avec des cases sans chemin.
		cheminCase=null;
		estUnePastille =false;
	}
	
	public Case(int i, int j){             // Constructeur case avec deux paramètres, les coordonnées de la case sur la grille
		cheminCase=null;
		estUnePastille=false;
		ligne=i;
		colonne=j;
	}
    public Case(Case A){
        cheminCase=null;
        estUnePastille=false;
        ligne=A.getLigne();
        colonne=A.getColonne();
    }

	public PathUnderBuilding getCheminCase() {    // Accesseur de type PathUnderBuilding qui retourne le chemin de la case 
		return cheminCase;
	}

	public void setCheminCase(PathUnderBuilding chemin_case) {  // Accesseur: Attribution d'un chemin à une case
		this.cheminCase = chemin_case;
	}

	
	public boolean bonDeplacement(int i, int j){  
		int dx= (ligne-i);				 
		int dy= (colonne-j);
		
		return (Math.sqrt(dx*dx+dy*dy) == 1);				
	}

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public boolean isEstUnePastille() {
		return estUnePastille;
	}

	public void setEstUnePastille(boolean estUnePastille) {
		this.estUnePastille = estUnePastille;
	}

	public String toString(){				
		boolean util = false;
		if (cheminCase != null) util = true;
		
		return ("("+ligne+","+colonne+") Chemin_utiliser :"+ util);
	}
}