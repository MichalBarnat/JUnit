package pl.kurs.range.exceptions;

public class InvalidRangeException extends RuntimeException{

    public InvalidRangeException() {
    }

    public InvalidRangeException(String message) {
        super(message);
    }
}
