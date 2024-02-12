public class Mur extends Case {
	private Point position;

	public Mur(Point position) {
		this.position = position;
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return false; // Le robot ne peut pas interagir avec un mur
	}

	@Override
	public void interagir(Robot robot) {
		// Rien ne se passe lorsque le robot interagit avec un mur
	}

	@Override
	public char getRepresentation() {
		return '%'; // Représentation du mur dans la grille de jeu
	}
}