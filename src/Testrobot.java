public class Testrobot {
    public static void main(String[] args) {
        //
        Point initialPosition = new Point(0, 0);

        //
        Robot robot = new Robot("Robbie", initialPosition, 0, false);

        // les get
        System.out.println("Robot nom: " + robot.getNom());
        System.out.println("Robot position: " + robot.getPoint());
        System.out.println("Nombre de clé : " + robot.getNbCles());
        System.out.println("teleporter: " + robot.hasTeleporteur());

        // cle
        robot.ramasserCle();
        System.out.println("nbr cle maj: " + robot.getNbCles());

        //nouvel pos
        Point newPosition = new Point(5, 5);
        robot.setPoint(newPosition);
        System.out.println("Nouvelle pos: " + robot.getPoint());
    }
}