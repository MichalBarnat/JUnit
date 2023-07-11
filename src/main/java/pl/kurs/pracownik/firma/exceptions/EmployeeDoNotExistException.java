package pl.kurs.pracownik.firma.exceptions;

public class EmployeeDoNotExistException extends RuntimeException{
    public EmployeeDoNotExistException() {
    }

    public EmployeeDoNotExistException(String message) {
        super(message);
    }
}
