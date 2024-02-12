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
		
		// Affichage Initial
		grilleJeu.afficher(robot);
		System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]>");
		
		// Boucle pour bouger le robot 
		while (finDuJeu(kitten, robot) == false) {
		Scanner scanner = new Scanner(System.in);
		char deplacement  = scanner.nextLine().charAt(0);
		deplacerRobot(robot, deplacement, grille);
		grilleJeu.afficher(robot);
		System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]>");
		}
	}
		
	// Fonction qui détermine si le jeu est gagné
	
	public static boolean finDuJeu(Kitten kitten, Robot robot) {
			Point posKitten = kitten.getPosition();
			Point posRobot = robot.getPoint();
			boolean partieTerminee = false;
		
			if (posKitten == posRobot) {
				partieTerminee = true;
			}
			return partieTerminee;
	}
	
	// À FAIRE : - Le robot n'interragit pas avec les objets nonKitten et le teleporteur
	//			 - Le robot peut passer genre cinq fois sur la même clés et avoir cinq clés
	
	public static void deplacerRobot(Robot robot, char entree, Case[][] grille) {
		int positionRobotX = robot.getPoint().getX();
		int positionRobotY = robot.getPoint().getY();
		Point nouvellePos = null;
		
		if (entree == 'a') {
			nouvellePos = new Point(positionRobotX-1,positionRobotY);
			}
		else if (entree == 'w') {
			nouvellePos = new Point(positionRobotX,positionRobotY-1);
		}
		else if (entree == 's') {
			nouvellePos = new Point(positionRobotX,positionRobotY+1);
		}
		else if (entree == 'd') {
			nouvellePos = new Point(positionRobotX+1,positionRobotY);
		}
		int nouvellePosX = nouvellePos.getX();
		int nouvellePosY = nouvellePos.getY();
		
		Case objet = grille[nouvellePosX][nouvellePosY];
		
		if (objet != null && objet.interactionPossible(robot) != false) {
			objet.interagir(robot);
			robot.setPoint(nouvellePos);
			}
		if (objet == null) {
			robot.setPoint(nouvellePos);
		}
		else {
			System.out.println("Déplacement impossible");
		}
	}
	
	
}
