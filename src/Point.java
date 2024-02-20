import java.util.*;
/**
 * représentation d'un point (x,y)
 *
 * @author Professeur
 * <p>
 *     Modifications apportées par:
 * <p>
 * @author Adèle Pomerleau
 * @author Adel Tayeb Boudia
 * @author Christelle Semaan
 */
public class Point {

    //ATTRIBUTS
    private final int x, y;

    //CONSTRUCTEUR
    /**
     * Initialise un point avec des coordonées (x,y) spécifique.
     * @param x coordonée en x du point
     * @param y coordonée en y du point
     */
    public	Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //METHODES
    /**
     * Vérifie si les coordonées du point concordent avec 'x' et 'y'.
     * @param x coordonée en x du point
     * @param y coordonée en y du point
     * @return True si égale, sinon False
     */
    public boolean egal(int x, int y) {
        return x == this.x && y == this.y;
               
    }

    /**
     * Méthode qui retourne la coordonée x du point.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Méthode qui retourne la coordonée x du point.
     * @return y
     */
    public int getY() {
        return y;
    }
}
