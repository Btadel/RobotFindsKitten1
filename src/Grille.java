public class Grille {
	/**
	 * @author Adèle Pomerleau
	 * @author Adel tayeb Boudia
	 * @author Christelle Semaan
	 */
	
	//Les objets de type Grille n'ont qu'un seul attribut : une matrice 2D de cases
	private Case[][] grille;

	/* Son constructeur prend cinq paramètres :
	* le nombre de pièces horizontales et de pièces verticales, la largeur et la longueur des pièces, ainsi 
	* que le nombre de NonKitten qui se trouvent dans le jeu (incluant le téléporteur).*/

	public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece,
				  int hauteurPiece, int nbrNonKitten) {
		this.grille = new Case[nbrPiecesX*(largeurPiece+1)][nbrPiecesY*(hauteurPiece+1)+1];

		// Créer l'objet Grille, qui sera affichée grâce à la méthode afficher ci-dessous
		// La boucle suivante initialise chacun des objets de la grille
		
		for (int j = 0; j < this.grille[0].length; j++) {
			if (j % (hauteurPiece + 1) == 0) {
				if (j != 0 && j != nbrPiecesY * (hauteurPiece + 1)) {
					double i1 = (double) largeurPiece / 2;{
					for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++)
						if (i % (largeurPiece +1) == Math.ceil(i1)) {
							this.grille[i][j] = new Porte();
						}
						else {
							this.grille[i][j] = new Mur();
						}
					}
				}
				else {
					for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
						this.grille[i][j] = new Mur();
					}
				}
			}
			else {
				for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
					if (i % (largeurPiece + 1) == 0) {
						if (j % (hauteurPiece / 2 + 1) == 0 && i != 0 && i != nbrPiecesX * (largeurPiece + 1)) {
							this.grille[i][j] = new Porte();
						}
						else {
							this.grille[i][j] = new Mur();
						}
					}
					if (i == nbrPiecesX*(largeurPiece+1)-1) {
						this.grille[i][j] = new Mur();
					}
				}
			}
		}
		
		// La boucle suivante initialise des NonKitten et les place dans des cases aléatoires
		for (int i = 0; i<nbrNonKitten-1; i++) {
			Point cellule = this.randomEmptyCell();
			this.grille[cellule.getX()][cellule.getY()] = new NonKitten();
		}

		// L'un des objets sera un téléporteur, initialiser ce dernier et le placer dans une case aléatoire
		Point cellule = this.randomEmptyCell();
		this.grille[cellule.getX()][cellule.getY()] = new Teleporteur();

		/* Initialiser et placer les clés. Il y en aura une par pièce et elle sera placée de façon aléatoire dans cette 
		dernière. */
		for (int j = 0; j < nbrPiecesY; j++) {
			for (int i = 0; i < nbrPiecesX; i++) {
				int positionCleX, positionCleY;

				// Cherche d'une position pour la clé et tant que c'est pas une case vide la boucle continue
				do {
					positionCleX = (int) (Math.random() * (largeurPiece)) + (largeurPiece + 1) * (i) + 1;
					positionCleY = (int) (Math.random() * (hauteurPiece)) + (hauteurPiece + 1) * (j) + 1;
					} while ((this.grille[positionCleX][positionCleY] != null));

				// Place  la clé à la position valide
				this.grille[positionCleX][positionCleY] = new Cle();
				}
			}

		// Initialiser et placer le Kitten, qui sera caché parmis les NonKitten
		Point positionKitten = this.randomEmptyCell();
		Kitten kitten = new Kitten("Caramel");
		this.grille[positionKitten.getX()][positionKitten.getY()] = kitten;

	}

	
	// Getters et Setters de l'attribut grille
	public Case[][] getGrille(){
		return this.grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	/* La fonction afficher prend en paramètre le robot et print la grille
	 dans le terminal */
	
	public void afficher(Robot robot) {
		
		// Boucle qui se répète un nombre de fois équivalent à la quantité de cases en Y dans le jeu
		for (int j = 0; j < grille[0].length; j++) {
			
			// Représente une ligne de cases (horizontales) dans un String
			// Chaque ligne horizontale sera affichée, une à la fois.
			StringBuilder horizontal = new StringBuilder();
			
			// Aller chercher les coordonnées X et Y de l'attribut Point du robot
			int posRobotX = robot.getPoint().getX();
			int posRobotY = robot.getPoint().getY();
			
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

	//Méthode qui retourne la position d'une cellule vide dans la grille

	public Point randomEmptyCell() {
		
		int coordX=0; int coordY=0;
		
		// La boucle se répétera jusqu'à ce qu'on trouve une case vide
		while(grille[coordX][coordY] != null) {
			coordX = (int) (Math.random()*grille.length);
			coordY= (int) (Math.random()*grille[0].length);
		}
		Point caseVide = new Point(coordX,coordY);

		return caseVide;
	}

	// La méthode suivante indique si le déplacement du robot est possible
	public boolean deplacementPossible(Robot robot, int coordX, int coordY) {
		
		// objet représente l'objet qui se trouve à la case aux coordonnées coordX et coordY
		Case objet = grille[coordX][coordY];
		return objet.interactionPossible(robot);
	}

	// Lance l’interaction entre le Robot robot et la case de la grille sur laquelle il se trouve
	public void interagir(Robot robot) {
		Point pos = robot.getPoint();
		int coordX = pos.getX();
		int coordY = pos.getY();
		
		// Objet sur la case où le robot veut aller
		Case objet = grille[coordX][coordY];

		if (objet.interactionPossible(robot)) {
			objet.interagir(robot);
		}
	}
}