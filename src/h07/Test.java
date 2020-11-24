package h07;

public class Test {

    public static void main(String[] args) {
        Schiebepuzzle puzzle = new Schiebepuzzle();
        System.out.println("\nNeues Puzzel:\n" + puzzle.toString());
// Mischen nicht vergessen, ansonsten hat der Spieler sehr schnell gewonnen
        puzzle.mische();
        System.out.println("\nGemischtes Puzzel:\n" + puzzle.toString());
// Testen des Loesungsalgorithmus
// -> zufaellig schieben
        Loesungsalgorithmus alg1 = new SchiebAlg1();
        alg1.loese(puzzle);
        System.out.println("\nGeloestes Puzzel:\n" + puzzle.toString());

    }
}
