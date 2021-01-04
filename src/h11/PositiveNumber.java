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
        this.value = 0;
        this.proofDec(s);
        for (int i = 0; i < s.length(); i++) { // extra kein Integer.parseInt()
            char c = s.charAt(i);
            int d = this.hexDigits.indexOf(c);
            this.value = this.value * 10 + d;
        }
        this.proofVal();
    }

    /**
     * Gibt die Zahl als Hexadezimalzahl zurueck.
     *
     * @return Hexadezimalzahl als String
     */
    public String getHexadecimal() {
        int x = this.value;
        StringBuilder res = new StringBuilder();
        while (x > 0) {
            res.insert(0, this.hexDigits.charAt(x % 16));
            x /= 16;
        }
        return res.toString();
    }

    /**
     * Setzt die Zahl aus der Hexadezimalzahl.
     *
     * @param s Hexadezimalzahl als String
     */
    public void setHexadecimal(String s) {
        this.value = 0;
        s = s.toUpperCase();
        proofHex(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = this.hexDigits.indexOf(c);
            this.value = this.value * 16 + d;
        }
        this.proofVal();
    }

    /**
     * Gibt die Zahl als Binaerzahl zurueck.
     *
     * @return Binaerzahl als String
     */
    public String getBinary() {
        int x = this.value;
        StringBuilder res = new StringBuilder();
        while (x > 0) {
            res.insert(0, x % 2 == 0 ? "0" : "1");
            x /= 2;
        }
        return res.toString();
    }

    /**
     * Setzt die Zahl aus der Binaerzahl.
     *
     * @param s Binaerzahl als String
     */
    public void setBinary(String s) {
        this.value = 0;
        this.proofBin(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = this.hexDigits.indexOf(c);
            this.value = this.value * 2 + d;
        }
        this.proofVal();
    }

    /**
     * Hilfsmethode die prueft ob eine Zahl die eingegeben wurde zulaessig ist (Hexadezimal).
     *
     * @param s Zahl als String
     */
    private void proofHex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (this.hexDigits.indexOf(s.charAt(i)) == -1) {
                throw new NumberFormatException("Keine zulaessige Zahl!");
            }
        }
    }

    /**
     * Hilfsmethode die prueft ob eine Zahl die eingegeben wurde zulaessig ist (Dezimal).
     *
     * @param s Zahl als String
     */
    private void proofDec(String s) {
        String digits = "0123456789";
        for (int i = 0; i < s.length(); i++) {
            if (digits.indexOf(s.charAt(i)) == -1) {
                throw new NumberFormatException("Keine zulaessige Zahl!");
            }
        }
    }

    /**
     * Hilfsmethode die prueft ob eine Zahl die eingegeben wurde zulaessig ist (Binaer).
     *
     * @param s Zahl als String
     */
    private void proofBin(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                throw new NumberFormatException("Keine zulaessige Zahl!");
            }
        }
    }

    private void proofVal() {
        if (value < 0) // Man braucht nicht zu ueberpruefen ob value > Integer.MAX_VALUE, da Ueberlauf
            throw new NumberFormatException("Zahl < 0 oder > Integer.MAX_VALUE!");
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
