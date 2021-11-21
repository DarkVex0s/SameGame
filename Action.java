/**
 * Cette classe contient les actions listener du menu principale
 * 
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Action implements ActionListener {
	
	private String boutonAction;
	private JFrame window;
	
	/**
	 * Constructeur de la classe Action
	 * @param action : texte que contient le bouton cliqué
	 * @param frame : fenetre du menu principale
	 */
	public Action(String action,JFrame frame) {
	boutonAction = action;
	window = frame;
	};

	/**
	 * Création des actions listener en fonction du bouton qui est appuyé
	 * @param evt : evenement
	 */
	public void actionPerformed(ActionEvent evt) {
	
		if(boutonAction == "play") {
		System.out.println("Lancement du jeu");
		window.setVisible(false);
		// le 1 précise le mode de jeu 1 donc dans ma class Grille, le 1 correspond à l'aléatoire donc permet de créer une grille aléatoire
		// Le null vient pour préciser que je veux pas préciser de tableau de char (utile que pour une grille prédéfini)

		Grille jeu = new Grille(1,null);
		jeu.GrilleJeu();
		}
		
		if(boutonAction == "fichier") {
		System.out.println("");
		System.out.println("Choississez votre fichier");
		JFileChooser fichier = new JFileChooser(".");
		File fichierOuvert;
		String nomFichier;

		if(fichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		fichierOuvert = fichier.getSelectedFile();
		// Récupère uniquement le nom du fichier et non son chemin
		nomFichier = fichierOuvert.getName();
		System.out.println("Votre fichier a bien été ouvert : " + nomFichier);
		window.setVisible(false);
		Lecture jeuFichier = new Lecture(nomFichier);
		// Mode de jeu 2 donc grille prédéfini, le deuxième argument de la création de mon objet class est une methode de la class Lecture
		// qui renvoie un tableau de char pour créer la grille prédéfinie	

		Grille jeu = new Grille(2,jeuFichier.Ouverture());
		jeu.GrilleJeu();
		}
		}

		if(boutonAction == "leave") {
		System.out.println("Au revoir ...");
		System.exit(0);
		}
	}
}

