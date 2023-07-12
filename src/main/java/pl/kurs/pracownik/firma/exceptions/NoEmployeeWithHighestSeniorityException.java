package pl.kurs.pracownik.firma.exceptions;

public class NoEmployeeWithHighestSeniorityException extends RuntimeException{
    public NoEmployeeWithHighestSeniorityException() {
    }

    public NoEmployeeWithHighestSeniorityException(String message) {
        super(message);
    }
}
