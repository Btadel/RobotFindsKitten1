public class Porte extends Case{
	
	// Le booléen état représente si la porte est ouverte ou fermée
	
	private boolean etat; 
	
	public Porte() {
		this.etat = false;
	}
	
	@Override
	public Boolean interactionPossible(Robot robot) {
		if (robot.getNbCles() != 0 || this.etat == true) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void interagir(Robot robot) {
		if (this.etat == false) {
			this.etat = true; 	
			int nbCles = robot.getNbCles()-1;
			robot.setNbCles(nbCles);
		}
		else {
			return;
		}
		
	}
	
	@Override
    public char getRepresentation() {
		if (this.etat == false) {
		this.representation = '!';
        return representation;
		}
		else {
			this.representation = ' ';
			return representation;
		}
	}
}
