package h08;

import java.util.ArrayList;

public class Rook extends Chessman {

    /**
     * Konstruiert ein neues Objekt der Klasse Knight. Diese Klasse erweitert die Klasse Chessman.
     *
     * @param pos eine Position
     */
    public Rook(Position pos) {
        super(pos);
    }

    /**
     * Erstellt eine ArrayList mit moeglichen Positionen an die sich die Figur bewegen kann und gibt diese zurueck.
     *
     * @return eine ArrayList mit moeglichen Positionen
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> res = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            res.add(new Position(i, pos.getY()));
            res.add(new Position(pos.getX(), i));
        }
        return res;
    }

    /**
     * Erzeugt eine passende Darstellung der Position dieser Figur und gibt diese zurueck.
     *
     * @return Darstellung der Position als String
     */
    public String toString() {
        return "Turm: " + pos.toString();
    }
}
