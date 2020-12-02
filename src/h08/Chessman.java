package h08;

import h07.WrongMoveExceprion;

import java.util.ArrayList;

/*
    Information für Korrektor:

    Sebastian (erster in unserer Hausaufgabengruppe 17) hat leider mit der MATSE Ausbildung
    aufgehört, in Zukunft brauchen Sie bei ihm nicht mehr nachschauen, da seins immer leer sein sollte.

    Viele Gruesse

    Max und Niklas (aus der Hausaufgabengruppe 17)
 */
public abstract class Chessman {

    Position pos;

    /**
     * Konstruktor erzeugt ein neues Chessman Objekt.
     *
     * @param pos Ausgangsposition der Schachfigur.
     */
    public Chessman(Position pos) {
        this.pos = pos;
    }

    /**
     * Abstrakte Methode welche in der erbenden Klasse initialisiert wird.
     * Soll die moeglichen Zuege einer bestimmten Figur ermitteln und sie in einer ArrayList zurueckgeben.
     *
     * @return eine Arraylist mit den moeglichen Schritten
     */
    public abstract ArrayList<Position> getMoveList();

    /**
     * Gibt die momentane Position der Schachfigur zurueck.
     *
     * @return die momentane Position
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Bewegt die Figur zur angegebenen Position.
     *
     * @param pos Position, zu der sich die Figur bewegen soll.
     */
    public void moveTo(Position pos) {
        if (this.canMoveTo(pos)) {
            this.pos = pos;
        } else {
            throw new WrongMoveExceprion("Move nicht moeglich!");
        }
    }

    /**
     * Ermittelt ob sich die gegebene Figur auf das angegebene Feld bewegen kann und gibt das Ergebnis zurueck.
     *
     * @param pos die zu ueberpruefene Position
     * @return Wahrheitswert ob der Zug moeglich ist oder nicht.
     */
    public boolean canMoveTo(Position pos) {
        return this.getMoveList().contains(pos);
    }
}
