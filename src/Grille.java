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
	// !!! Parfois les portes apparaissent au mauvais endroit quand on change hauteur/largeur
		
		for (int j = 0; j < this.grille[0].length; j++) {
			 if (j % (hauteurPiece + 1) == 0) {
	                if (j != 0 && j != nbrPiecesY * (hauteurPiece + 1)) {
	                    for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
	                        if (i % (largeurPiece +1) == largeurPiece/2) {
	                        	this.grille[i][j] = new Porte(new Point (i,j));
	                        	} 
	                        else {
	                        	this.grille[i][j] = new Mur(new Point (i,j));
	                        }
	                    }
	                }
	                else {
	                	for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
	                	this.grille[i][j] = new Mur(new Point(i,j));
	                	}
	                }           
			 }
			 else {
	                for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
	                    if (i % (largeurPiece + 1) == 0) {
	                        if (j % (hauteurPiece / 2 + 1) == 0 && i != 0 && i != nbrPiecesX * (largeurPiece + 1)) {
	                        	this.grille[i][j] = new Porte(new Point(i,j));
	                        } 
	                        else {
	                        	this.grille[i][j] = new Mur(new Point(i,j));
	                        }
	                    }
	                    if (i == nbrPiecesX*(largeurPiece+1)-1) {
	                    	this.grille[i][j] = new Mur(new Point(i,j));
	                    }
	                }
			 }
		}
		// Trouver et placer les nonKitten
		// À FAIRE : Il faut au moins 1 nonKitten par pièce je crois
		
		for (int i = 0; i<nbrNonKitten; i++) {
			Point cellule = this.randomEmptyCell();
			this.grille[cellule.getX()][cellule.getY()] = new NonKitten();
		}
		
		//Trouver et placer les clés
		// À FAIRE : IL NE DOIT Y AVOIR QU'UNE SEULE CLÉ PAR CASE
		int compteur = 0;
		while (compteur < nbrPiecesX*nbrPiecesY) {
			Point celluleCle = this.randomEmptyCell();
			int posX = celluleCle.getX();
			int posY = celluleCle.getY();
			this.grille[posX][posY] = new Cle(new Point (posX,posY));
			compteur++;
		}
		
	}
		
		
	public Case[][] getGrille(){
		return this.grille;
	}
	
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}
	
	
	public void afficher(Robot robot) {
		
	 Point robotPosition = robot.getPoint();
	 int robotCoordonneeX = robotPosition.getX();
	 int robotCoordonneeY = robotPosition.getY();
	 
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
	