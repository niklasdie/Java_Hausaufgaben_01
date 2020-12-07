package h09;

/**
 * Diese Klasse berechnet die Koordinaten einer Koch-Kurve, eines der ersten formal beschriebenen fraktalen Objekte.
 */
public class KochKurve {

    /**
     * Public Funktion die erst die Rekusionstiefe ausgibt und anhand dieser die Koordinaten einer Koch-Kurve
     * berechnet und anschliessend ausgibt.
     *
     * @param ax  erste X-Koordinate
     * @param ay  erste Y-Koordinate
     * @param bx  zweite X-Koordinate
     * @param by  zweite Y-Koordinate
     * @param rek Rekursionstiefe
     */
    public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
        System.out.print("Rekursionstiefe " + rek + ": ");
        kochKurveRek(ax, ay, bx, by, rek);
        System.out.printf("(" + "%.1f" + "/" + "%.1f" + ")" + "\n", bx, by);
    }

    /**
     * Hilfsfunktion welche rekusiv aufgerufen wird.
     *
     * @param ax  erste X-Koordinate
     * @param ay  erste Y-Koordinate
     * @param bx  zweite X-Koordinate
     * @param by  zweite Y-Koordinate
     * @param rek Rekursionstiefe
     */
    private static void kochKurveRek(double ax, double ay, double bx, double by, int rek) {
        if (rek == 0) {
            System.out.printf("(" + "%.1f" + "/" + "%.1f" + ")", ax, ay);
        } else {
            double p1x, p1y, p2x, p2y, p3x, p3y;
            double faktor = Math.sqrt(3) / 2;
            rek--;

            p1x = (2 * ax + bx) / 3;
            p1y = (2 * ay + by) / 3;
            p2x = (ax + bx) / 2 + faktor * (by - ay) / 3;
            p2y = (ay + by) / 2 + faktor * (ax - bx) / 3;
            p3x = (ax + 2 * bx) / 3;
            p3y = (ay + 2 * by) / 3;

            kochKurveRek(ax, ay, p1x, p1y, rek);
            kochKurveRek(p1x, p1y, p2x, p2y, rek);
            kochKurveRek(p2x, p2y, p3x, p3y, rek);
            kochKurveRek(p3x, p3y, bx, by, rek);
        }
    }

    //Testen
    public static void main(String[] args) {
        kochKurve(0, 500, 500, 500, 0);
        kochKurve(0, 500, 500, 500, 1);
        kochKurve(0, 500, 500, 500, 2);
    }
}
