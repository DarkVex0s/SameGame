/**
 * Class qui contient l'algorithme de groupement (qui détecte le groupe sur lequel la souris se trouve/clique)
 * @author Valentin MARTIN et Thibault ANDRI
 * @version 1.0
 */

public class Groupement {

	private char[][] caract;
	private int x;
	private int y;
	
	/**
	 * Constructeur de la class Groupement
	 * @param tableau : tableau de caractère représentant la grille de jeu
	 * @param i : position x de la souris
	 * @param j : position y de la souris
	 */
	public Groupement(char[][] tableau, int i, int j) {
	caract = tableau;
	x = i;
	y = j;
	}
	
	// Tableau de taille 150 car 10 ligne et 15 colonnes donc 10*15 = 150 cases donc groupe maximum de 150 donc 150 position à retenir
	private int[] memoireX = new int[150];
	private int[] memoireY = new int[150];
	

	private int compte = 0;
	
	// Tableau booléen permettant de savoir si une case à déjà été ajouté dans le groupe
	private boolean[][] check = new boolean[10][15];
	

// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Cette méthode lance l'algorithme de recherche du grouppe
	 * @param x : position x de la souris (dans le tableau du jeu)
	 * @param y : position y de la souris (dans le tableau du jeu)
	 */
	public void Regroupement(int x, int y) {
	// ajout de la case où on a cliqué/survolé en premier avant de faire les cases alentours
	if(compte == 0) {
	booleanTab();
	addToGroupe(x,y);
	check[x][y] = true;
	compte++;
	}
	// N = nothing donc vide donc case vide, c'est-à-dire qu'on lance l'algorithme uniquement si la case que l'on veut regarder n'est pas vide
	if(caract[x][y] != 'N') {
	Dessus(x,y);
	Dessous(x,y);
	Gauche(x,y);
	Droite(x,y);
	}
	else {
	compte = 0;
	}
	}
	
	/**
	 * Méthode qui recherche les cases du dessus appartenant au groupe
	 * @param x : position x de la souris (dans le tableau de jeu)
	 * @param y : position y de la souris (dans le tableau de jeu)
	 */
	public void Dessus(int x, int y) {
		if(x>0){
		// Si la case du dessus est la meme en que celle où se trouve notre souris/clique et si on ne l'a pas déjà ajouté au groupe	
		      if(caract[x][y] == caract[x-1][y] && check[x-1][y] != true) {
		// Ajoute la case au groupe
		addToGroupe(x-1,y);	
		compte++; // Compte s'incrémente de 1
		check[x-1][y] = true; // Passe la case ajoutée en true pour ne pas la rajouté à nouveau
		Regroupement(x-1,y);
		      }
		}
	}
		
	/**
	 * Méthode qui recherche les cases du dessous appartenant au groupe
	 * @param x : position x de la souris (dans le tableau de jeu)
	 * @param y : position y de la souris (dans le tableau de jeu)
	 */
	public void Dessous(int x, int y) {
		if(x<9){
		       if(caract[x+1][y] == caract[x][y] && check[x+1][y] != true) {
		
		addToGroupe(x+1,y);
		compte++;
		check[x+1][y] = true;
		Regroupement(x+1,y);
		       }
		}
	}
	
	/**
	 * Méthode qui recherche les cases de gauche appartenant au groupe
	 * @param x : position x de la souris (dans le tableau de jeu)
	 * @param y : position y de la souris (dans le tableau de jeu)
	 */
	public void Gauche(int x, int y) {
		if(y>0){
		       if(caract[x][y-1] == caract[x][y] && check[x][y-1] != true) {
		
		addToGroupe(x,y-1);
		compte++;
		check[x][y-1] = true;
		Regroupement(x,y-1);
		       }
		}
	}
	
	/**
	 * Méthode qui recherche les cases de droite appartenant au groupe
	 * @param x : position x de la souris (dans le tableau de jeu)
	 * @param y : position y de la souris (dans le tableau de jeu)
	 */
	public void Droite(int x, int y) {
		if(y<14){
		       if(caract[x][y+1] == caract[x][y] && check[x][y+1] != true) {
		
		addToGroupe(x,y+1);
		compte++;
		check[x][y+1] = true;
		Regroupement(x,y+1);
		       }
		}
	}
	
	/** 
	 * Méthode qui sauvegarde les positions x et y des cases dans le tableau appartenant au groupe
	 * @param x : position x de la case appartenant au groupe (dans le tableau)
	 * @param y : position y de la case appartenant au groupe (dans le tableau)
	 */ 
	public void addToGroupe(int x,int y) {
	memoireX[compte] = x;
	memoireY[compte] = y;
	// compte est le nombre de case dans le groupe
	}
	


	/**
	 * Méthode qui renvoie les positions x des cases appartenant au groupe
	 * @return position x des cases du groupe
	 */
	public int[] getGroupeX() {
	return memoireX;
	}
	
	/**
	 * Méthode qui renvoie les positions y des cases appartenant au groupe
	 * @return position y des cases du groupe
	 */

	public int[] getGroupeY() {
	return memoireY;
	}
	
	/**
	 * Méthode qui renvoie la taille du groupe
	 * @return taille du groupe
	 */

	public int getCompteur() {
	return compte;
	}
	
	/**
	 * Méthode crée un tableau de booléen (si on check la case du dessous et que le boolean est faux alors on peut ajouter la case au groupe)
	 */
	public void booleanTab() {
	for(int i = 0; i<10; i++) {
		for(int j = 0; j<15; j++) {
		check[i][j] = false;
		}
	}
	}
}

