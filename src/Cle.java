public class Cle extends Case {
	
	/** Les objets de type Cle ne prennent qu'un seul attribut de plus que case : leur état d'utilisation 
	(true si elle a été utilisée et false dans le cas contraire) */
	private boolean utilisation;
	
	public Cle() {
		this.utilisation = false;
		this.representation = '\'';
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	// Fonction qui détermine si le robot peut interragir avec la clé
	public void interagir(Robot robot) {
		
		// Si la clé n'est pas utilisée
		if (!utilisation) {
			int nbCles = robot.getNbCles() + 1;
			robot.setNbCles(nbCles);
			utilisation = true;
		}
		
		// Si la clé a été utilisée, aucune interaction est permise
		else {
			return;
		}
	} 
	
	public boolean getUtilisation() {
		return this.utilisation;
	}
	
	public void setUtilisation(boolean utilise) {
		this.utilisation = utilise;
	}
}
