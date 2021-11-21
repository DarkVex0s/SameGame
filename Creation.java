/**
 * Cette class qui crée la grille de jeu
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;

// Class qui créer la grille de jeu de façon aléatoire

public class Creation {
	
	// Récupération du panel qui contient la grille de jeu
	private	JPanel panneau;

	private char[][] charTab;
	private ImageIcon img1,img2,img3;
	private JLabel[][] grille;
	Border bordure = BorderFactory.createRaisedBevelBorder();
	private JFrame jeuGrid;
	private JLabel theScore;
	
	/**
	 * Constructeur de la class Creation
	 * @param panel : le panel qui contient la grille de jeu
	 * @param jeu : la fenetre du jeu
	 * @param score : le JLabel qui contient l'affichage du score
	 */
	public Creation(JPanel panel, JFrame jeu, JLabel score) {
	panneau = panel;
	jeuGrid = jeu;
	theScore = score;
	}
	
	/**
	 * Methode de remplissage de manière aléatoire de la grille de jeu
	 */
	public void aleatoire() {
 	
	img1 = new ImageIcon("Image/em.png");
  	img2 = new ImageIcon("Image/di.png");
  	img3 = new ImageIcon("Image/rs.png");
	
	char[][] chartab = new char[10][15];
	grille = new JLabel[10][15];
	
	ActionSouris mouvement = new ActionSouris(grille,chartab,jeuGrid,theScore);

	// Création du facteur aléatoire pour remplir le tableau en fonction du nombre que j'aurai
	Random rdm = new Random();
	  		
	for(int i = 0; i < 10; i++){
      		for(int j = 0; j < 15; j++){
          	grille[i][j] = new JLabel();
   
		int result = rdm.nextInt(3) +1;
   
       		if(result == 1){
            		grille[i][j].setIcon(img1);
			chartab[i][j] = 'V'; //R
          	}
          	if(result == 2){
            		grille[i][j].setIcon(img2);
			chartab[i][j] = 'B'; //V
          	}
          
		if(result == 3){
            		grille[i][j].setIcon(img3);
          		chartab[i][j] = 'R'; //B
		}

 	  grille[i][j].setBorder(bordure);
      	  grille[i][j].setOpaque(true);
	  grille[i][j].setBackground(Color.GRAY);
	  grille[i][j].addMouseListener(mouvement);
          panneau.add(grille[i][j]);
      }
    }
}
	/**
	 * Methode qui remplis la grille de jeu en fonction d'un fichier choisi
	 */
	public void predefini(char[][] tableau) {
	char[][] jeu = new char[10][15];
	jeu = tableau;

	
	System.out.println("Choix du mode prédéfini");
	System.out.println("Création de votre grille de jeu");

	// chargement des images
	
	img1 = new ImageIcon("Image/em.png");
  	img2 = new ImageIcon("Image/di.png");
  	img3 = new ImageIcon("Image/rs.png");
	
	// Tableau de JLabel, chaque case de ce tableau contiendra un JLabel qui lui meme contient une icone sans texte donc fait office d'image
	grille = new JLabel[10][15];
  	ActionSouris mouvement = new ActionSouris(grille,jeu,jeuGrid,theScore);

	System.out.println("");	

	for(int i = 0; i < 10; i++){
      		for(int j = 0; j < 15; j++){
 
		grille[i][j] = new JLabel();
   		// affiche le tableau de caractère (pour vérifier avec celui qu'on a lu)
	   	System.out.print(jeu[i][j]);
       		
		if(jeu[i][j] == 'R'){
            		grille[i][j].setIcon(img3);
          	}

          	if(jeu[i][j] == 'V'){
            		grille[i][j].setIcon(img1);
          	}
          
		if(jeu[i][j] == 'B'){
            		grille[i][j].setIcon(img2);
          	}       
  	   grille[i][j].setBorder(bordure);
      	   grille[i][j].setOpaque(true); 
    	   grille[i][j].setBackground(Color.GRAY);	   
	   grille[i][j].addMouseListener(mouvement);
    	   panneau.add(grille[i][j]);
  	}
  	  System.out.println("");
  }
	
	
	
	}

}

