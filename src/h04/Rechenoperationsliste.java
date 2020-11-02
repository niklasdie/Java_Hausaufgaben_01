package h04;

import java.util.ArrayList;
import java.util.List;

public class Rechenoperationsliste {

    List<Rechenoperation> liste;

    /**
     * Konstruiert ein Objekt der Klasse Rechenoperationsliste und
     * initialisiert das obrige Attribut.
     */
    public Rechenoperationsliste() {
        this.liste = new ArrayList<>();
    }

    /**
     * Fuegt eine neue Rechenoperation zur Liste hinzu.
     * @param operation Rechenoperation die hinzugefuegt wird.
     */
    public void add(Rechenoperation operation) {
        this.liste.add(operation);
    }

    /**
     * Es werden alle Rechenoperationen in der Liste auf jedes Element des eingegebenen Feldes angewendet.
     * @param feld Eingabefeld auf welche die Rechenoperationen angewendet werden.
     * @return Ergebnisfeld der angewendeten Rechenoperationen.
     */
    public double[] transform(double[] feld) {
        double[] res = feld.clone();
        for (Rechenoperation rechenoperation : this.liste) {
            for (int j = 0; j < res.length; j++) {
                res[j] = rechenoperation.berechne(res[j]);
            }
        }
        return res;
    }
}
