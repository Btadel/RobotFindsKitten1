import java.util.Scanner;

public class RobotFindsKitten {

	public static void main(String[] args) {
		
		
		boolean partieTerminee = false;
		
		/* Faire apparaître le message de début du jeu 
		 */
		
		System.out.println("Bienvenue dans RobotFindsKitten \nSuper Dungeon Master 3000 Ultra Turbo \nEdition !");
		
		
		// Initialiser la grille de jeu

		Grille grilleJeu = new Grille(5,2,12,5,10);
		Case[][] grille = grilleJeu.getGrille();
		
		Point depart = new Point(4,2);
		
		Robot robot = new Robot("R.O.B", depart, 0, false);
		Kitten kitten = new Kitten("Caramel", grilleJeu.randomEmptyCell());
		grilleJeu.afficher(robot);
		
		//**  À FAIRE : définir la méthode afficher 
		/* grilleJeu.afficher(robot);
		 */

		System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]>");
		
		
		/**Permet à l'utilisateur de se déplacer 
		 * À FAIRE : fonction qui analyse ce que l'utilisateur rentre ("a","s","d","w") pour se déplacer
		 * 			 (va changer la position du robot)
		 */
		Scanner scanner = new Scanner(System.in);
		String deplacement  = scanner.nextLine();
		
		}
		
	// Fonction qui détermine si le jeu est gagné
	
	public static boolean finDuJeu(Kitten kitten, Robot robot, boolean partieTerminee) {
			Point posKitten = kitten.getPosition();
			Point posRobot = robot.getPoint();
		
			if (posKitten == posRobot) {
				partieTerminee = true;
			}
			return partieTerminee;
	}
	
}
