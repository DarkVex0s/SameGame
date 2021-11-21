/**
 * Cette classe permet de créer l'écran du menu principale
 * @author valentin MARTIN et Thibault ANDIRA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcranJeu {
	
	private JButton play,fichier,leave;
	private JFrame fenetre;
	
	/**
	 * Méthode qui créé la fenetre du menu principale
	 */
	public void debut() {
	
	// Création de la fênetre de départ (d'accueil) lors du lancement du jeu
	fenetre = new JFrame();
	fenetre.setSize(1300,700);
	fenetre.setLocationRelativeTo(null);
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setTitle("SameGame");
	
	JPanel boutons = new JPanel();
	JPanel copyright = new JPanel();
	JPanel panneau = new JPanel();

	boutons.setLayout(new FlowLayout());
		
	play = new JButton("Jouer");
	play.setPreferredSize(new Dimension(100,50));
	fichier = new JButton("Grille prédéfinie");
	fichier.setPreferredSize(new Dimension(200,50));
	leave = new JButton("Quitter");
	leave.setPreferredSize(new Dimension(100,50));
	JLabel createurs = new JLabel("Valentin MARTIN & Thibault ANDRIA");
	
	Action a1 = new Action("play",fenetre);
	Action a2 = new Action("fichier",fenetre);
	Action a3 = new Action("leave",fenetre);

	play.addActionListener(a1);
	fichier.addActionListener(a2);
	leave.addActionListener(a3);
	
	boutons.setPreferredSize(new Dimension(500,100));
	panneau.setPreferredSize(new Dimension(200,75));	
	
	boutons.add(play);
	boutons.add(fichier);
	boutons.add(leave);
	panneau.add(boutons, BorderLayout.SOUTH);
	
	FondEcran fond = new FondEcran();
	
	fenetre.add(fond);
	
	Color sky = new Color(121,174,221);
	panneau.setBackground(sky);
	boutons.setBackground(sky);
	copyright.setBackground(sky);

	copyright.add(createurs);
	fenetre.add(panneau,BorderLayout.NORTH);
	fenetre.add(copyright,BorderLayout.SOUTH);
	fenetre.setVisible(true);
	}

}
