package h08;

import java.util.InputMismatchException;

public class Position {

    private final int x;
    private final int y;

    /**
     * Konstruiert ein neues Objekt mit den angegebenen Koordinaten
     *
     * @param x Koordinate der Position
     * @param y Koordinate der Position
     */
    public Position(int x, int y) {
        if (isValid(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            throw new InputMismatchException("Falsche Eingabe!");
        }
    }

    /**
     * Ueberprueft ob die eingegebenen Koordinaten auf dem Spielbrett liegen und gibt dies zurueck.
     *
     * @param x zu ueberpruefene x Koordinate
     * @param y zu ueberpruefene y Koordinate
     * @return einen Wahrheitswert
     */
    public static boolean isValid(int x, int y) {
        return x < 9 && x > 0 && y < 9 && y > 0;
    }

    /**
     * Getter die die x Koordinate zurueckgibt
     *
     * @return x Koordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Getter die die y Koordinate zurueckgibt
     *
     * @return y Koordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Ueberprueft ob zwei Positionen gleich sind und gibt dies zurueck.
     *
     * @param p zu vergleichene Postion
     * @return einen Wahrheitswert ob die Positonen gleich sind
     */
    public boolean equals(Position p) {
        return (p.x == this.x) && (p.y == this.y);
    }

    /**
     * Erstellt eine geeignete Darstellung des Punktes.
     *
     * @return Darstellung des Punktes als String
     */
    public String toString() {
        return "(" + x + "/" + y + ")";
    }
}
