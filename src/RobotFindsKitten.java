import java.util.Scanner;

public class RobotFindsKitten {

	public static void main(String[] args) {
		
		
		/* Faire apparaître le message de début du jeu 
		 */
		
		System.out.println("Bienvenue dans RobotFindsKitten \nSuper Dungeon Master 3000 Ultra Turbo \nEdition !");
		
		
		// Initialiser la grille de jeu

		Grille grilleJeu = new Grille(5,2,12,5,10);

		Point depart = new Point(4,2);
		
		Robot robot = new Robot("R.O.B", depart, 0, false);
		
		// Affichage Initial
		grilleJeu.afficher(robot);
		System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]>");
		
		// Boucle pour bouger le robot 
		while (finDuJeu(grilleJeu, robot) == false) {
		Scanner scanner = new Scanner(System.in);
		char deplacement  = scanner.nextLine().charAt(0);
		deplacerRobot(robot, deplacement, grilleJeu);
		grilleJeu.afficher(robot);
		System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]" + etatTeleporteur(robot) + ">");
		}
	}
		
	// Fonction qui détermine si le jeu est gagné
	
	public static boolean finDuJeu(Grille grille, Robot robot) {
			int posRobotX = robot.getPoint().getX();
			int posRobotY = robot.getPoint().getY();
			Case[][] matrice = grille.getGrille();
			boolean partieTerminee = false;
		
			if (matrice[posRobotX][posRobotY] instanceof Kitten) {
				partieTerminee = true;
			}
			return partieTerminee;
	}
	
	// À FAIRE : - Le robot n'interragit pas avec les objets nonKitten et le teleporteur
	//			 - Le robot peut passer genre cinq fois sur la même clés et avoir cinq clés
	//			 - Fonction à décomposer / optimiser....... beaucoup trop chargée
	
	public static void deplacerRobot(Robot robot, char entree, Grille grille) {
		int positionRobotX = robot.getPoint().getX();
		int positionRobotY = robot.getPoint().getY();
		boolean teleporteur = robot.getTeleporteur();
		
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
		else if (entree == 't' && teleporteur == true ){
			Point teleportation = grille.randomEmptyCell();
			robot.setPoint(teleportation);
		}
		else if (entree != 'a' || entree != 's' || entree != 'd' || entree !='w' || (entree == 't' && teleporteur == false)) {
			System.out.println("Veuillez entrer un charactère accepté");
			return;
		}
		int nouvellePosX = nouvellePos.getX();
		int nouvellePosY = nouvellePos.getY();
		
		Case objet = grille.getGrille()[nouvellePosX][nouvellePosY];
		
		if (objet != null && objet.interactionPossible(robot) != false) {
			objet.interagir(robot);
			
			// Print la description du NonKitten (toujours la même!)
			if (objet instanceof NonKitten) {
				System.out.println(((NonKitten) objet).getDescriptive());
				}
			robot.setPoint(nouvellePos);
			}
		else if (objet == null) {
			robot.setPoint(nouvellePos);
		}
		else {
			System.out.println("Déplacement impossible");
		}
	}
	
	public static String etatTeleporteur(Robot robot) {
		boolean etat = robot.getTeleporteur();
		if (etat == true) {
			return "T"; 
		}
		else {
			return "";
		}
	}
}
