/**
 * Class qui s'occupe de regarder si l'on peut encore jouer ou non (en fonction de la présence d'au moins un groupe de taille 2 ou plus
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class FinJeu {
		
	private boolean winner = true;
	private char[][] caract;
	private int tailleGroupe = 0;
	private JFrame jeuGrid;
	private int scoreFinal = 0;
	
	/**
	 * Constructeur de la class FinJeu
	 * @param chartab : tableau de caractères représentant le tableau de jeu
	 * @param jeu : fenetre du jeu
	 * @param scoreFin : sauvegarde du score final si jamais la partie est finie
	 */
	public FinJeu(char[][] chartab,JFrame jeu, int scoreFin) {
	caract = chartab;
	jeuGrid = jeu;
	scoreFinal = scoreFin;
	}
	
	/**
	 * Méthode qui renvoie un booléen pour savoir si la partie est finie ou non
	 * @return boolean true ou false, false = partie peut continuer
	 */
	public boolean checkFin() {
	
	boolean fin = false;
	int ligne = 0;
	int colonne = 0;

	while(ligne<10 && fin == false) {
		while(colonne<15 && fin == false) {
		
		Groupement groupe = new Groupement(caract,ligne,colonne);
		groupe.Regroupement(ligne,colonne);
		tailleGroupe = groupe.getCompteur();
		if(tailleGroupe > 1) {
			fin = true;
		}
		
		colonne++;

		} // fin boucle colonne
	colonne = 0;
	ligne++;
	} // fin boucle ligne
	
	if(fin == false) {
	gagnant();
	EndScreen ecranfin = new EndScreen(winner,jeuGrid,scoreFinal);
	ecranfin.EndWindow();
	}
	

	return fin;
	}

	/**
	 * Méthode qui regarde si on a gagné ou perdu la partie (s'il reste une image dans la grille ou si elle est vide
	 */
	public void gagnant() {
	
	// On parcourt tout le tableau et si jamais on trouve un caractère de type autre que N (donc une case pas vide) alors on a perdu
	for(int x = 0; x < 10; x++) {
		for(int y = 0; y < 15; y++) {
			if(caract[x][y] != 'N') {
			winner = false;
			}
		}
	}
       }

}
