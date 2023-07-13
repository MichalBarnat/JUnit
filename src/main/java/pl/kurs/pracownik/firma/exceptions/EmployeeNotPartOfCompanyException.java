package pl.kurs.pracownik.firma.exceptions;

public class EmployeeNotPartOfCompanyException extends RuntimeException{
    public EmployeeNotPartOfCompanyException() {
    }

    public EmployeeNotPartOfCompanyException(String message) {
        super(message);
    }
}
