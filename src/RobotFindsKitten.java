
import java.util.Scanner;
/**
 * Classe principale.
 *<p>
 *     Contient la logique de la base du jeu.
 * @author Adèle Pomerleau
 * @author Adel tayeb Boudia
 * @author Christelle Semaan
 */
public class RobotFindsKitten {
	/**
	 * La fonction suivante est la fonction principale du jeu. Elle est exécutée lorsque le programme débute.
	 * Le jeu consiste en une grille de murs ('%'), de portes ('!'), de clés ( ' ' ') et de 
	 * caractères ASCII qui représentent des objets aléatoires. L'utilisateur 
	 * déplace un robot ('#') afin de trouver le Kitten caché parmis les objets. 
	 * 
	 * @param args Les arguments
	 */
	public static void main(String[] args) {

		// Faire apparaître le message en début de jeu.
		System.out.println("       Bienvenue dans RobotFindsKitten \nSuper Dungeon Master 3000 Ultra Turbo Edition !");


		/* Initialiser un objet Grille qui représente la grille de jeu. Son constructeur prend cinq paramètres :
		* le nombre de pièces horizontales et verticales, la largeur et la longueur des pièces, ainsi 
		* que le nombre de NonKitten qui se trouvent dans le jeu (incluant le téléporteur).
		*/
		Grille grilleJeu = new Grille(5,2,11,5,20);

		// Choisi et place le robot à une position de départ aléatoire dans la grille de jeu.
		Point depart = grilleJeu.randomEmptyCell();
		Robot robot = new Robot("R.O.B", depart, 0, false);

		// Premier affichage du jeu 
		grilleJeu.afficher(robot);
		System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]>");

		// Boucle qui permet de bouger le robot 
		while (!finDuJeu(grilleJeu, robot)) {
			Scanner scanner = new Scanner(System.in);         // Crée un objet qui lit la saisie du joueur.
			String entree  = scanner.nextLine();              // Lit la saisie du joueur.
			
			if (entree != "") {
				char deplacement = entree.charAt(0);          // Transforme la première lettre de la saisie en 
															  // direction de déplacement du robot.
				
				Point nouvellePos = nouvellePosition(robot, deplacement, grilleJeu);
				deplacerRobot(robot, nouvellePos, grilleJeu); // Déplace le Robot dépendant de la position.
				grilleJeu.afficher(robot);                    // Montre l'état de la grille mis à jour 
															  // avec la nouvelle position du robot
				
				// Affiche le nom du robot, le nombre de clef qu'il a, et l'état du téléporteur.
				System.out.println(robot.getNom() + "[" + robot.getNbCles() + "]" + etatTeleporteur(robot) + ">");
			}
		}
	}


	/**
	 * La méthode fin du jeu détermine si le jeu est gagné.
	 * @param grille Objet Grille qui représente la grille du jeu.
	 * @param robot  Objet Robot qui représente le robot et ses attributs.
	 * @return True si la partie est terminée, False si la partie est encore en cours.
	 */
	public static boolean finDuJeu(Grille grilleJeu, Robot robot) {
		// Récupérer les coordonnées x et y de la position du robot sur la grille en appelant les
		// méthodes getX() et getY() sur l'objet Point associé au robot.
		int posRobotX = robot.getPoint().getX();
		int posRobotY = robot.getPoint().getY();
		Case[][] grille = grilleJeu.getGrille();   // Récupère la matrice de la grille à partir de l'objet 
												   // Grille transmis en tant qu'argument à la méthode.
		boolean partieTerminee = false;            // Indique que le jeu n'est pas terminé initialement.

		if (grille[posRobotX][posRobotY] instanceof Kitten) {
			partieTerminee = true;               // Vérifie si le robot est la même position que le Kitten, si c'est 
												 // le cas termine la partie.
		}
		return partieTerminee;                   // Indique si le jeu est toujours en cours ou non.
	}

	/**
	 * La fonction déplacerRobot déplace le robot selon ce que l'utilisateur 
	 * a saisi comme entrée.
	 * 
	 * @param robot Objet qui représentant le robot à déplacer.
	 * @param nouvellePos un Point représentant la nouvelle position du robot
	 * @param grilleJeu Un objet représentant la grille du jeu.
	 */
	public static void deplacerRobot(Robot robot, Point nouvellePos, Grille grilleJeu) {
		// Retourne les coordonnées x et y de la nouvelle position pour le robot dans le jeu.
		int nouvellePosX = nouvellePos.getX();
		int nouvellePosY = nouvellePos.getY();
		
		Case[][] grille = grilleJeu.getGrille();

		/* Le robot interagit avec un objet si les deux sont à la même position.
		La variable objet est l'objet (de type général case) se trouvant sur cette case de la grille*/
		Case objet = grille[nouvellePosX][nouvellePosY];

		// Interagir avec le robot si c'est possible
		if (objet != null && objet.interactionPossible(robot) != false) {
			objet.interagir(robot);

			// Affiche la description du NonKitten dans le cas où objet en est un
			if (objet instanceof NonKitten) {
				System.out.println(((NonKitten) objet).getDescriptive());
			}
			
			/* Si l'objet est une clé, une porte ouverte ou un téléporteur, alors il disparaitra après l'interaction
			(devient une case vide) */
			if ((objet instanceof Porte && ((Porte) objet).getEtat()) || objet instanceof Cle || objet instanceof Teleporteur) {
				grille[nouvellePosX][nouvellePosY] = null;
				grilleJeu.setGrille(grille);
			}
			
			// Changer la position du robot (son attribut point)
			robot.setPoint(nouvellePos);
		}
		
		// Si la case est vide
		else if (objet == null) {
			robot.setPoint(nouvellePos); // Met à jour la position du robot.
		}
		else {
			return; // Si un objet est présent, mais l'interaction n'est pas possible, retour sans mouvement.
		}
	}
	
	/**
	 * La fonction nouvellePosition calcule une nouvelle position pour le robot selon l'entrée de 
	 * l'utilisateur dans le scanner.
	 * 
	 * @param robot Objet qui représentant le robot à déplacer.
	 * @param entree Un caractère représentant la direction dans laquelle le robot doit se déplacer
	 *               ("a" pour la gauche, "w" pour le haut, "s" pour le bas, "d" pour la droite,
	 *               "t" pour la téléportation).
	 * @param grilleJeu Un objet représentant la grille du jeu.
	 * @return nouvellePos un point représentant la position du robot après l'entrée de l'utilisateur.
	 */
	public static Point nouvellePosition(Robot robot, char entree, Grille grilleJeu) {
		// Chercher la position en X et en Y du robot avec les getters
				int positionRobotX = robot.getPoint().getX();
				int positionRobotY = robot.getPoint().getY();
				
				// Va chercher l'attribut Teleporteur du robot au moment de l'entrée.
				boolean teleporteur = robot.getTeleporteur();
				
				// nouvellePos est la nouvelle position du robot
				Point nouvellePos = null;
				
				// Entrées possibles et les positions qui en résultent
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
				
				/* Si l'utilisateur entre 't' et qu'il possède un téléporteur, il se retouvera à une position aléatoire 
				sur la grille */
				
				else if (entree == 't' && teleporteur){
					// La nouvelle position du robot est une case aléatoire sur la grille
					Point teleportation =  grilleJeu.randomEmptyCell();
					nouvellePos = teleportation;
				}
				
				// Vérifie la validité de la saisie.
				else if (entree != 'a' || entree != 's' || entree != 'd' || entree !='w' || 
						(entree == 't' && teleporteur == false)) {
					
					// Si l'entrée n'est pas valide, il reste au même endroit
					nouvellePos = robot.getPoint();
				}
				
				return nouvellePos;
	}
	
	
	/**
	 * La méthode etatTeleporteur vérifie si le robot possède un téléporteur.
	 * @param robot Objet comme saisie.
	 * @return "T" Le string a afficher pour un 'etat' True. Le téléporteur a été trouvé.
	 * <p>
	 * "" pour un 'etat' False. Le téléporteur n'a pas été trouvé.
	 */
	public static String etatTeleporteur(Robot robot) {

        // Récupère l'état du teleporteur
		boolean etat = robot.getTeleporteur();
		if (etat) {
			return "T";
		}
		else {
			return "";
		}
	}
}