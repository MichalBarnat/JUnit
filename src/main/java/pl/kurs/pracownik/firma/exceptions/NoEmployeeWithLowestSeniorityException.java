package pl.kurs.pracownik.firma.exceptions;

public class NoEmployeeWithLowestSeniorityException extends RuntimeException{
    public NoEmployeeWithLowestSeniorityException() {
    }

    public NoEmployeeWithLowestSeniorityException(String message) {
        super(message);
    }
}
