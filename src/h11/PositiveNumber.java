package h11;

/**
 * Diese Klasse kann Zahlen aus dem Binaer-, Dezimal- und Hexadezimalsystem erhalten
 * und diese in eins der anderen Zahlensysteme umrechnen und zurueckgeben.
 */
public class PositiveNumber {
    private final String hexDigits = "0123456789ABCDEF";
    private int value; // es wird immer die Dezimalzahl gespeichert

    /**
     * Konstruktor der ein neues PositiveNumber Objekt erzeugt.
     */
    public PositiveNumber() {
        this.value = 0;
    }

    /**
     * Gibt die Zahl als Dezimalzahl zurueck.
     *
     * @return Dezimalzahl als String
     */
    public String getDecimal() {
        return "" + this.value;
    }

    /**
     * Setzt die Zahl aus der Dezimalzahl.
     *
     * @param s Dezimalzahl als String
     */
    public void setDecimal(String s) {
        this.setValue(s, 10);
    }

    /**
     * Gibt die Zahl als Hexadezimalzahl zurueck.
     *
     * @return Hexadezimalzahl als String
     */
    public String getHexadecimal() {
        return this.getValue(16);
    }

    /**
     * Setzt die Zahl aus der Hexadezimalzahl.
     *
     * @param s Hexadezimalzahl als String
     */
    public void setHexadecimal(String s) {
        s = s.toUpperCase();
        this.setValue(s, 16);
    }

    /**
     * Gibt die Zahl als Binaerzahl zurueck.
     *
     * @return Binaerzahl als String
     */
    public String getBinary() {
        return this.getValue(2);
    }

    /**
     * Setzt die Zahl aus der Binaerzahl.
     *
     * @param s Binaerzahl als String
     */
    public void setBinary(String s) {
        this.setValue(s, 2);
    }

    /**
     * Hilfsmethode die value setzt egal ob Dezimal oder Hexadezimal.
     *
     * @param s Zahl als String
     * @param x 10 oder 16 je nach Dezimal oder Hexadezimal
     */
    private void setValue(String s, int x) { // Codedopplung Vermeidung
        this.value = 0;
        this.proofBinDecHex(s, x);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = this.hexDigits.indexOf(c);
            this.value = this.value * x + d;
        }
        this.proofVal();
    }

    /**
     * Hilfsmethode die value zurueck gibt egal ob Dezimal oder Hexadezimal.
     *
     * @param x 2 oder 16 je nach Binaer oder Hexadezimal
     */
    private String getValue(int x){ // Codedopplung Vermeidung
        int v = this.value;
        StringBuilder res = new StringBuilder();
        if (v == 0) {
            res.append("0");
        } else {
            while (v > 0) {
                res.insert(0, this.hexDigits.charAt(v % x));
                v /= x;
            }
        }
        return res.toString();
    }

    /**
     * Hilfsmethode die prueft ob der String der eingegeben wurde zulaessig ist.
     *
     * @param s Zahl als String
     */
    private void proofBinDecHex(String s, int x) { // Codedopplung Vermeidung
        for (int i = 0; i < s.length(); i++) {
            int indexOf = hexDigits.indexOf(s.charAt(i));
            if (indexOf == -1 || indexOf > x - 1) {
                throw new NumberFormatException("Keine zulaessige Zahl!");
            }
        }
    }

    /**
     * Hilfsmethode die prueft ob die Zahl die eingegeben wurde zulaessig ist.
     */
    private void proofVal() {
        if (this.value < 0) { // Man braucht nicht zu ueberpruefen ob value > Integer.MAX_VALUE, da Ueberlauf
            this.value = 0;
            throw new NumberFormatException("Zahl < 0 oder > Integer.MAX_VALUE!");
        }
    }

    // Testen
    public static void main(String[] args) {
        PositiveNumber zs = new PositiveNumber();
        zs.setDecimal("144");
        System.out.println("Binaer: " + zs.getBinary());
        zs.setHexadecimal("affe");
        System.out.println("Dezimal: " + zs.getDecimal());
        zs.setBinary("1000101011");
        System.out.println("Hexadezimal: " + zs.getHexadecimal());
    }
}
