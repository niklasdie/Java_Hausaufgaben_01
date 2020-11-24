package h07;

public class Schiebepuzzle {

    private final int[][] puzzle;
    private int[] frei;
    private int[] posi;

    /**
     * Konstruktor erzeugt ein neues Objekt von Schiebepuzzle.
     */
    public Schiebepuzzle() {
        puzzle = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        frei = new int[]{3, 3};
        posi = new int[]{0, 0};
    }

    /**
     * Verschiebt die eingegebene Zahl auf das freie Feld, falls der Zug moeglich ist und die eingegebene Zahl
     * zwischen 0 und 16 liegt.
     * @param i Zahl die aufs freie Feld geschoben werden soll.
     */
    public void schiebe(int i) {
        if (i < 1 || i > 16) {
            throw new WrongNumberException("i liegt nicht zwischen 1 und 15");
        } else {
            if (!istVerschiebbar(i)) {
                throw new WrongMoveExceprion("Zug ist nicht möglich");
            } else {
                tausche();
            }
        }
    }

    /**
     * Prueft ob die eingegebene Zahl auf das freie Feld geschoben werden kann, bzw ob sie danaben liegt und gibt
     * einen Wahrheitswert zurueck.
     * @param i die Zahl die ueberprueft werden soll.
     * @return einen Wahrheitswert ob es moeglich oder nicht ist.
     */
    public boolean istVerschiebbar(int i) {
        findeIntern(i);
        return ((Math.abs(posi[0] - frei[0]) == 1) && (posi[1]==frei[1]))
                || ((Math.abs(posi[1] - frei[1]) == 1 && (posi[0]==frei[0])));
    }

    /**
     * Mischt das Puzzle mit 100 zufaelligen Schritten, welches garantiert, dass das Puzzle loesbar ist.
     */
    public void mische() {
        findeIntern(1);
        for (int i = 0; i < 100; i++) {
            getZufaelligNachbarOf0();
            tausche();
        }
    }

    /**
     * Die eingegebene Zahl wird im Puzzle gesucht und die momentane Position zurueckgegeben.
     * @param i die Zahl die gesucht werden soll.
     * @return ein Int-Feld mit der Position der Zahl.
     */
    public int[] finde(int i) {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (puzzle[x][y] == i) {
                    posi[0] = x;
                    posi[1] = y;
                    return posi;
                }
            }
        }
        return posi;
    }

    /**
     * Erzeugt einen String zur visuellen Darstellung des Puzzles und gibt dieses zurueck.
     * @return das Puzzle als String.
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 1) {
                res.append("-------------" + "\n");
            } else {
                for (int j = 1; j < 10; j++) {
                    if (j % 2 == 1) {
                        res.append("|");
                    } else {
                        if (puzzle[(i / 2) - 1][(j / 2) - 1] == 0) {
                            res.append("  ");
                        } else {
                            if (puzzle[(i / 2) - 1][(j / 2) - 1] < 10) {
                                res.append(" ").append(puzzle[(i / 2) - 1][(j / 2) - 1]);
                            } else {
                                res.append(puzzle[(i / 2) - 1][(j / 2) - 1]);
                            }
                        }
                    }
                    if (j == 9)
                        res.append("\n");
                }
            }
        }
        res.append("\n");
        return res.toString();
    }

    /**
     * Hilsmethode die das gleiche wie finde() macht, nur dass die Position im Attribut gespeichert wird.
     * @param i die Zahl die gesucht werden soll.
     */
    private void findeIntern(int i) {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (puzzle[x][y] == i) {
                    posi[0] = x;
                    posi[1] = y;
                }
            }
        }
    }

    /**
     * Hilfsmehtode die das freie Feld und eine Zahl tauscht.
     */
    private void tausche() {
        int temp = puzzle[posi[0]][posi[1]];
        puzzle[posi[0]][posi[1]] = 0;
        puzzle[frei[0]][frei[1]] = temp;
        int[] temp2 = posi;
        posi = frei;
        frei = temp2;
    }

    /**
     * Hilfsmethode die einen zufaelligen Nachbarn von dem freien Feld ermittelnt.
     */
    private void getZufaelligNachbarOf0() {
        int random;
        do {
            int[] reset = new int[]{frei[0], frei[1]}; // muss in while-Schleife, sonst klappts nicht
            random = ((int) (Math.random() * 10000)) % 4;
            posi = reset;
            switch (random) {
                case 0:
                    posi[1] = posi[1] - 1;
                    break;
                case 1:
                    posi[0] = posi[0] + 1;
                    break;
                case 2:
                    posi[1] = posi[1] + 1;
                    break;
                case 3:
                    posi[0] = posi[0] - 1;
                    break;
            }
        } while (posi[0] < 0 || posi[0] > 3 || posi[1] < 0 || posi[1] > 3);
    }
}