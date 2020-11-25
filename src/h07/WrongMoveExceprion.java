package h07;

/**
 * Wird geworfen wenn ein Tausch nicht moeglich ist.
 */
public class WrongMoveExceprion extends RuntimeException {
    public WrongMoveExceprion(String s) {
        super(s);
    }
}
