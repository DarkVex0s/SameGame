/**
 * Cette class gère toutes les actions réalisées depuis la grille de jeu, que ce soit le survol ou le clique
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionSouris implements MouseListener {
	
	private JLabel[][] tab;
	private char[][] caract;
	private int score = 0;
	private boolean boolfinjeu = true;
	private JFrame jeu;
	private JLabel theScore;
	private int cumulatedScore = 0;
	
	/**
	 * Constructeur de la class ActionSouris
	 * @param tableau : contient toutes les images (en somme, c'est un tableau d'image)
	 * @param chartab : contient la grille de jeu au représentée par des caractères
	 * @param frameJeu : la fenetre de jeu
	 * @param score : le jlabel qui affiche le score
	 */
	public ActionSouris(JLabel[][] tableau,char[][] chartab, JFrame frameJeu, JLabel score) {
	tab = tableau;
	caract = chartab;
	jeu = frameJeu;
	theScore = score;
	}
		
	
	@Override
  		public void mousePressed(MouseEvent e) {
		
  		}

  	@Override
  		public void mouseReleased(MouseEvent e) {

  	}
	
	 @Override
  		public void mouseEntered(MouseEvent e) {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<15; j++) {
		// Compare l'objet qui a effectué l'action avec toutes les cases du tableau jusqu'à ce que la source et la case coïncide
		if(e.getSource() == tab[i][j]) {
		if(caract[i][j] != 'N') {
		Groupement groupe = new Groupement(caract,i,j);
		groupe.Regroupement(i,j);
		int tailleGroupe = groupe.getCompteur();
		int[] memX = new int[tailleGroupe];
		int[] memY = new int[tailleGroupe];
		memX = groupe.getGroupeX();
		memY = groupe.getGroupeY();

		for(int loop = 0; loop < tailleGroupe; loop++) {
		tab[memX[loop]][memY[loop]].setBackground(Color.RED);
		}
				}
		}
			}	
} // fermeture getSource
	 }
	

  	@Override
 		 public void mouseExited(MouseEvent e) {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<15; j++) {
		// Compare l'objet qui a effectué l'action avec toutes les cases du tableau jusqu'à ce que la source et la case coïncide
		if(e.getSource() == tab[i][j]) {
		Groupement groupe = new Groupement(caract,i,j);
		groupe.Regroupement(i,j);
		int tailleGroupe = groupe.getCompteur();
		int[] memX = new int[tailleGroupe];
		int[] memY = new int[tailleGroupe];
		memX = groupe.getGroupeX();
		memY = groupe.getGroupeY();

		for(int loop = 0; loop < tailleGroupe; loop++) {
		tab[memX[loop]][memY[loop]].setBackground(Color.GRAY);
		}
				}
		}
}	
		 
		 
		 } // Fermeture mouseExited
	
	 

  	@Override
  		public void mouseClicked(MouseEvent e) {
 		for(int i = 0; i<10; i++) {
			for(int j = 0; j<15; j++) {
		// Compare l'objet qui a effectué l'action avec toutes les cases du tableau jusqu'à ce que la source et la case coïncide
		if(e.getSource() == tab[i][j]) {
		Groupement groupe = new Groupement(caract,i,j);
		groupe.Regroupement(i,j);
		int tailleGroupe = groupe.getCompteur();
		int[] memX = new int[tailleGroupe];
		int[] memY = new int[tailleGroupe];
		memX = groupe.getGroupeX();
		memY = groupe.getGroupeY();

		if(tailleGroupe>1) {
		for(int loop = 0; loop < tailleGroupe; loop++) {
		tab[memX[loop]][memY[loop]].setIcon(null);
		tab[memX[loop]][memY[loop]].setBackground(Color.GRAY);
		caract[memX[loop]][memY[loop]] = 'N';
		// N pour Nothing soir rien donc sans image
		}
		
		Score score = new Score(tailleGroupe);
		cumulatedScore += score.getScore();
		theScore.setText("Score : " + cumulatedScore);

		Fall tomber = new Fall(caract,tab);
		tomber.checkAllColumns();
		
		Decalage decalage = new Decalage(caract,tab);
		decalage.startCheckup();
		
		FinJeu jeufin = new FinJeu(caract,jeu,cumulatedScore);
		boolfinjeu = jeufin.checkFin();
	

		}
				} // fermeture getSource
		 } // fermeture boucle j
		} // fermeture boucle i	 		
		
		} // fermeture mouseClicked
	

}
