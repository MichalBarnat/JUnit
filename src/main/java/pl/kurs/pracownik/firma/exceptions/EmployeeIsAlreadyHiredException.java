package pl.kurs.pracownik.firma.exceptions;

public class EmployeeIsAlreadyHiredException extends RuntimeException{
    public EmployeeIsAlreadyHiredException() {
    }

    public EmployeeIsAlreadyHiredException(String message) {
        super(message);
    }
}
