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
		// Il faut créer un getter et setter nbCles dans la classe Robot
		int nbCles = robot.getNbCles() + 1;
		robot.setNbCles(nbCles);
	} 
	
	@Override
    public char getRepresentation() {
		this.representation = '\'';
        return representation;
    }
	
}
