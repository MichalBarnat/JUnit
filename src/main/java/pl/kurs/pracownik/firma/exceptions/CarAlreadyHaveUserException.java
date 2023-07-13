package pl.kurs.pracownik.firma.exceptions;

public class CarAlreadyHaveUserException extends RuntimeException{
    public CarAlreadyHaveUserException() {
    }

    public CarAlreadyHaveUserException(String message) {
        super(message);
    }
}
