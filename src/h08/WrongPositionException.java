package h08;

/**
 * Wird geworfen wenn ein Position nicht gueltig ist.
 */
public class WrongPositionException extends RuntimeException {
    public WrongPositionException(String s) {
        super(s);
    }
}
