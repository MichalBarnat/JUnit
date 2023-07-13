package pl.kurs.pracownik.firma.exceptions;

public class CarNotPartOfBranchException extends RuntimeException{
    public CarNotPartOfBranchException() {
    }

    public CarNotPartOfBranchException(String message) {
        super(message);
    }
}
