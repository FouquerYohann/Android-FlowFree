package API;												// CLASSE MONDE ==> GRILLE DE JEU //

public class Monde {
	private Case[][] tableau;

	
	public Case[][] getTableau() {
		return tableau;
	}

	public void setTableau(Case[][] tableau) {
		this.tableau = tableau;
	}

	public Monde(int nbLigne, int nbColonne){		// Création d'une grille de cases
		tableau = new Case[nbLigne][nbColonne];
		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {
				tableau[i][j]= new Case(i,j);
			}
		}
	}

	public String toString(){					// Méthode toString qui retourne la couleur de la pastille si elle occupe une case donc
		String s="";							// si cette case a un chemin.
		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				s+="| ";
				if (tableau[i][j].getCheminCase() == null) s+=" ";
				else s+= tableau[i][j].getCheminCase().getColor().substring(0, 1);
			}
			s+="|\n";
		} 
		return s;
	}
	

	public Case getCaseTableau(int i, int j){  // Accesseur qui retourne une case de la grille
		if (i < 0 || i>=tableau.length || j<0 || j>=tableau[i].length)
			return null;
		
		return tableau[i][j];
		
	}
	
	public int getNbLigne(){
		return tableau.length;
	}
	public int getNbColonne(){
		return tableau[0].length;
	}
	
	public boolean verifMondeUtilise(){								// Méthode qui vérifie que toutes les cases de la grille ont un chemin différent de				
							 										// "null" donc si toutes les cases de la grille ont bien un chemin.
		for (int i = 0; i < tableau.length; i++) {					//  on part du principe que toutes les cases ont un chemin
			for (int j = 0; j < tableau[i].length; j++) {			// on parcourt la grille et si une case n'a pas de chemin, on sort de
				if (tableau[i][j].getCheminCase() !=null) {			// du parcours de la grille et on retourne "false" ==> la grille
					return false;
					}
				}
			}
		return true;
	}
	
	
}
