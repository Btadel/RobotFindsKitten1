/**
 * Classe qui hérite de 'Case' et qui représente les portes et leurs attributs
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Porte extends Case{
	
	/*Les objets de type Porte ne prennent qu'un attribut de plus que case :
	le booléen état qui représente si la porte est ouverte ou fermée (true = ouvert, false = fermée). */

	private boolean etat;

	/**
	 * Constructeur qui génère une porte initialement fermée et
	 * définie par le symbole '!'.
	 */
	public Porte() {
		this.etat = false;
		this.representation = '!';
	}

	/**
	 * Le robot ne peut interagir avec une porte que s'il a une clé ou si la porte est déjà ouverte.
	 * @param robot Objet qui intéragit avec la porte.
	 * @return True si une intéraction est possible, sinon False.
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {

		if (robot.getNbCles() != 0 || this.etat == true) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Les deux manière dont peut interagir un robot avec une porte.
	 * Si elle est déja ouverte ou s'il ouvre la porte.
	 * @param robot Objet qui intéragit avec la porte.
	 */
	@Override
	public void interagir(Robot robot) {

		// Le robot ouvre la porte, elle devient ouverte.
		if (this.etat == false) {
			this.etat = true;

			// La clé a été utilisée.
			int nbCles = robot.getNbCles()-1;
			robot.setNbCles(nbCles);
		}
		else {
			return;
		}

	}

	/**
	 * Indique si la porte est fermée ou ouverte.
	 * 
	 * @return 'etat' un booleen représentant l'état ouvert ou fermé de la porte.
	 */
	public boolean getEtat() {
		return this.etat;
	}

}
