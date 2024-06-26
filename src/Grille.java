public class Grille {

	/* Tableau 2D de cases
	 */
	private Case[][] grille;

	/* Constructeur :
	 */


	public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece,
				  int hauteurPiece, int nbrNonKitten) {
		this.grille = new Case[nbrPiecesX*(largeurPiece+1)][nbrPiecesY*(hauteurPiece+1)+1];

		// Créer l'objet Grille, qui sera print avec la fonction afficher (plus bas)

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
		// Trouver et placer les nonKitten
		//À FAIRE : Il faut au moins 1 nonKitten par pièce je crois

		for (int i = 0; i<nbrNonKitten-1; i++) {
			Point cellule = this.randomEmptyCell();
			this.grille[cellule.getX()][cellule.getY()] = new NonKitten();
		}

		//Il faut que un des NonKitten soit le teleporteur

		Point cellule = this.randomEmptyCell();
		this.grille[cellule.getX()][cellule.getY()] = new Teleporteur();

		//Trouver et placer les clés
		// update : il n'y a qu'une seule clé par case
		for (int j=0; j<nbrPiecesY; j++) {
			for(int i=0; i<nbrPiecesX; i++) {
				int positionCleX = (int)(Math.random()*(largeurPiece))+(largeurPiece+1)*(i)+1;
				int positionCleY = (int)(Math.random()*(hauteurPiece))+(hauteurPiece+1)*(j)+1;
				
				this.grille[positionCleX][positionCleY] = new Cle();
			}
		}
		
		// Kitten
		Point positionKitten = this.randomEmptyCell();
		Kitten kitten = new Kitten("Caramel", positionKitten);
		this.grille[positionKitten.getX()][positionKitten.getY()] = kitten;

	}


	public Case[][] getGrille(){
		return this.grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public void afficher(Robot robot) {

		for (int j = 0; j < this.grille[0].length; j++) {
			StringBuilder horizontal = new StringBuilder();
			
			int posRobotX = robot.getPoint().getX();
			int posRobotY = robot.getPoint().getY();
			
			for (int i = 0; i < this.grille.length; i++) {
				Case objet = this.grille[i][j];
				
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

	//Retourne la position d'une cellule vide

	public Point randomEmptyCell() {
		Case[][] grille = this.getGrille();
		int x=0; int y=0;

		while(grille[x][y] != null) {
			x = (int) (Math.random()*grille.length);
			y= (int) (Math.random()*grille[0].length);
		}
		Point point = new Point(x,y);

		return point;
	}

	// Indique si le déplacement du robot est possible
	public boolean deplacementPossible(Robot robot, int x, int y) {
		grille = this.getGrille();
		Case case1 = grille[x][y];
		return case1.interactionPossible(robot);
	}

	// Lance l’interaction entre le Robot robot et la case de la grille sur laquelle il se trouve

	public void interagir(Robot robot) {
		Point pos = robot.getPoint();
		int x = pos.getX();
		int y = pos.getY();

		Case objet = grille[x][y];

		if (objet.interactionPossible(robot)) {
			objet.interagir(robot);
		}
	}
}