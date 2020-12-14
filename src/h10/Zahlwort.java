package h10;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zahlwort {

    /**
     * Diese Funktion gibt für alle natuerlichen Zahlen (von 1 bis 9999) das deutsche Zahlwort zurueck.
     *
     * @param x Zahl die als String zurueck gegeben werden soll
     * @return String
     */
    public static String getZahlwort(int x) {
        if (x < 1 || x > 9999) {
            throw new ArithmeticException("Zahl muss zwischen 1 und 9999 liegen!");
        } else {
            return buildZahlwort(x, length(x));
        }
    }

    /**
     * Gibt alle Zahlen zwischen dem Startwert und Endwert als Zahlwort zurueck.
     *
     * @param start Startwert
     * @param stop  Endwert
     * @return Stream aus Zahlwoertern
     */
    public static Stream<String> getZahlStream(int start, int stop) {
        return IntStream.rangeClosed(start, stop).mapToObj(Zahlwort::getZahlwort);
    }

    /**
     * Hilfsfunktion die das Zahlwort aufbaut.
     *
     * @param x      Zahl
     * @param length Anzahl der Ziffern
     * @return Zahl als Zahlwort
     */
    private static String buildZahlwort(int x, int length) {
        String res = "";
        switch (length) {
            case 1:
                if (x == 1) {
                    res = getZahl(x) + "s";
                } else {
                    res = getZahl(x);
                }
                break;
            case 2:
                if (x < 13 || x == 16 || x == 17 || x == 20 || x == 60 || x == 70) {
                    res = getZahl(x);
                } else {
                    if (x < 20) {
                        res = getZahl(x % 10) + getZahl(10);
                    } else {
                        if (x / 10 == 2 || x / 10 == 6 || x / 10 == 7) {
                            res = getZahl(x % 10) + getZahl(0) + getZahl((x / 10) * 10);
                        } else {
                            res = getZahl(x % 10) + getZahl(0) + getZahl(x / 10) + "zig";
                        }
                    }
                }
                break;
            case 3:
                res = getZahl(x / 100) + "hundert" + buildZahlwort(x % 100, length - 1);
                break;
            case 4:
                res = getZahl(x / 1000) + "tausend" + buildZahlwort(x % 1000, length - 1);
                break;
        }
        return res;
    }

    /**
     * Hilfsfunktion die die Laenge bzw die Anzahl der Ziffern einer Zahl bestimmt und zurueck gibt.
     *
     * @param x Zahl
     * @return Laenge als int
     */
    private static int length(int x) {
        int res = 0;
        while (x != 0) {
            x /= 10;
            res++;
        }
        return res;
    }

    /**
     * Hilfsfunktion die die Informationen fuer den String liefert.
     *
     * @param x Zahl die als String zurueck gegeben wird
     * @return Zahlwort
     */
    private static String getZahl(int x) {
        String res = "";
        switch (x) {
            case 0:
                res += "und";
                break;
            case 1:
                res += "ein";
                break;
            case 2:
                res += "zwei";
                break;
            case 3:
                res += "drei";
                break;
            case 4:
                res += "vier";
                break;
            case 5:
                res += "fuenf";
                break;
            case 6:
                res += "sechs";
                break;
            case 7:
                res += "sieben";
                break;
            case 8:
                res += "acht";
                break;
            case 9:
                res += "neun";
                break;
            case 10:
                res += "zehn";
                break;
            case 11:
                res += "elf";
                break;
            case 12:
                res += "zwoelf";
                break;
            case 16:
                res += "sechzehn";
                break;
            case 17:
                res += "siebzehn";
                break;
            case 20:
                res += "zwanzig";
                break;
            case 60:
                res += "sechzig";
                break;
            case 70:
                res += "siebzig";
                break;
        }
        return res;
    }

    //testen
    public static void main(String[] args) {
        // testen, ob ein paar typische Zahlwoerter richtig herauskommen:
        System.out.println();
        System.out.println("Test 1:");
        // erweiterte Ausgaben fuer problematische Zahlen
        int[] testtabelle = {1, 10, 11, 12, 13, 16, 17, 20, 25, 38, 60, 69,
                70, 73, 131, 195, 201, 202, 211, 735, 1111, 2345, 6854};
        for (int z : testtabelle) {
            String zahlwort = Zahlwort.getZahlwort(z);
            System.out.println("zahl = " + z + " --> " + zahlwort);
        }

        // testen, ob die Stream-Methode ordentlich funktioniert:
        System.out.println();
        System.out.println("Test 2:");
        int start = 8;
        int stop = 12;
        Stream<String> ss = Zahlwort.getZahlStream(start, stop);
        ss.limit(stop - start + 1).forEach(System.out::println);

        // sollte eine Ausnahme produzieren:
        System.out.println();
        System.out.println("Test 3:");
        int zahl = 10000;
        String wort = Zahlwort.getZahlwort(zahl);
    }
}
