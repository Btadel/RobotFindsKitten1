public class Mur extends Case {
    Point position;

    public Mur(Point position) {
        this.position = position;
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