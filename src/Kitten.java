public class Kitten extends Case{
    private Point position;

    public Kitten(Point position) {
        this.position = position;
    }

    @Override
    public Boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot) {
        System.out.println("You found kitten! Way to go, robot.\nCaramel ❤ R.O.B.");
    }

}
