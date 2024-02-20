/**
 * Classe qui hérite de 'Case'
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Teleporteur extends Case{
	/**
	 * Constructeur qui initialise un téléporteur.
	 * lorsqu'affiché visuellement dans la grille de jeu, il est représenté par le charactère 'T'.
	 */
	public Teleporteur() {
		super.representation = 'T';
	}

	/**
	 * Le robot peut toujours interagir avec le téléporteur.
	 * @param robot Objet qui représente le robot
	 * @return True
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	/**
	 * Le robot a trouvé le téléporteur.
	 * @param robot Objet
	 */
	@Override
	public void interagir(Robot robot) {
		robot.setTeleporteur(true);
	}

}
