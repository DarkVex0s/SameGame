/**
 * Cette classe calcul et renvoie le score du groupe sur lequel on vient de cliquer
 * @author Valentin MARTIN et Thibault ANDRIA
 * @version 1.0
 */

public class Score {
	
	private int taille = 0;
 	
	/**
	 * Constructeur de la class Score
	 * @param tailleGroupe : taille du groupe qui a été cliqué
	 */
	public Score(int tailleGroupe) {
	taille = tailleGroupe;
	}
	
       /**
	* Methode qui renvoie le score du groupe qu'on vient de cliquer
	*@return le score en fonction de la taille du groupe 
	*/
	
	public int getScore() {
	return ((taille-2)*(taille-2));
	}
}
