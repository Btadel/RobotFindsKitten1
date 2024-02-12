public class Cle extends Case {
	private Point position;

	public Cle(Point position) {
		this.position = position;
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	public void interagir(Robot robot) {
		int nbCles = robot.getNbCles() + 1;
		robot.setNbCles(nbCles);
	}

	@Override
	public char getRepresentation() {
		return '\''; // Représentation de la clé dans la grille de jeu
	}

	// Méthodes pour obtenir et modifier la position de la clé
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}

