public class Porte extends Case{
	
	/*Les objets de type Porte ne prennent qu'un attribut de plus que case :
	le booléen état qui représente si la porte est ouverte ou fermée (true = ouvert, false = fermée) */
	
	private boolean etat; 
	
	public Porte() {
		this.etat = false;
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
	
	@Override
    public char getRepresentation() {
		// La porte sera représentée par un '!' si elle est fermé et par un espace vide si elle est ouverte
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
