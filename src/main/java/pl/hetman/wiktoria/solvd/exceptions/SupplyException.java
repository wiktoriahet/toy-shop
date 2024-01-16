package pl.hetman.wiktoria.solvd.exceptions;

public class SupplyException extends Exception{
    public SupplyException(String message) {
        super(message);
    }

    public SupplyException(String message, Throwable cause) {
        super(message, cause);
    }
}
