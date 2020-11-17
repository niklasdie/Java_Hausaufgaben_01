package h06;

import java.util.InputMismatchException;

public class Blatt {

    private final int[] blatt;

    /**
     * Konstruktor erzeugt ein Blatt Objekt.
     *
     * @param arr Eingabe int-Array der Länge 3.
     */
    public Blatt(int[] arr) {
        if (!(arr instanceof int[]) && arr.length != 3) {
            throw new InputMismatchException("Arrayformat falsch!");
        }
        for(int i = 0; i < 3; i++){
            if(arr[i] < 2 || arr[i] > 14){
                throw new InputMismatchException("Array darf nur 2 <= x <= 14");
            }
        }
        this.blatt = arr;
    }

    /**
     * Gibt eine Karte aus dem Array zurueck an der Stelle i.
     *
     * @param i Stelle der Karte
     * @return den Wert der Karte
     */
    public int getKarte(int i) {
        if (i < 3 && i >= 0) {
            return blatt[i];
        } else {
            throw new IndexOutOfBoundsException("Blatt ist nur 3 groß!");
        }
    }

    /**
     * Gibt den Array als leserlichen String zurueck.
     *
     * @return Werte aus Array
     */
    public String toString() {
        return blatt[0] + ", " + blatt[1] + ", " + blatt[2];
    }
}
