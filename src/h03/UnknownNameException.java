package h03;

public class UnknownNameException extends RuntimeException {
    public UnknownNameException(String errorMessage){
        super(errorMessage);
    }
}
