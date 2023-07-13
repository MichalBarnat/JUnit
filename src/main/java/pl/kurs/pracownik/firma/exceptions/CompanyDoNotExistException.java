package pl.kurs.pracownik.firma.exceptions;

public class CompanyDoNotExistException extends RuntimeException{
    public CompanyDoNotExistException() {
    }

    public CompanyDoNotExistException(String message) {
        super(message);
    }
}
