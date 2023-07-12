package pl.kurs.pracownik.firma.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee employee;
    Company company;
    Branch branch;

    @Before
    public void init() {
        employee = new Employee("Jan", "Kowalski", LocalDate.parse("1990-01-01"), Sex.MALE, Position.BOSS, 1);
        company = new Company("Biedronka", "Warszawa");
        branch = new Branch("Warsaw");
        company.hireEmployee(employee, branch);
    }

    @Test
    public void shouldReturnValidNameOfEmployee() {
        assertEquals("Jan", employee.getName());
    }

    @Test
    public void shouldReturnValidSalaryOfEmployee() {
        assertEquals(30000, employee.getSalary(), 0.1);
    }

    @Test
    public void shouldReturnValidSizeOfExtentOfEmployee() {
        assertEquals(1, Employee.getExtent().size());
    }

//    @Test
//    public void shouldReturnValidSizeOfExtentOfCompany() {
//        assertEquals(1, Company.getExtent().size());
//    }

    @Test
    public void shouldReturnValidSizeOfAssociationOnEmployeeSide() {
        assertEquals(1, employee.getCompanies().size());
    }

    @Test
    public void shouldReturnValidSizeOfAssociationOnCompanySide() {
        assertEquals(1, company.getEmployees().size());
    }


}