/** Class qui crée deux images, une du logo du jeu, et une autre qui fait office de fond d'écran
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class FondEcran extends JComponent {
	
	private Image fond,logo;
	
	/**
	 * Constructeur de la class FondEcran
	 */
	public FondEcran() {
		super();
		this.fond = Toolkit.getDefaultToolkit().getImage("Image/minecraft.png");
		this.logo = Toolkit.getDefaultToolkit().getImage("Image/SameGame.png");
	}

	@Override
	
	/**
	 * Redéfinition de la méthode paintComponent qui dessine les 2 images
	 * @param g : Graphics, pinceau
	 */
	protected void paintComponent(Graphics g) {
	Graphics dessin = g.create();

	if(this.isOpaque()) {
	dessin.setColor(this.getBackground());
	dessin.fillRect(0,0,this.getWidth(),this.getHeight());
	}
	
	dessin.drawImage(this.fond,0,0,this.getWidth(),this.getHeight(),this);
	dessin.drawImage(this.logo,this.getWidth()/2-250,20,this);

	}
	
}
