package pl.kurs.pracownik.firma.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee employee;
    Company company;

    @Before
    public void init() {
        employee = new Employee("Jan", "Kowalski", LocalDate.parse("1990-01-01"), Sex.MALE, 30000, Position.MANAGEMENT, 1);
        company = new Company("Biedronka", "Warszawa");
    }

    @Test
    public void shouldReturnValidNameOfEmployee() {
        assertEquals("Jan", employee.getName());
    }

    @Test
    public void shouldReturnValidLengthOfCompanyName() {
        assertEquals(9, company.getName().length());
    }

    @Test
    public void shouldReturnValidSalaryOfEmployee() {
        assertEquals(30000, employee.getSalary(), 0.1);
    }

    @Test
    public void shouldReturnValidSizeOfExtentOfEmployee() {
        assertEquals(1, Employee.getExtent().size());
    }


}