/**
 * Cette class gère la chute des cases au dessus de celle qui sont détruites
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class Fall {
	
	private char[][] caract;
	private JLabel[][] tab;
	
	/**
	 * Constructeur de la class Fall
	 * @param tabl : tableau de caractère qui représente la grille de jeu au format caractère
	 * @param jlb : tableau de JLabel où chaque case contient un JLabel avec une image du jeu
	 */
	public Fall(char[][] tabl, JLabel[][] jlb) {
	caract = tabl;
	tab = jlb;
	}
	
	/**
	 * Cette méthode va enclencher l'algorithme de chute pour chaque colonne du jeu, en comment par la plus à gauche
	 */
	public void checkAllColumns() {
	for(int y = 0; y < 15; y++) {
		Dessous(0,y);
	}	
	}
	

	/**
	 * Méthode qui check la case actuelle si elle contient quelque chose, si oui, si la case du dessous est vide alors on permute le contenu, sinon il check la case suivante
	 * @param x : ligne
	 * @param y : colonne
	 */
	
	public void Dessous(int x, int y) {
	
	ImageIcon img1 = new ImageIcon("Image/em.png");
  	ImageIcon img2 = new ImageIcon("Image/di.png");
  	ImageIcon img3 = new ImageIcon("Image/rs.png");
	
	if(x!=9) {
		if(caract[x][y] != 'N' && caract[x+1][y] == 'N') {
		
		if(caract[x][y] == 'R') { caract[x+1][y] = 'R' ; tab[x+1][y].setIcon(img3); }
		if(caract[x][y] == 'B') { caract[x+1][y] = 'B' ; tab[x+1][y].setIcon(img2); }
		if(caract[x][y] == 'V') { caract[x+1][y] = 'V' ; tab[x+1][y].setIcon(img1); }
		
		caract[x][y] = 'N';
		tab[x][y].setIcon(null);
		if((x-1) >= 0 && caract[x-1][y] != 'N') {
		Dessous(x-1,y);
		}
		else Dessous(x+1,y);
		}
	else Dessous(x+1,y);
	}
	}
 
}
