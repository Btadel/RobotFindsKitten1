public class Cle extends Case {
	private boolean utilisation;
	
	public Cle() {
		this.utilisation = false;
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	public void interagir(Robot robot) {
		if (!this.utilisation) {
		int nbCles = robot.getNbCles() + 1;
		robot.setNbCles(nbCles);
		this.setUtilisation(true);
		}
		else {
			return;
		}
	} 
	
	@Override
    public char getRepresentation() {
		if (this.utilisation) {
			this.representation = ' ';
		} 
		else {
			this.representation = '\'';
		}
        return representation;
    }
	
	public boolean getUtilisation() {
		return this.utilisation;
	}
	
	public void setUtilisation(boolean utilise) {
		this.utilisation = utilise;
	}
}
