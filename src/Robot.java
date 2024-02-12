public class Robot {
	private String nom;
	private Point position;
	private int nbCles;
	private boolean teleporteur;

	public Robot(String nom, Point position, int nbCles, boolean teleporteur) {
		this.nom = nom;
		this.position = position;
		this.nbCles = nbCles;
		this.teleporteur = teleporteur;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Point getPoint() {
		return this.position;
	}

	public void setPoint(Point position) {
		this.position = position;
	}

	public int getNbCles() {
		return this.nbCles;
	}

	public void setNbCles(int nbCles) {
		this.nbCles = nbCles;
	}

	public boolean hasTeleporteur() {
		return this.teleporteur;
	}

	public void setTeleporteur(boolean teleporteur) {
		this.teleporteur = teleporteur;
	}

	// Méthode pour ramasser une clé
	public void ramasserCle() {
		this.nbCles++;
	}

	// Méthode pour utiliser le téléporteur
	public void utiliserTeleporteur() {
		// Implémentez ici la logique pour utiliser le téléporteur
		this.teleporteur = false; // Par exemple, désactiver le téléporteur après utilisation
	}

	// Méthode pour afficher l'état actuel du robot
	public void afficherEtat() {
		System.out.println("Nom du robot : " + this.nom);
		System.out.println("Position : (" + this.position.getX() + ", " + this.position.getY() + ")");
		System.out.println("Nombre de clés : " + this.nbCles);
		System.out.println("Téléporteur : " + (this.teleporteur ? "Oui" : "Non"));
	}
}

	


