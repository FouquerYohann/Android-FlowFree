package API;											//CLASSE ETAT DE JEU //

import java.util.ArrayList;

public class GameState {
	private ArrayList<PathUnderBuilding> listePath;  // L'état du jeu dépend des chemins construits ou en cours de construction.
													// Le jeu se termine lorsque toutes les cases d'une grille ont un chemin, c'est 
													// pourquoi la classe GameState a un attribut qui est une liste de chemins.
	public GameState(){									
		listePath= new ArrayList<PathUnderBuilding>();		// Constructeur: création d'une liste de chemins en constructions //
	}
	
	public void add(PathUnderBuilding pub){  		// Méthode: ajout d'un chemin à la liste //
		listePath.add(pub);
	}
	
	
	public boolean pathesComplete(){						// Méthode booléenne: on suppose que toutes les cases de la grille de jeu										// ont un chemin dont l'état est final (construit). On parcourt la grille et
															// si on trouve une case dont l'état du chemin est différent de final, on return false
		for (int i = 0; i < listePath.size(); i++) {       
			if (listePath.get(i).getPathState() != 2){		
				return false;
			}
		}
		return true;
	}

	public ArrayList<PathUnderBuilding> getListePath() {
		return listePath;
	}
	
	
}