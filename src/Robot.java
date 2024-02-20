/**
 * Représentation du robot
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Robot {

    // ATTRIBUTS : Les objets de type robot prennent quatres paramètres.
	private String nom;            // Nom du robot
	private Point point;           // Position (x,y) sur la grille
	private int nbCles;            // Nombre de clefs collectées non utilisées
	private boolean teleporteur;   // si en possesion du téléporteur

	// Constructeur
	/**
	 * Crée un robot avec un nom, une position, un nombre de clés et l'état du téléporteur.
	 *
	 * @param nom nom du robot
	 * @param point position du robot en un point (x,y)
	 * @param nbCles nombre de clefs en sa possession
	 * @param teleporteur l'état du téléporteur
	 */
	public Robot(String nom, Point point, int nbCles, boolean teleporteur) {
		this.nom = nom;
		this.point = point;
		this.nbCles = nbCles;
		this.teleporteur = teleporteur;
	}

	// Getters et setters pour chaque attribut du robot
	/**
	 * Getter qui récupère la valeur du nom
	 * 
	 * @return nom un string contenant le nom du robot
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Permet de mettre à jour la valeur de l'attribut nom d'un robot.
	 *
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter qui récupère la valeur de la position
	 */
	public Point getPoint() {
		return this.point;
	}

	/**
	 * Permet de mettre à jour la position d'un robot en fournissant une nouvelle position comme argument.
	 *
	 * @param point
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * Getteur qui récupère la valeur int du nombre de clé en possession du robot.
	 * 
	 * @return nbCles un int indiquant le nombre de clés du robot
	 */
	public int getNbCles() {
		return this.nbCles;
	}

	/**
	 * Permet de mettre à jour le nombre de clés détenues par un objet Robot.
	 *
	 * @param nbCles
	 */
	public void setNbCles(int nbCles) {
		this.nbCles = nbCles;
	}

	/**
	 * Getter qui récupère si oui ou non le robot à renconteé un télépoteur.
	 * 
	 * @return teleporteur le booleen indiquant si le robot possède ou non un teleporteur
	 */
	public boolean getTeleporteur() {
		return this.teleporteur;
	}

	/**
	 * Permet de mettre à jour l'état de téléporteur d'un robot.
	 *
	 * @param teleporteur
	 */
	public void setTeleporteur(boolean teleporteur) {
		this.teleporteur = teleporteur;
	}

}
