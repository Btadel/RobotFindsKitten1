public class Teleporteur extends Case{
	
	/* À faire : - fonction qui permet de se téléporter à n'importe quel endroit dans la grille
	 * 
	 */
	
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
