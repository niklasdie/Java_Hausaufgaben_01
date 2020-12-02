package h08;

/**
 * Wird geworfen wenn ein Zug nicht moeglich ist.
 */
public class WrongMoveExceprion extends RuntimeException {
    public WrongMoveExceprion(String s) {
        super(s);
    }
}
