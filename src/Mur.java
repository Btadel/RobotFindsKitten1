/**
 * classe qui hérite de 'Case'
 *
 * @author Adèle Pmerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Mur extends Case {

	/**
	 * Les objets de type Mur ne prennent aucun attribut de plus que les cases.
	 * Est repésenté par l'objet '%'.
	 */
	public Mur() {
		this.representation = '%';
	}

	/**
	 * Ils ne peuvent pas interragir avec le robot.
	 *
	 * @param robot Objet qui n'interragit pas avec le mur
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {
		return false;
	}

	/**
	 * Aucune intéraction entre le mur et le robot.
	 * Ne retourne rien.
	 *
	 * @param robot Objet qui n'interragit pas avec le mur
	 */
	@Override
	public void interagir(Robot robot) {
		return;
	}

}
