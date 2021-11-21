/**
 * Class EndAction qui contient les actions pour le clique sur le bouton rejouer (qui relance la partie)
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EndAction implements ActionListener {
	
	private String boutonAction;
	private JFrame window;
	
	/**
	 * Constructeur de la class EndAction
	 * @param actionrejouer : contient le texte contenu dans le bouton
	 * @param fenetre : fenetre de jeu
	 */
	public EndAction(String actionrejouer, JFrame fenetre) {
	boutonAction = actionrejouer;
	window = fenetre;
	};
	
	/**
	 * Methode qui ferme la fenetre du menu de fin et relance la partie
	 * @param evt : evenement
	 */
	public void actionPerformed(ActionEvent evt) {
	
		if(boutonAction == "rejouer") {
		System.out.println("Restarting . . .");
		window.setVisible(false);
		EcranJeu start = new EcranJeu();
		start.debut();
		}
	}
}
