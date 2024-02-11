public class Grille {
	
	/* Tableau 2D de cases
	 */
	
	/*
	 * à faire : - la boucle doit initialiser la grille de cases (mettres les bons éléments aux bons 
	 * 				endroits dans la matrice) ET print la grille
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
	                    for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
	                        if (i % (largeurPiece +1) == largeurPiece/2) {
	                            //horizontal.append("!");
	                        	this.grille[i][j] = new Porte(new Point (i,j));
	                        	} 
	                        else {
	                            //horizontal.append("%");
	                        	this.grille[i][j] = new Mur(new Point (i,j));
	                        }
	                    }
	                }
	                else {
	                	//horizontal.append("%".repeat(Math.max(0, nbrPiecesX * (largeurPiece + 1) + 1)));
	                	for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
	                	this.grille[i][j] = new Mur(new Point(i,j));
	                	}
	                }           
			 }
			 else {
	                for (int i = 0; i < nbrPiecesX * (largeurPiece + 1); i++) {
	                    if (i % (largeurPiece + 1) == 0) {
	                        if (j % (hauteurPiece / 2 + 1) == 0 && i != 0 && i != nbrPiecesX * (largeurPiece + 1)) {
	                            //horizontal.append("!");
	                        	this.grille[i][j] = new Porte(new Point(i,j));
	                        } 
	                        else {
	                            //horizontal.append("%");
	                        	this.grille[i][j] = new Mur(new Point(i,j));
	                        }
	                    }
	                    if (i == nbrPiecesX*(largeurPiece+1)-1) {
	                    	this.grille[i][j] = new Mur(new Point(i,j));
	                    }
	                }
			 }
		}
		//Trouver et placer les non-kitten
		for (int i = 0; i<nbrNonKitten; i++) {
			Point cellule = this.randomEmptyCell();
			this.grille[cellule.getX()][cellule.getY()] = new NonKitten();
		}
	}
		
		
	public Case[][] getGrille(){
		return this.grille;
	}
	
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}
	
	
	//Fonction qui print la grille À COMPLÉTER:
	public void afficher(Robot robot) {
		
	/* Avoir les coordonnées du robot, de sorte que lorsqu'on print une grille, le robot sera
		au bon endroit */
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
	 
	 //**Trouver les cases qui auront des non-kitten items
         /*

        Boucle pour print la grille de jeu
         
        int compteur = 0;
        //grille debut
        for (int j = 0; j <= nbrPiecesY * (hauteurPiece + 1); j++) {
            StringBuilder horizontal = new StringBuilder();

            if (j % (hauteurPiece + 1) == 0) {
                if (j != 0 && j != nbrPiecesY * (hauteurPiece + 1)) {
                    for (int i = 0; i <= nbrPiecesX * (largeurPiece + 1); i++) {
                        if (i % (largeurPiece +1) == largeurPiece/2) {
                            horizontal.append("!");
                        } else {
                            horizontal.append("%");
                        }
                    }
                } else {
                    horizontal.append("%".repeat(Math.max(0, nbrPiecesX * (largeurPiece + 1) + 1)));
                }
                System.out.println(horizontal);
            } else {
                for (int i = 0; i <= nbrPiecesX * (largeurPiece + 1); i++) {
                    if (i % (largeurPiece + 1) == 0) {
                        if (j % (hauteurPiece / 2 + 1) == 0 && i != 0 && i != nbrPiecesX * (largeurPiece + 1)) {
                            horizontal.append("!");
                        } else {
                            horizontal.append("%");
                        }
                        //grille fin
                    } else {//affiche les randoms characters pendant le creation de la grilles
                        boolean nonKittenFound = false;
                        for (int k = 0; k < nbrNonKitten; k++) {
                            if (i == tabHorizontal[k] && j == tabVertical[k]) {
                                char symbole = Case.getRandomSymbole();
                                horizontal.append(symbole);
                                compteur += 1;
                                nonKittenFound = true;
                                break;
                            }
                        }
                        if (!nonKittenFound) {
                            horizontal.append(" ");
                        }
                    }
                }
                System.out.println(horizontal);
            }
	 */
	
	
	//Retourne la position d'une cellule vide
	
	public Point randomEmptyCell() {
		Case[][] grille = this.getGrille();
		int x=0; int y=0;
		
		while(grille[x][y] != null) {
			int x1 = (int) (Math.random()*grille.length);
			int y1 = (int) (Math.random()*grille[0].length);
			
			x = x1;
			y = y1;
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
	