public class Kitten extends Case{
	
	/* Les objets de type kitten prennent un seul type de plus que ceux de type case : un string représentant le nom 
	du Kitten*/
	private String nom;
	
	public Kitten(String nom) {
		this.nom = nom;
		super.representation = getRandomSymbole();
	}

	@Override
	// Peut interragir avec le robot
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	// Interaction entre le Kitten et le robot : le jeu a été gagné!
	public void interagir(Robot robot) {
		System.out.println("You found kitten! Way to go, robot.\n" + this.nom + " <3 " + robot.getNom());
	}
}
