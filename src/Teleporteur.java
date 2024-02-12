public class Teleporteur extends Case {
	private Point position;

	public Teleporteur(Point position) {
		this.position = position;
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return true; // Le robot peut toujours interagir avec un téléporteur
	}

	@Override
	public void interagir(Robot robot) {
		// Implémentez ici la logique pour se téléporter à un autre endroit dans la grille
	}

	@Override
	public char getRepresentation() {
		return getRandomSymbole(); // Représentation aléatoire dans la grille de jeu
	}
}

