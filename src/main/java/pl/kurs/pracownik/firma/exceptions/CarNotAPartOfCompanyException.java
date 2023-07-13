package pl.kurs.pracownik.firma.exceptions;

public class CarNotAPartOfCompanyException extends RuntimeException{
    public CarNotAPartOfCompanyException() {
    }

    public CarNotAPartOfCompanyException(String message) {
        super(message);
    }
}
