import java.util.Scanner;

public class devoir1Main {

    public static void main(String[] args) {

        /* Faire apparaître le message de début du jeu
         */

        System.out.println("Bienvenue dans RobotFindsKitten \nSuper Dungeon Master 3000 Ultra Turbo \nEdition !");

        Grille grilleJeu = new Grille(5,2,12,5,10);
        System.out.println(grilleJeu);

        Point depart = new Point(0,0);

        //Robot robot = new Robot("R.O.B", depart, 0, false);

        //System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]>");

        Scanner scanner = new Scanner(System.in);
        String deplacement  = scanner.nextLine();


    }

}