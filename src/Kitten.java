public class Kitten extends Case{
	private Point position;
	private String nom;
	
	public Kitten(String nom, Point position) {
		this.position = position;
		this.nom = nom;
	}
	
	public Point getPosition() {
		return this.position; 
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	public void interagir(Robot robot) {
		System.out.println("You found kitten! Way to go, robot.\n" + this.nom + "<3" + robot.getNom());
	}
	
	@Override
    public char getRepresentation() {
		this.representation = getRandomSymbole();
        return representation;
    }
}
