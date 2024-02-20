public class Mur extends Case {
	
	// Les objets de type Mur ne prennent aucun attribut de plus que les cases.
	public Mur() {
		this.representation = '%';
	}

	@Override
	// Ils ne peuvent pas interragir avec le robot
	public Boolean interactionPossible(Robot robot) {
		return false;
	}

	@Override
	public void interagir(Robot robot) {
		return;	
	}

}