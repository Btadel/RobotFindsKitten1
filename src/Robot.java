public class Robot {
	private String nom; 
	private Point point; 
	private int nbCles;
	private boolean teleporteur;
	
	public Robot(String nom, Point point, int nbCles, boolean teleporteur) {
		this.nom = nom;
		this.point = point;
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
		return this.point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public int getNbCles() {
		return this.nbCles;
	}
	public void setNbCles(int nbCles) {
		this.nbCles = nbCles;
	}
	
	public boolean getTeleporteur() {
		return this.teleporteur;
	}
	public void setTeleporteur(boolean teleporteur) {
		this.teleporteur = teleporteur;
	}
	
}
