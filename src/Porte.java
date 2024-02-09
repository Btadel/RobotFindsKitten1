/*public class Porte extends Case{

    // Le booléen état représente si la porte est ouverte ou fermée

    private Point position;
    private boolean etat;

    public Porte(Point position) {
        this.position = position;
        this.etat = false;
    }

    @Override
    public Boolean interactionPossible(Robot robot) {
        if (robot.getNbCles() != 0 ) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void interagir(Robot robot) {
        this.etat = true;
        int nbCles = robot.getNbCles()-1;
        robot.setNbCles(nbCles);

    }*/