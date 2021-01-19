package h13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman {

    /**
     * Diese Funktion dekodiert Text mit Hilfe einer zugehörigen Dekodierungstabelle nach Huffman.
     * In der ersten Zeile steht der kodierte Text, die danach folgenden Zeilen sind jeweils einem Buchstaben dem
     * Alphabet zugeordnert (2. Zeile = A, 3. Zeile = B, 4. Zeile = C, usw.). Es werden nur Grossbuchstaben verwendet.
     *
     * @param f Textdatei welche den kodierenten Text sowie die Dekodierungsdaten enthält
     * @return den dekodierten Text
     */
    public static String decode(File f) {
        String[] tabelle = new String[27];
        String message = "";
        try (Scanner sc = new Scanner(f)) { // Textdatei einlesen
            String line;
            message = sc.nextLine();
            for (int i = 0; i < 27; i++) { // Dekodierungstabelle erstellen
                line = sc.nextLine();
                proof(line); // Dekodierungstabelle wird ueberprueft auf Gueltigkeit
                tabelle[i] = line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        proof(message); // kodierter Text wird ueberprueft auf Gueltigkeit
        return convertToChar(message, tabelle); // Ergebnis erzeugen durch dekodieren
    }

    /**
     * Hilfsfunktion die ueberprueft ob die Daten in der Textdatei zulaessig sind.
     *
     * @param s der zu ueberpruefende String
     */
    private static void proof(String s) {
        if (!s.equals("")) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!(c == '0' || c == '1')) // String s muss immer aus 0 oder 1 bestehen
                    throw new IllegalArgumentException("Dateiformat falsch!");
            }
        }
    }

    /**
     * Hilfsfunktion die den kodierten Text mit Hilfe der Dekodierungstabelle dekodiert.
     *
     * @param message kodierter Text
     * @param tabelle Dekodierungstabelle
     * @return dekodierten Text
     */
    private static String convertToChar(String message, String[] tabelle) {
        final String buchstaben = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        StringBuilder zeichen = new StringBuilder();
        for (int i = 0; i < message.length(); i++) { // durchlauf des kodierten Textes
            zeichen.append(message.charAt(i));
            for (int j = 0; j < 27; j++) // durchlauf der Dekodierungstabelle
                if (tabelle[j].equals(zeichen.toString())) // Uebereinstimmung von kodierter Text mit Dekodierungstab.
                    return buchstaben.charAt(j) + convertToChar(message.substring(zeichen.length()), tabelle);
        }
        return "";
    }

    // Testen
    public static void main(String[] args) {
        System.out.println("\n" + decode(new File("./src/h13/message.txt")));
    }
}
