package API;									// CLASSE FLOWMODEL ==> CE QUI EST NECESSAIRE POUR JOUER //



public class FlowModel {                        // Attributs: un monde (=une grille), un état du jeu, chemin en construction, case sélectionnée //
	private Monde m;
	private GameState gs;
	private PathUnderBuilding cheminEnCours;
	private Case caseEnCours;
	
	public Monde getMonde(){					// Accesseur: retourne un monde (=une grille) //
		return this.m;
	}
	
	public FlowModel(Monde m, GameState gs){  // Constructeur à deux paramètres: un monde (grille) et un état du jeu //
		this.m = m;								// Initialisation du monde, de l'état du jeu
		this.gs = gs;
		cheminEnCours = null;				//Pas de chemin en cours ==> l'utilisateur n'a pas commencé à jouer donc pas sélectionné une case //
		caseEnCours = null;					// CREATION D'UNE GRILLE A JOUER //
	}
	
	
	public boolean start(int x,int y){     // Méthode start():
			
		boolean ok = false;				// Variable booléenne fonction de la sélection d'une case par l'utilisateur:
		
		Case cur = m.getCaseTableau(x, y);   // Si l'utilisateur sélectionne une case vide (sans pastille donc sans chemin), on retourne
		if (cur == null) return false;       //  "false", l'utilisateur ne peut pas starter sur cette case //

		if (cur.getCheminCase() !=null && cur.getCheminCase().getListe().size() ==1){    // Si l'utilisateur sélectionne une case contenant une pastille donc un chemin: ok = "true" //
			ok=true;						// l'utilisateur peut starter sur cette case. //
			cheminEnCours= cur.getCheminCase();  // Dans ce cas, cheminEnCours est initialisé avec le chemin de la case sélectionnée //
			caseEnCours = cur;					// caseEnCours est la case sélectionnée //	
		}
		else if (cur.getCheminCase() !=null){    // Si l'utilisateur sélectionne une case contenant une pastille donc un chemin: ok = "true" //
			ok=true;						// l'utilisateur peut starter sur cette case. //
			cheminEnCours= cur.getCheminCase();  // Dans ce cas, cheminEnCours est initialisé avec le chemin de la case sélectionnée //
			caseEnCours = cur;					// caseEnCours est la case sélectionnée //
			cheminEnCours.removeDepuis(cur);	// redemarre depuis n'importe ou sur un chemin //
			for (int i=0; i < gs.getListePath().size(); i++){
				if (gs.getListePath().get(i).getColor().equals(cheminEnCours.getColor()))
					gs.getListePath().get(i).setPathState(1);
			}
		}	
		return ok;
	}
	
	public boolean extend(int x,int y){  // Méthode extend(): //
		
		Case cur = m.getCaseTableau(x, y);      // Cur = case sélectionnée par l'utilisateur //
		if (cur ==null) return false;
		boolean ok = false;	// Variable booléenne "ok" initialisée à "false", on suppose qu'on ne peut pas se déplacer sur la case sélectionnée //
		
		if (cheminEnCours == null || caseEnCours == null)
			return false;
		
		if (cheminEnCours.getPathState() == 2){
			return false;
		}
		
		
		


		if (caseEnCours.bonDeplacement(x, y) ==false){
			return false;
		}
		if (cur.getCheminCase() ==null){ // Si la case sélectionnée n'a pas de chemin et que c'est un déplacement autorisé: //
			ok = true;											// ok = true
			cheminEnCours.add(m.getCaseTableau(x, y));
			//cheminEnCours= cur.getCheminCase();					// le chemin en cours devient celui de la case sélectionnée //
			caseEnCours = cur;									// la case sélectionnée devient la case courante //
		}
		else if (cur.getCheminCase() !=null
			  && cur.getCheminCase().equals(caseEnCours.getCheminCase()) ==true ){

			ok = true;
			cheminEnCours.removeDepuis(cur);
			caseEnCours = cur;
		}
		else if (cur.getCheminCase() !=null
			      && cur.getCheminCase().getColor().equals(caseEnCours.getCheminCase().getColor())
				  ){

				ok = true;
                cheminEnCours.add(new Case(m.getCaseTableau(x, y)));
				cur.getCheminCase().removeDepuis(cur);
				cur.getCheminCase().setPathState(2);
				cheminEnCours.setPathState(2);
				caseEnCours = cur;
			}
		else if (cur.getCheminCase() !=null
				&& cur.getCheminCase().equals(caseEnCours.getCheminCase()) ==false){
				stop(x,y);
				return false;

				}



		return ok;
	}
	
	public boolean stop(int x,int y){    // Méthode stop(): //
		
	
		caseEnCours = null;
		cheminEnCours = null;
		

		
		return true;                   // Toutes les conditions d'arrêt ayant été prédeterminées dans les classes et méthodes annexes
	}									// l'utilisateur peut s'arrêter où il veut sur la grille.

	
	public void reset(){
		for (int i=0; i<gs.getListePath().size(); i++){
			gs.getListePath().get(i).removeDepuis(gs.getListePath().get(i).getListe().get(0));
		}
	}
	
	public boolean finJeu(){
		if (gs.pathesComplete() == true){ //.verifMondeUtilise()==true)
			return true;
		}
		return false;
	}
	
	public GameState getGs() {
		return gs;
	}

}