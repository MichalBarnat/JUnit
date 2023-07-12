package pl.kurs.pracownik.firma.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithHighestSeniorityException;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithLowestSeniorityException;
import pl.kurs.pracownik.firma.model.Employee;
import pl.kurs.pracownik.firma.model.Position;
import pl.kurs.pracownik.firma.model.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    private EmployeeService employeeService;
    private Employee e1;
    private Employee e2;
    private Employee e3;
    private Employee e4;
    private Employee e5;
    private Employee e6;

    private List<Employee> employees;

    @Before
    public void init() {
        employeeService = new EmployeeService();

        e1 = new Employee("Zofia", "Nowak", LocalDate.of(1990, 1, 1),
                Sex.FEMALE, 4100, Position.MANAGEMENT, 1);
        e2 = new Employee("Zuzanna", "Kowalski", LocalDate.of(1987, 2, 5),
                Sex.FEMALE, 4200, Position.MANAGEMENT, 2);
        e3 = new Employee("Laura", "Wisniewski", LocalDate.of(1995, 3, 9),
                Sex.FEMALE, 2000, Position.WORKER, 3);
        e4 = new Employee("Jakub", "Wojcik", LocalDate.of(1993, 4, 13),
                Sex.MALE, 2000, Position.WORKER, 5);
        e5 = new Employee("Franciszek", "Kowalczyk", LocalDate.of(2000, 5, 23),
                Sex.MALE, 2000, Position.WORKER, 3);
        e6 = new Employee("Antoni", "Kaminska", LocalDate.of(2001, 6, 29),
                Sex.MALE, 6100, Position.BOSS, 7);

        employees = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5, e6));

    }

    @Test
    public void shouldReturnYoungestEmployee() {
        Employee result = employeeService.youngestEmployee(employees);

        assertEquals(e6, result);
    }

    @Test
    public void shouldReturnOldestEmployee() {
        Employee result = employeeService.oldestEmployee(employees);

        assertEquals(e2, result);
    }

    @Test
    public void shoudReturnHighestSalary() {
        double result = employeeService.highestSalary(employees);

        assertEquals(6100, result, 0.1);
    }

    @Test
    public void shoudReturnLowestSalary() {
        double result = employeeService.lowestSalary(employees);

        assertEquals(2000, result, 0.1);
    }

    @Test
    public void shouldReturnlistOfEmployeesOlderThan25() {
        List<Employee> listForTest = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
        List<Employee> result = employeeService.listOfEmployeesOlderThan(employees, 25);

        assertEquals(listForTest, result);
    }

    @Test
    public void shouldReturnlistOfEmployeesYoungerThan25() {
        List<Employee> listForTest = new ArrayList<>(Arrays.asList(e5, e6));
        List<Employee> result = employeeService.listOfEmployeesYoungerThan(employees, 25);

        assertEquals(listForTest, result);
    }

    @Test
    public void shouldReturnEmployeeWithHighestSeniority() {
        Employee result = employeeService.highestSeniority(employees);

        assertEquals(e6, result);
    }

    @Test(expected = NoEmployeeWithHighestSeniorityException.class)
    public void shouldThrowNoEmployeeWithHighestSeniorityExceptionWhenListIsNull() {
        List<Employee> listForTest = null;
        employeeService.highestSeniority(listForTest);
    }

    @Test
    public void shouldReturnEmployeeWithLowestSeniority() {
        Employee result = employeeService.lowestSeniority(employees);

        assertEquals(e1, result);
    }

    @Test(expected = NoEmployeeWithLowestSeniorityException.class)
    public void shouldThrowNoEmployeeWithLowestSeniorityExceptionWhenListIsNull() {
        List<Employee> listForTest = null;
        employeeService.lowestSeniority(listForTest);
    }

}