package pl.kurs.car.exceptions;

public class NoOldestCarException extends RuntimeException{
    public NoOldestCarException() {
    }

    public NoOldestCarException(String message) {
        super(message);
    }

}
