/**
 * Classe qui représente la grille du jeu.
 *
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Grille {

	
	//Les objets de type Grille n'ont qu'un seul attribut : une matrice 2D d'objet de type Case
	private Case[][] grille;

	/**
	 * Constructeur qui initialise la grille du jeu.
	 * Crée les pièces, les portes, les murs, les clefs ainsi que les items.
	 * 
	 * @param hauteurPiece La hauteur de chaque pièce.
	 * @param largeurPiece La largeur de chaque pièce.
	 * @param nbrNonKitten Représente le nombre de non-kitten dans la grille de jeu(incluant le téléporteur).
	 * @param nbrPiecesX Nombre de pièce à l'horizontal.
	 * @param nbrPiecesY Nombre de Pièce à la vertical.
	 */

	public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece,
				  int hauteurPiece, int nbrNonKitten) {
		this.grille = new Case[nbrPiecesX*(largeurPiece+1)][nbrPiecesY*(hauteurPiece+1)+1];

		/* Créer l'objet Grille, qui sera affichée grâce à la méthode afficher ci-dessous.
		 La boucle suivante initialise chacun des objets de la grille. */
		
		// Boucle qui initialise et place les murs et les portes.
		for (int j = 0; j < grille[0].length; j++) {					        // Itérer sur chaque ligne horizontale
			if (j % (hauteurPiece + 1) == 0) {					        // Se trouve à la hauteur d'un mur horizontal
				if (j != 0 && j != nbrPiecesY * (hauteurPiece + 1)) {		        // Vérifier que ce n'est pas le premier ou dernier
												        // mur
					double i1 = (double) largeurPiece / 2;{
					for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++)       // Si on se trouve à la moitié du mur : mettre
												        // une porte
						if (i % (largeurPiece +1) == Math.ceil(i1)) {
							grille[i][j] = new Porte();
						}
						else {						        // Sinon mettre un mur
							grille[i][j] = new Mur();
						}
					}
				}
				else {
					for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {	// Si c'est le premier ou dernier mur horizontal :
						grille[i][j] = new Mur();				// mettre un mur complet
					}
				}
			}
			else {										// Si on ne se trouve pas à la hauteur d'un mur 
				for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {		// horizontal
					
					// Mettre des portes et des murs si on se trouve sur un mur vertical.
					if (i % (largeurPiece + 1) == 0) {
						if (j % (hauteurPiece / 2 + 1) == 0 && i != 0 && i != nbrPiecesX * (largeurPiece + 1)) {
							grille[i][j] = new Porte();
						}
						else {
							grille[i][j] = new Mur();
						}
					}
					// Poser le dernier mur vertical.
					if (i == nbrPiecesX*(largeurPiece+1)-1) {
						grille[i][j] = new Mur();
					}
				}
			}
		}
		
		// La boucle suivante initialise des NonKitten et les place dans des cases aléatoires.
		for (int i = 0; i<nbrNonKitten-1; i++) {
			Point cellule = this.randomEmptyCell();
			grille[cellule.getX()][cellule.getY()] = new NonKitten();
		}

		// L'un des objets sera un téléporteur, initialiser ce dernier et le placer dans une case aléatoire
		Point cellule = this.randomEmptyCell();
		grille[cellule.getX()][cellule.getY()] = new Teleporteur();

		/* Initialiser et placer les clés. Il y en aura une par pièce et elle sera placée de façon aléatoire dans cette 
		dernière. */
		for (int j = 0; j < nbrPiecesY; j++) {
			for (int i = 0; i < nbrPiecesX; i++) {
				int positionCleX, positionCleY;

				// Cherche d'une position pour la clé et tant que c'est pas une case vide la boucle continue
				do {
					positionCleX = (int) (Math.random() * (largeurPiece)) + (largeurPiece + 1) * (i) + 1;
					positionCleY = (int) (Math.random() * (hauteurPiece)) + (hauteurPiece + 1) * (j) + 1;
					} while ((grille[positionCleX][positionCleY] != null));

				// Place  la clé à la position valide
				grille[positionCleX][positionCleY] = new Cle();
				}
			}

		// Initialiser et placer le Kitten, qui sera caché parmis les NonKitten
		Point positionKitten = this.randomEmptyCell();
		Kitten kitten = new Kitten("Caramel");
		grille[positionKitten.getX()][positionKitten.getY()] = kitten;

	}

	
	// Getters et Setters de l'attribut grille
	/**
	 * Donne accès à la grille de jeu.
	 * Permet à d'autres classe tel que 'RobotFindsKitten' de modifier son contenu.
	 * @return l'affirmation this.grille qui représente une grille de jeu.
	 */
	public Case[][] getGrille(){
		return this.grille;
	}

	/**
	 * Met à jour la grille de jeu avec la nouvelle grille fournie en argument.
	 * Permet la modification de la grille de l'extérieur de la classe grille.
	 * @param grille une matrice 2D fait de l'objet case. Nouvelle grille remplaçant celle déja existante.
	 */
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}


	/**
 	* Affiche la grille avec la position du robot dans le terminal.
 	* @param robot Objet qui représente un robot dont la position sera affichée.
 	*/
	public void afficher(Robot robot) {
		
		// Boucle qui se répète un nombre de fois équivalent à la quantité de cases en Y dans le jeu.
		for (int j = 0; j < grille[0].length; j++) {
			
			// Représente une ligne de cases (horizontales) dans un String.
			// Chaque ligne horizontale sera affichée, une à la fois.
			StringBuilder horizontal = new StringBuilder();
			
			// Aller chercher les coordonnées X et Y de l'attribut Point du robot.
			int posRobotX = robot.getPoint().getX();
			int posRobotY = robot.getPoint().getY();
			
			// Itérer sur chaque case en X.
			for (int i = 0; i < grille.length; i++) {
				Case objet = grille[i][j];
				
				if (i == posRobotX && j == posRobotY) {
					horizontal.append("#");
				}
				
				else if (objet != null) {
					horizontal.append("" + objet.getRepresentation());
				}
				else {
					horizontal.append(" ");
				}
			}
			System.out.println(horizontal);
		}
	}

	/**
	 * La fonction randomEmptyCell trouve et retourne la position d'une cellule vide sur la grille.
	 * @return point
	 */
	public Point randomEmptyCell() {
		
		int coordX=0; int coordY=0;
		
		// La boucle se répétera jusqu'à ce qu'on trouve une case vide.
		while(grille[coordX][coordY] != null) {
			coordX = (int) (Math.random()*grille.length);
			coordY= (int) (Math.random()*grille[0].length);
		}
		Point caseVide = new Point(coordX,coordY);

		return caseVide;
	}


	/**
	 * La méthode déplacementPossible indique si le déplacement du robot est possible pour une cellule en particulier.
	 * @param robot objet qui représente un robot.
	 * @param coordX coordonnée en x de la prochaine cellule.
	 * @param coordY coordonnée en y de la prochaine cellule.
	 */
	public boolean deplacementPossible(Robot robot, int coordX, int coordY) {
		
		// 'objet' représente l'objet qui se trouve à la case aux coordonnées coordX et coordY.
		Case objet = grille[coordX][coordY];
		if (objet !=null) {
			return objet.interactionPossible(robot);
		}
		else {
			return true;
		}
	}

	/**
 	 * Lance l’interaction entre le robot et la case de la grille sur laquelle il se trouve.
 	 * @param robot Représente le robot qui interagit avec la grille de jeu.
 	 */
	public void interagir(Robot robot) {
		Point pos = robot.getPoint();
		int coordX = pos.getX();
		int coordY = pos.getY();
		
		// Objet sur la case où le robot veut aller
		Case objet = grille[coordX][coordY];

		if (objet != null && objet.interactionPossible(robot)) {
			objet.interagir(robot);
		}
		else {
			return;
		}
	}
}
