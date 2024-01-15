package pl.hetman.wiktoria.solvd.exceptions;

public class ToyShopException extends Exception {
    public ToyShopException(String message) {
        super(message);
    }

    public ToyShopException(String message, Throwable cause) {
        super(message, cause);
    }
}
