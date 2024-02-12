public class Porte extends Case {
	private Point position;
	private boolean etat; // État de la porte (ouverte ou fermée)

	public Porte(Point position) {
		this.position = position;
		this.etat = false; // La porte est initialement fermée
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return robot.getNbCles() > 0; // Le robot peut interagir avec la porte s'il possède au moins une clé
	}

	@Override
	public void interagir(Robot robot) {
		this.etat = true; // La porte est ouverte
		int nbCles = robot.getNbCles() - 1; // Consommer une clé
		robot.setNbCles(nbCles);
	}

	@Override
	public char getRepresentation() {
		return '!'; // Représentation de la porte dans la grille de jeu
	}
}
