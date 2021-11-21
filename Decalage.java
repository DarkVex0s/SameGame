/**
 * Cette class s'occupe de décaler les colonnes pleines vers la gauche si une colonne est vide
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class Decalage {
	
	private int columnToCheckAgain = 0;
	private boolean colonneVide = true;
	private boolean colonneGaucheVide = true;
	private boolean previousColumnFull = false;
	
	private char[][] caract;
	private JLabel[][] tab;
	
	/**
	 * Constructeur de la class Decalage
	 * @param tabl : tableau de caractères qui représente la grille de jeu
	 * @param jlb : tableau de JLabel qui contient des JLabel eux-memes contenant les images du jeu
	 */
	public Decalage(char[][] tabl, JLabel[][] jlb) {
	caract = tabl;
	tab = jlb;
	}
	
	/**
	 * Cette méthode lance simplement l'algorithme
	 */
	public void startCheckup() {
	colonneGauche(14);
	}
	
	/**
	 * Méhode qui regarde chaque case x de la colonne y pour savoir si la colonne est pleine ou non
	 * @param y : colonne y
	 */
	public void isColumnEmpty(int y) {
	colonneVide = true;
	for(int x = 0; x < 10; x++) {
		if(caract[x][y] != 'N') {
		colonneVide = false;
		}
	}	
	}
	
	/**
	 * Méhode qui regarde chaque case x-1 de la colonne y pour savoir si la colonne à gauche de notre colonne  est pleine ou non
	 * @param y : colonne y
	 */

	public void isColumnLeftEmpty(int y) {
	colonneGaucheVide = true;
	for(int x = 0; x < 10; x++) {
		if(caract[x][y-1] != 'N') {
		colonneGaucheVide = false;
		}
	}
	}
	
	/**
	 * Méthode (algorithme) qui décale chaque colonne en fonction de la présence de colonne(s) vide(s) 
	 * @param y : colonne y
	 */
	public void colonneGauche(int y) {
	
	if(y != 0) {
	
	isColumnEmpty(y);// Si la colonne où je suis n'est pas vide
	if(colonneVide == false) {

		isColumnLeftEmpty(y);

		// Si la colonne de gauche à celle où on est, est vide alors on échange les colonnes
		
		if(colonneGaucheVide == true) {
		swapColumn(y);
	
		if(previousColumnFull == true) {
			previousColumnFull = false;
			int save = columnToCheckAgain;
			columnToCheckAgain = 0;
			colonneGauche(y+save);
			
		}
		else {	
			colonneGauche(y-1);
		}
		}
	else {
		previousColumnFull = true;
		columnToCheckAgain++;
		colonneGauche(y-1);

	}
}
	// Si la colonne où je suis est vide
	else {
	colonneGauche(y-1);
	}
	
	}
	
}

	/**
	 * Méthode qui échange chaque case entre la colonne actuelle et celle de gauche
	 * @param y : colonne y
	 */
	public void swapColumn(int y) {

	ImageIcon img1 = new ImageIcon("Image/em.png");
  	ImageIcon img2 = new ImageIcon("Image/di.png");
  	ImageIcon img3 = new ImageIcon("Image/rs.png");
		
	for(int x = 0; x<10; x++) {
	caract[x][y-1] = caract[x][y];
	caract[x][y] = 'N';
	tab[x][y].setIcon(null);

	if(caract[x][y-1] == 'R') {
	tab[x][y-1].setIcon(img3);
	}
	
	if(caract[x][y-1] == 'V') {
	tab[x][y-1].setIcon(img1);
	}
	
	if(caract[x][y-1] == 'B') {
	tab[x][y-1].setIcon(img2);
	}

	}
	}


}
