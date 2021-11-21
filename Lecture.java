/**
 * Cette classe s'occupe de la gestion de la lecture et de l'interprétation du fichier choisi
 *
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */
import java.io.*;

public class Lecture {
	
	private String fichierOuvert;
	private int caractereLu;
	private char[][] tab;
	/** 
	 * Constructeur de la classe Lecture
	 * @param fichier : fichier qui a été selectionné
	 */
	public Lecture(String fichier) {
	fichierOuvert = fichier;
	}
	
	/** 
	 * Methode qui crée un tableau en fonction des caracteres lu dans le fichier selectionnné
	 * @return char[][] tab : renvoie le tableau de caractères remplis parce qu'il a lu
	 */
	public char[][] Ouverture() {
	
	// Création d'un tableau de char stockant les caractères lus du fichier et que je return à la fin pour pouvoir donner ce tableau de char
	// a ma class qui s'occupe de créer la grille quand c'est de façon non-aléatoire.
	//
	tab = new char[10][15];
	
	try {
	//Ouverture du fichier sélectionné	
	FileReader fr = new FileReader(fichierOuvert);
	BufferedReader br = new BufferedReader(fr);

	// De la mise en page
	System.out.println("");
	System.out.println("-----------------------------------------");
	System.out.println("");
	System.out.println("Fichier correctement ouvert !");
	System.out.println("");
	
	for(int ligne = 0; ligne < 10; ligne++) {
		for(int colonne = 0; colonne < 15; colonne++) {
		
		caractereLu = br.read();
		
		if(caractereLu == 86) {
			System.out.print("V");
			tab[ligne][colonne] = 'V';
		}
		
		if(caractereLu == 82) {
			System.out.print("R");
			tab[ligne][colonne] = 'R';
		}
		
		if(caractereLu == 66) {
			System.out.print("B");
			tab[ligne][colonne] = 'B';
		}

		}
	// le skip() permet de ne pas lire le caractère de saut de ligne
		br.skip(1);
		System.out.println("");
	}

	//Mise en page
	System.out.println("");
	System.out.println("Fin de la lecture");
	System.out.println("");
	System.out.println("-----------------------------");
	System.out.println("");
	
	fr.close();
	}catch(IOException errorReade) {
	System.out.println("Erreur dans l'ouverture ou la lecture");
	}
	// return de mon tableau de caractère contenu dans le fichier, je l'envoie vers grille qui l'envoie vers creation pour mettre une image en
	// fonction du caractere de ce tableau
	return tab;
	}
}
