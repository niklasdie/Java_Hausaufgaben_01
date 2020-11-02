package h04;

public class Quadratwurzel implements Rechenoperation{

    /**
     * Berechnet die Quadratwurzel der eingegebenen Zahl und gibt diese zurueck.
     * @param x Zahl aus der die Quadratwurzel gezogen werden soll.
     * @return die Quadratwurzel.
     */
    @Override
    public double berechne(double x) {
        if(x<0){
            throw new ArithmeticException("Zahl kleiner 0!");
        }
        return Math.sqrt(x);
    }
}
