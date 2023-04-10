package TestBook.src.error;

public class PasswordException extends RuntimeException{
    public PasswordException() {
        super();
    }

    public PasswordException(String message) {
        super(message);
    }
}
