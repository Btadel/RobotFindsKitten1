package devoir1;

public class Teleporteur extends Case{
	private Point position;
	
	public Teleporteur(Point position) {
		this.position = position;
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	public void interagir(Robot robot) {
		robot.setTeleporteur(true);
	}
	
	@Override
    public char getRepresentation() {
		this.representation = getRandomSymbole(); 
		return representation;
	}

}
