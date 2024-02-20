/**
 * classe qui hérite de 'Case'
 *
 * @author Adèle Pmerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Kitten extends Case{

	/* Les objets de type kitten prennent un seul type de plus que ceux de type case : un string représentant le nom 
	du Kitten*/
	private String nom;

	/**
	 * Initialise le Kitten avec un nom et un symbol aléatoire.
	 *
	 * @param nom Le nom du kitten
	 */
	public Kitten(String nom) {
		this.nom = nom;
		super.representation = getRandomSymbole();
	}

	/**
	 * Peut interragir avec le robot
	 *
	 * @param robot
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	/**
	 *Interaction entre le Kitten et le robot : le jeu a été gagné!
	 *
	 * @param robot
	 */
	@Override
	public void interagir(Robot robot) {
		System.out.println("You found kitten! Way to go, robot.\n" + this.nom + " <3 " + robot.getNom());
	}
}
