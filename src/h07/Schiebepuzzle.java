package h07;

public class Schiebepuzzle {

    private int[][] puzzle;
    private int[] frei;
    private int[] posi;

    public Schiebepuzzle() {
        puzzle = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        frei = new int[]{3, 3};
        posi = new int[]{0, 0};
    }

    public static void main(String[] args) {
        Schiebepuzzle p = new Schiebepuzzle();
        System.out.println("Neu:\n" + p.toString());
        p.mische();
        System.out.println("Gemischt:\n" + p.toString());
    }

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

    public boolean istVerschiebbar(int i) {
        finde(i);
        return (Math.abs(posi[0] - frei[0]) == 1) || (Math.abs(posi[1] - frei[1]) == 1);
    }

    public void mische() {
        finde(1);
        for (int i = 0; i < 100; i++) {
            getZufaelligNachbarOf0();
            tausche();
        }
    }

    private void finde(int i) {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (puzzle[x][y] == i) {
                    posi[0] = y;
                    posi[1] = x;
                }
            }
        }

    }

    private void tausche() {
        int temp = puzzle[posi[0]][posi[1]];
        puzzle[posi[0]][posi[1]] = 0;
        puzzle[frei[0]][frei[1]] = temp;
        int[] temp2 = posi;
        posi = frei;
        frei = temp2;
    }

    private void getZufaelligNachbarOf0() {
        int random;
        while (true) {
            int[] reset = new int[]{frei[0],frei[1]}; // muss in while-Schleife, sonst klappts nicht
            random = (int) (Math.random() * 100) % 4;
            posi = reset;
            switch (random) {
                case 0 -> posi[1] = posi[1] - 1;
                case 1 -> posi[0] = posi[0] + 1;
                case 2 -> posi[1] = posi[1] + 1;
                case 3 -> posi[0] = posi[0] - 1;
            }
            if (!(posi[0] < 0 || posi[0] > 3 || posi[1] < 0 || posi[1] > 3)) {
                break;
            }
        }
    }

    public String toString() {
        String res = "";
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 1) {
                res += "-------------" + "\n";
            } else {
                for (int j = 1; j < 10; j++) {
                    if (j % 2 == 1) {
                        res += "|";
                    } else {
                        if (puzzle[(i / 2) - 1][(j / 2) - 1] == 0) {
                            res += "  ";
                        } else {
                            if (puzzle[(i / 2) - 1][(j / 2) - 1] < 10) {
                                res += " " + puzzle[(i / 2) - 1][(j / 2) - 1];
                            } else {
                                res += puzzle[(i / 2) - 1][(j / 2) - 1];
                            }
                        }
                    }
                    if (j == 9)
                        res += "\n";
                }
            }
        }
        res += "\n\n";
        return res;
    }
}