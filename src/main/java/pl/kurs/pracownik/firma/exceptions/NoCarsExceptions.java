package pl.kurs.pracownik.firma.exceptions;

public class NoCarsExceptions extends RuntimeException{
    public NoCarsExceptions() {
    }

    public NoCarsExceptions(String message) {
        super(message);
    }
}
