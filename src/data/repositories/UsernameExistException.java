package data.repositories;

public class UsernameExistException extends RuntimeException {
    public UsernameExistException(String message) {
        super(message);
    }
}
