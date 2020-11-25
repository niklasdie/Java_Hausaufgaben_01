package h07;

public class SchiebAlg1 implements Loesungsalgorithmus {

    /**
     * Verschiebt so lange zufaellig bis die 1 an der oberen linken Position steht.
     * @param schiebepuzzle Eingabepuzzle welches geloest werden soll.
     */
    @Override
    public void loese(Schiebepuzzle schiebepuzzle) {
        int random;
        int[] temp = schiebepuzzle.finde(1);
        while ((temp[0] != 0) || (temp[1] != 0)) {
            do {
                random = ((int) (Math.random() * 10000)) % 14 + 1;
            } while (!schiebepuzzle.istVerschiebbar(random));
            schiebepuzzle.schiebe(random);
            temp = schiebepuzzle.finde(1);
        }
    }
}
