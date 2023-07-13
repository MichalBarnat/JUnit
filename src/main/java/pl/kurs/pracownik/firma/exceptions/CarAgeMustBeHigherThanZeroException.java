package pl.kurs.pracownik.firma.exceptions;

public class CarAgeMustBeHigherThanZeroException extends RuntimeException{
    public CarAgeMustBeHigherThanZeroException() {
    }

    public CarAgeMustBeHigherThanZeroException(String message) {
        super(message);
    }
}
