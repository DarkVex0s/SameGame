/** 
 * Class qui crée la fenetre de fin de jeu
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;

public class EndScreen {
	
	private JFrame closeGrid;
	private boolean win;
	private int finalScore;
	
	/**
	 * Constructeur de la class EndScreen
	 * @param gagnant : boolean qui nous informe si on a gagné ou perdu
	 * @param jeu : fenetre de jeu
	 * @param scoreFin : le score final
	 */
	public EndScreen(boolean gagnant,JFrame jeu,int scoreFin) {
	win = gagnant;
	closeGrid = jeu;
	finalScore = scoreFin;
	}
	
	/**
	 * Méthode qui crée la fenetre de fin de jeu
	 */
	public void EndWindow() {
	
	closeGrid.setVisible(false);

	JFrame fenetre = new JFrame();
	fenetre.setSize(800,500);
	fenetre.setLocationRelativeTo(null);
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel pan = new JPanel();
	pan.setBackground(Color.LIGHT_GRAY);

	JLabel lbl = new JLabel();
	lbl.setFont(new Font("Serif", Font.BOLD, 40));

	if(win == true) {
	lbl.setText("Vous avez gagné");
	}
	else {
	lbl.setText("Vous avez perdu");
	}	

	JPanel buttonPan = new JPanel();
	buttonPan.setLayout(new FlowLayout());
	buttonPan.setBackground(Color.GRAY);
	

	// Bouton rejouer avec actionlistener
	JButton rejouer = new JButton("Rejouer");
	rejouer.setPreferredSize(new Dimension(400,100));
	EndAction a1 = new EndAction("rejouer",fenetre);
	rejouer.addActionListener(a1);
	
	JPanel showScore = new JPanel();
	JLabel scoreTXT = new JLabel("Score final : " + finalScore);
	scoreTXT.setFont(new Font("Serif", Font.BOLD, 20));
	showScore.add(scoreTXT);

	FondEcran fond = new FondEcran();
	
	Color sky = new Color(121,174,221);
	pan.setBackground(sky);

	pan.add(lbl, BorderLayout.CENTER);
	buttonPan.setLayout(new GridLayout(2,1));
	buttonPan.add(rejouer);
	buttonPan.add(showScore);
	
	JPanel conteneur = new JPanel();
	
	conteneur.add(buttonPan);
	conteneur.setPreferredSize(new Dimension(800,100));
	buttonPan.setPreferredSize(new Dimension(300,100));
	
	fenetre.add(pan, BorderLayout.NORTH);
	fenetre.add(conteneur,BorderLayout.SOUTH);
	fenetre.add(fond);
	fenetre.setVisible(true);
	}
}
