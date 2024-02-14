public class Mur extends Case {
	public Mur() {
		this.representation = '%';
	}

	@Override
	public Boolean interactionPossible(Robot robot) {
		return false;
	}

	@Override
	public void interagir(Robot robot) {
		return;	
	}

}