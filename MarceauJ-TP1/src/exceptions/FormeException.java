package exceptions;


public class FormeException extends Exception {
    public FormeException() {
        super("Erreur d'une classe forme");
    }

    public FormeException(String message) {
        super(message);
    }
}