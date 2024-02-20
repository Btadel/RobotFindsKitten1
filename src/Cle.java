/**
 * Classe qui hérite de 'Case'.
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Cle extends Case {

	/** Les objets de type Cle ne prennent qu'un seul attribut de plus que case : leur état d'utilisation 
	 (true si elle a été utilisée et false dans le cas contraire) */
	private boolean utilisation;

	/**
	 * Initialise la clef.
	 */
	public Cle() {
		this.utilisation = false;
		this.representation = '\'';
	}

	/**
	 * Indique que l'intéraction est possible lorsqu'il est appelé par un robot.
	 * @param robot Objet
	 * @return True
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	/**
	 * Fonction qui détermine si le robot peut interragir avec la clé
	 * @param robot Objet
	 */
	@Override
	public void interagir(Robot robot) {

		// Si la clé n'est pas utilisée
		if (!utilisation) {
			int nbCles = robot.getNbCles() + 1;
			robot.setNbCles(nbCles);
			utilisation = true;
		}

		// Si la clé a été utilisée, aucune interaction est permise
		else {
			return;
		}
	}

	/**
	 * Getter qui permet de savoir si la clef a été utilisé ou non.
	 * @return La valeur d'utilisation pour les clefs.
	 */
	public boolean getUtilisation() {
		return this.utilisation;
	}

	/**
	 * Setter qui met à jour la valeur de d'utilisation d'une clef.
	 */
	public void setUtilisation(boolean utilise) {
		this.utilisation = utilise;
	}
}
