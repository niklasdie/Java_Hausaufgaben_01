package h04;

public class Quadrat implements Rechenoperation {

    /**
     * Berechnet das Quadrat der eingegebenen Zahl und gibt diese zurueck.
     * @param x Zahl die quadriert werden soll.
     * @return die quadrierte Zahl.
     */
    @Override
    public double berechne(double x) {
        return x * x;
    }
}
