public class Teleporteur extends Case{
	
	public Teleporteur() {
		super.representation = 'T';
	}

	@Override
	// Le robot peut toujours interragir avec le téléporteur
	public Boolean interactionPossible(Robot robot) {
		return true;
	}

	@Override
	public void interagir(Robot robot) {
		robot.setTeleporteur(true);
	}

}
