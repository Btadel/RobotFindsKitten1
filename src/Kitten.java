/**
 * Classe qui hérite de 'Case'. L'objet Kitten représente le Kitten et ses attributs.
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Kitten extends Case{

	/* Les objets de type kitten prennent un seul attribut de plus que ceux de type case : un string représentant le nom 
	du Kitten*/
	private String nom;

	/**
	 * Constructeur qui initialise le Kitten avec un nom et un symbole aléatoire.
	 *
	 * @param nom Le nom du kitten
	 */
	public Kitten(String nom) {
		this.nom = nom;
		super.representation = getRandomSymbole();
	}

	/**
	 * Peut interagir avec le robot
	 *
	 * @param robot objet qui pourrait interagir avec le kitten.
	 * @return true car l'interaction est possible
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	/**
	 *Interaction entre le Kitten et le robot : le jeu a été gagné!
	 *
	 * @param robot objet qui interagit avec le kitten.
	 */
	@Override
	public void interagir(Robot robot) {
		System.out.println("You found kitten! Way to go, robot.\n" + this.nom + " <3 " + robot.getNom());
	}
}
