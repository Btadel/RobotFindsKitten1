public class Porte extends Case{
	
	/*Les objets de type Porte ne prennent qu'un attribut de plus que case :
	le booléen état qui représente si la porte est ouverte ou fermée (true = ouvert, false = fermée) */
	
	private boolean etat; 
	
	public Porte() {
		this.etat = false;
		this.representation = '!';
	}
	
	@Override
	public Boolean interactionPossible(Robot robot) {
		
		// Le robot ne peut interragir avec une porte que s'il a une clé ou si la porte est déjà ouverte
		if (robot.getNbCles() != 0 || this.etat == true) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void interagir(Robot robot) {
		
		// Le robot ouvre la porte, elle devient ouverte
		if (this.etat == false) {
			this.etat = true; 	
		
		// La clé a été utilisée
			int nbCles = robot.getNbCles()-1;
			robot.setNbCles(nbCles);
		}
		else {
			return;
		}
		
	}
	
	public boolean getEtat() {
		return this.etat;
	}
	
}
