package h03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EMailAdressBuch {

    private final

    HashMap<String, String> map;

    public EMailAdressBuch() {
        map = new HashMap<>();
    }

    public void einfuegen(String name, String email) {
        if (map.isEmpty() || !map.containsKey(name)) {
            map.put(name, email);
        } else {
            map.replace(name, email);
        }
    }

    public String abfrage(String name) {
        if (!map.containsKey(name)) {
            throw new UnknownNameException("Name nicht vorhanden!");
        } else {
            return map.get(name);
        }
    }

    public String toString() {
        return map.toString();
    }

    public void einlesen(String dateiname) {
        File f = new File(dateiname);
        Scanner sc;
        String temp;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                String[] temp2 = temp.split(";");
                map.put(temp2[0], temp2[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EMailAdressBuch matseMitarbeiter = new EMailAdressBuch();
        EMailAdressBuch eigen = new EMailAdressBuch();
        matseMitarbeiter.einlesen("mitarbeiter_matse_intern.txt");
        matseMitarbeiter.einlesen("mitarbeiter_matse_extern.txt");
        eigen.einlesen("emailadressbuch.txt");
        eigen.einfuegen("Herbert Hermann", "herher@bertmann.uk");
        System.out.println(matseMitarbeiter.toString());
        System.out.println(eigen.toString());
        System.out.println(eigen.abfrage("Herbert Hermann"));
        System.out.println(eigen.abfrage("Bernt Müller")); // testen für UnkownNameException
    }
}
