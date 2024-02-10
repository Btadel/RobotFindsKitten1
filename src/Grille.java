package devoir1;

public class Grille {
	
	/* Tableau 2D de cases
	 */
	
	private Case[][] grille; 
	
	/* Constructeur : 
	 */
	
     
	public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece, 
				  int hauteurPiece, int nbrNonKitten) {
		this.grille = new Case[nbrPiecesX*(largeurPiece+1)][nbrPiecesY*(hauteurPiece+1)];
	}
		
		
	public Case[][] getGrille(){
		return this.grille;
	}
	
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}
	
	
	/* Fonction qui print la grille : ajouter la fonction d'Adel
	 *public void afficher(Robot robot)
	 Trouver les cases qui auront des non-kitten items
         

        int[] tabHorizontal = new int[nbrNonKitten];
        int[] tabVertical = new int[nbrNonKitten];


        for (int k = 0; k < nbrNonKitten; k++) {
            do {
                tabHorizontal[k] = (int) (Math.random()*nbrPiecesX*(largeurPiece+1));
                tabVertical[k] = (int) (Math.random()*nbrPiecesY*(hauteurPiece+1));
            }
            while (tabHorizontal[k]%(largeurPiece+1) == 0 || tabVertical[k]%(hauteurPiece+1)==0);
        }

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
		grille = this.getGrille();
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
	