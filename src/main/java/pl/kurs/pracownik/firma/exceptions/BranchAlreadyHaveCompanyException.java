package pl.kurs.pracownik.firma.exceptions;

public class BranchAlreadyHaveCompanyException extends RuntimeException{
    public BranchAlreadyHaveCompanyException() {
    }

    public BranchAlreadyHaveCompanyException(String message) {
        super(message);
    }
}
