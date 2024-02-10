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
	
	

