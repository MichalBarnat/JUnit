package pl.kurs.pracownik.firma.exceptions;

public class BranchDoNotExistException extends RuntimeException{
    public BranchDoNotExistException() {
    }

    public BranchDoNotExistException(String message) {
        super(message);
    }
}
