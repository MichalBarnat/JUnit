package pl.kurs.pracownik.firma.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee employee;
    Company company;

    @Before
    public void init() {
        employee = new Employee("Jan", "Kowalski", 3000);
        company = new Company("Biedronka");
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
        assertEquals(3000, employee.getSalary(), 0.1);
    }

    @Test
    public void shouldReturnValidSizeOfExtentOfEmployee() {
        assertEquals(1, Employee.getExtent().size());
    }

    @Test
    public void shouldReturnValidSizeOfExtentOfCompany() {
        assertEquals(1, Company.getExtent().size());
    }


}