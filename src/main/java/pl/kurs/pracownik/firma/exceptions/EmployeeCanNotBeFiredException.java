package pl.kurs.pracownik.firma.exceptions;

public class EmployeeCanNotBeFiredException extends RuntimeException{
    public EmployeeCanNotBeFiredException() {
    }

    public EmployeeCanNotBeFiredException(String message) {
        super(message);
    }
}
