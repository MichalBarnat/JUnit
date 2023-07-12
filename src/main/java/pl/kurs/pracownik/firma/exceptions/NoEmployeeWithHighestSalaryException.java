package pl.kurs.pracownik.firma.exceptions;

public class NoEmployeeWithHighestSalaryException extends RuntimeException{
    public NoEmployeeWithHighestSalaryException() {
    }

    public NoEmployeeWithHighestSalaryException(String message) {
        super(message);
    }
}
