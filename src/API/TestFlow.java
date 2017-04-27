package API;											// CLASSE TEST //



public class TestFlow {

	public static void main(String[] args) {
		
		
		//HTMLParser paul= new HTMLParser("http://grimau.dynamic-dns.net/flowfree/");
		
		/*
		Monde M = new Monde(10,7);          // Création d'une grille de 10 lignes et 7 colonnes //
		Case A = M.getCaseTableau(4, 5);
		Case B = M.getCaseTableau(2, 4);   // Création de deux cases A et B de la grille //	
		Case C = M.getCaseTableau(3, 3);
		
		PathUnderBuilding Path = new PathUnderBuilding(A,6);  
		PathUnderBuilding Path2 = new PathUnderBuilding(B,6);// Création de deux chemins en construction  de couleurs différentes //
		PathUnderBuilding Path3 = new PathUnderBuilding(C,2);
		GameState G1 = new GameState();                       // Création d'un état de jeu ==> début de la partie //
		G1.add(Path);
		G1.add(Path2);	// On ajoute les deux chemins "construits" à l'état du jeu //
		G1.add(Path3);
		FlowModel FL = new FlowModel(M, G1);               // On lance un FlowModel (une partie) avec la grille et l'état du jeu créés //
		
	
		System.out.println("1 "+FL.start(4,5));				// On démarre sur la case A ==> ok = true //


		System.out.println(M);                      // Affichage de la grille // 
		
		System.out.println("2 "+FL.extend(4,6));        // On se déplace d'une case en vertical ==> ok = true //
		System.out.println("3 "+FL.extend(4,4));        // On se déplace d'une case en vertical ==> ok = true //
		

		
		System.out.println("-----------1---------------");
		System.out.println(M);
		
		System.out.println("4 "+FL.extend(5,6));
		System.out.println("5 "+FL.extend(5,5));       // Dans '-----------1---------------' on fait nos tests d'extend() //
		System.out.println("6 "+FL.extend(5,4));
		System.out.println("7 "+FL.extend(4,4));
		System.out.println("8 "+FL.extend(3,4));
		System.out.println("8 "+FL.extend(2,4));
		
		
		System.out.println(G1.pathesComplete());
		System.out.println(Path);
		System.out.println(Path2);
		
		System.out.println("-----------2---------------");
		System.out.println(M);
		
		System.out.println("8 "+FL.extend(5,4));    // Dans '-----------2---------------' on vérifie que l'on peut revenir sur notre chemin
		
		System.out.println("-----------3---------------");
		System.out.println(M);
		
			
		System.out.println("9 "+FL.stop(5,4));
		System.out.println("10 "+FL.start(5,6));// Dans '-----------3---------------' on vérifie que si l'on choisit de reprendre le chemin en construction à partir de la case de coordonnées (5,6) //
		System.out.println("11 "+M.getCaseTableau(5, 4).getCheminCase());											// le chemin construit sur les cases (5,5), (5,4) et (5,3) s'efface et que la construction reprend bien à partir de la case (5,6) //
		System.out.println("-----------4---------------");
		System.out.println(M);
	
		
		System.out.println("12 "+FL.stop(5,6));
		
		System.out.println("13 "+FL.start(3,3));
		System.out.println("14 "+FL.extend(3,4));
		System.out.println("15 "+FL.extend(3,5));
		System.out.println("16 "+FL.extend(4,5));
		System.out.println("17 "+FL.stop(4,5));
		System.out.println("18 "+FL.start(4,5));
		
		
		
		System.out.println("-----------5---------------");
		System.out.println(M);
		
		
		// revenir sur son chemin en faisant un carre
		System.out.println("19 "+FL.extend(4,6));
		System.out.println("20 "+FL.extend(5,6));
		System.out.println("21 "+FL.extend(5,5));
		
		System.out.println("-----------6---------------");
		System.out.println(M);
		
		System.out.println("22 "+FL.extend(4,5));
		
		System.out.println("-----------7---------------");
		System.out.println(M);
		
		
		// a finir fusionner deux chemin
		// a tester fin du jeu
		
		*/
		/*
		XMLreader PAUL =new XMLreader("sample3.xml");
		
		
		ArrayList<FlowModel> TESTY= PAUL.getListeFlowPuzzle();
		
		for (int i = 0; i < TESTY.size(); i++) {
			System.out.println(i);
			System.out.println(TESTY.get(i).getMonde());
			System.out.println();
			System.out.println();
		}
		
		*/
		/*
		
		int x =0;
		int y =0;
		  
		int automate=0;
		Scanner sc = new Scanner(System.in);
		while((M.verifMondeUtilise() && G1.pathesComplete()) == false){
		
			System.out.println(M);
			
			
	        System.out.println("Enter x:");
	  
	            x = sc.nextInt();
	            System.out.print("You entered ");
	            System.out.println(x);
	       
	       
		
	        System.out.println("Enter y:");
	            y = sc.nextInt();
	            System.out.print("You entered ");
	            System.out.println(y);
	       
	        
			switch(automate) {
				
			case 0 :
				if(FL.start(x, y)) automate +=1;
				break;
			case 1 :
				if (FL.extend(x, y)) 
				
				// if (FL.stop(x,y))	automate -=1;
				break;
			/*case 2 :
				automate -=1;
				break;
			}
		
		}
		*/
	}
}