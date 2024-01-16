package pl.hetman.wiktoria.solvd.exceptions;

public class OfferException extends Exception{
    public OfferException(String message) {
        super(message);
    }

    public OfferException(String message, Throwable cause) {
        super(message, cause);
    }
}
