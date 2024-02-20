/**
 * classe qui hérite de 'Case', les objets de ce type représentent les murs et leurs attributs.
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Mur extends Case {

	/**
	 * Les objets de type Mur ne prennent aucun attribut de plus que les cases.
	 * Est repésenté par le char '%'.
	 */
	public Mur() {
		this.representation = '%';
	}

	/**
	 * Ils ne peuvent pas interagir avec le robot.
	 *
	 * @param robot Objet qui n'interagit pas avec le mur
	 */
	@Override
	public Boolean interactionPossible(Robot robot) {
		return false;
	}

	/**
	 * Aucune interaction entre le mur et le robot.
	 * Ne retourne rien.
	 *
	 * @param robot Objet qui n'interagit pas avec le mur
	 */
	@Override
	public void interagir(Robot robot) {
		return;
	}

}
