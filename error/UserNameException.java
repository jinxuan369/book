package TestBook.src.error;

public class UserNameException extends RuntimeException {
    public UserNameException() {
        super();
    }

    public UserNameException(String message) {
        super(message);
    }
}
