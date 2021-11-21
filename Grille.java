/** 
 * Ceci est la classe Grille qui crée la fenetre de jeu et les éléments comme les panels du score et du jeu
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Grille {

	private int modejeu;
	private char[][] chararray;
	private JFrame fenetre;

	/**
	 * Constructeur de la classe Grille
	 * @param gamemode : récupère le mode de jeu, 1 pour aléatoire, 2 pour un fichier choisi
	 * @param tab : tableau de caractère du jeu (de la grille)
	 */
	public Grille(int gamemode,char[][] tab) {
	modejeu = gamemode;
	chararray = tab;
	}
	
	/**
	 * Méthode qui crée les composants de la fenetre de jeu
	 */
	public void GrilleJeu() {
		
		fenetre = new JFrame();
		fenetre.setSize(1000,750);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pan = new JPanel();
		pan.setBackground(Color.BLUE);
		// Création du panel qui contiendra la grille du jeu, en gridlayout pour pouvoir mettre dans chaque case un jlabel avec image
		pan.setLayout(new GridLayout(10,15));
		
		// Le score au cours du jeu
		JPanel score = new JPanel();
		score.setPreferredSize(new Dimension(450,100));
		score.setBackground(Color.LIGHT_GRAY);
		JLabel currentScore = new JLabel("Score : 0");
		currentScore.setFont(new Font("Serif", Font.BOLD, 40));
		score.add(currentScore);

			
		//Creation de la grille de jeu en fonction du mode de jeu	
		Creation grilleJeu = new Creation(pan,fenetre,currentScore);

		if(modejeu == 1) {
		//methode qui créer aléatoirement la grille
		grilleJeu.aleatoire();	
		}
		
	        if(modejeu == 2) {
		//methode où je précise un tableau de char (celui provenant de la class Lecture) pour pouvoir savoir en fonction du caractere,
		//l'image que je dois mettre
		grilleJeu.predefini(chararray);
		}

		fenetre.add(pan);
		fenetre.add(score,BorderLayout.NORTH);
		fenetre.setVisible(true);
	}
	/**
	 * Méthode qui renvoie la fenetre de jeu
	 */
	public JFrame getJFrame() {
		return fenetre;
	}
}
