import java.util.Arrays;

/**
 * @author Maximilian Kalachnikov, Sebastian Ebert, Niklas Diekhoener
 */

public class KomplexeZahl {

    /**
     * x Realteil
     * y Imaginaerteil
     */
    private double x;
    private double y;
    private static final double EPSILON = 1e-16; // Doublevergleich mit Epsilon um Rundungsfehler zu vermeiden

    /**
     * Konstruktor
     *
     * @param x Realteil
     * @param y Imaginaerteil
     */
    public KomplexeZahl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return gibt den Realteil zurueck
     */
    public double getRealteil() {
        return this.x;
    }

    /**
     * @return gibt den Imaginaerteil zurueck
     */
    public double getImaginaerteil() {
        return this.y;
    }

    /**
     * addiert this mit einer weiteren komplexen Zahl
     *
     * @param z ist die zu addierende Zahl
     */
    public void addiere(KomplexeZahl z) {
        this.x += z.getRealteil();
        this.y += z.getImaginaerteil();
    }

    /**
     * multipliziert this mit einer weiteren komplexen Zahl
     *
     * @param z ist die zu multiplizierende Zahl
     */
    public void multipliziere(KomplexeZahl z) {
        double tempX = this.x; // temporaere Speicherung vom Realteil
        this.x = (this.x * z.getRealteil()) - (this.y * z.getImaginaerteil());
        this.y = (tempX * z.getImaginaerteil()) + (z.getRealteil() * this.y);
    }

    /**
     * Diese Methode berechnet den Betrag einer komplexen Zahl.
     *
     * @return gibt den Betrag zurueck
     */
    public double getBetrag() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Ueberschreibt die default toString Methode
     *
     * @return textuelle Repraesentation der komplexen Zahl
     */
    public String toString() {
        String res = "";
        if (Math.abs(this.y) < EPSILON) { // wenn nur Realteil vorhanden
            res += this.x;
        } else {
            if (Math.abs(this.x) < EPSILON) { // wenn nur Imaginaerteil vorhanden
                if (Math.abs(this.y - 1) < EPSILON) {
                    res += "i";
                } else {
                    res += this.y + " i";
                }
            } else { // wenn Realteil und Imaginaerteil vorhanden
                if (Math.abs(this.y - 1) < EPSILON) {
                    res += this.x + " + i";
                } else {
                    if (Math.abs(this.y + 1) < EPSILON) {
                        res += this.x + " - i";
                    } else {
                        if (this.y < 0) {
                            res += this.x + " - " + Math.abs(this.y) + " i";
                        } else {
                            res += this.x + " + " + this.y + " i";
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * @return gibt die Quadratwurzel einer komplexen Zahl zurueck
     */
    public KomplexeZahl[] getWurzel() {
        KomplexeZahl[] res = new KomplexeZahl[2];
        KomplexeZahl z1;
        KomplexeZahl z2;
        double x1 = 0, x2 = 0;
        double y1 = 0, y2 = 0;
        if (Math.abs(this.x) < EPSILON) { // wenn nur Imaginaerteil vorhanden, dann +- Imaginaerteil
            y1 = Math.sqrt(Math.abs(this.y));
            y2 = -y1;
        } else {
            if (Math.abs(this.y) < EPSILON) { // wenn nur Realteil vorhanden
                if (this.x > 0) { // wenn Realteil groesser 0, dann +- Realteil
                    x1 = Math.sqrt(Math.abs(this.x));
                    x2 = -x1;
                } else { // wenn Reailteil kleiner 0, dann +- Imaginaerteil
                    y1 = Math.sqrt(Math.abs(this.x));
                    y2 = -y1;
                }
            } else { // wenn Realteil und Imaginaerteil vorhanden
                double q = 0;
                if (this.x > 0 && this.y > 0) { // 1. Quadrant
                    q = Math.atan(this.y / this.x);
                } else {
                    if ((this.x < 0 && this.y > 0) || (this.x < 0 && this.y < 0)) { // 2., 3. Quadrant
                        q = Math.atan(this.y / this.x) + Math.PI;
                    } else {
                        if (this.x > 0 && this.y < 0) { // 4. Quadrant
                            q = Math.atan(this.y / this.x) + 2 * Math.PI;
                        }
                    }
                }
                // Berechnung von der Quadratwurzel
                double r = Math.sqrt(this.getBetrag());
                double qHalb = q / 2;
                double qPlus2PiHalb = (q + 2 * Math.PI) / 2;
                x1 = r * Math.cos(qHalb);
                y1 = r * Math.sin(qHalb);
                x2 = r * Math.cos(qPlus2PiHalb);
                y2 = r * Math.sin(qPlus2PiHalb);
            }
        }
        z1 = new KomplexeZahl(x1, y1);
        z2 = new KomplexeZahl(x2, y2);
        res[0] = z1;
        res[1] = z2;
        return res;
    }

    /**
     * Berechnet die Summer zweiter komplexer Zahlen
     *
     * @param z zu addierende komplexe Zahl
     * @return gibt die Summe als komplexe Zahl zurueck
     */
    public KomplexeZahl getSumme(KomplexeZahl z) {
        return new KomplexeZahl(this.x + z.getRealteil(), this.y + z.getImaginaerteil());
    }

    /**
     * Berechnet das Produkt zweiter komplexer Zahlen
     *
     * @param z ist die zu multiplizierende Zahl
     * @return gibt das Produkt als komplexe Zahl zurueck
     */
    public KomplexeZahl getProdukt(KomplexeZahl z) {
        return new KomplexeZahl(this.x * z.getRealteil() - this.y * z.getImaginaerteil(), this.x * z.getImaginaerteil() + z.getRealteil() * this.y);
    }

    public static void main(String[] args) {
        KomplexeZahl z = new KomplexeZahl(0, 0); // z := 0
        System.out.println("z = " + z);
        z = new KomplexeZahl(1, 0); // z := 1
        System.out.println("z = " + z);
        z = new KomplexeZahl(0, 1); // z := i
        System.out.println("z = " + z);
        z = new KomplexeZahl(-4, 0); // z := -4
        System.out.println("z = " + z);
        KomplexeZahl[] wurzeln = z.getWurzel(); // => 2i und -2i
        System.out.println("sqrt(z) = " + Arrays.toString(wurzeln));
        z = new KomplexeZahl(1, 1); // z := 1+i
        System.out.println("z = " + z);
        double betrag = z.getBetrag();
        System.out.println("|z| = " + betrag); // => sqrt(2) = 1.41...
        KomplexeZahl z2 = new KomplexeZahl(2, 1); // z2 := 2+i
        System.out.println("z2 = " + z2);
        z.addiere(z2);
        System.out.println("z nach Addition von z2 = " + z);
        z.multipliziere(z2);
        System.out.println("z nach Multiplikation von z2 = " + z);
        z2 = z.getProdukt(new KomplexeZahl(-1, 0)); // z2 := -z
        System.out.println("z2 = " + z2);
        KomplexeZahl summe = z.getSumme(z2); // z := z - z2 = 0
        System.out.println("summe = " + summe);
    }
}
