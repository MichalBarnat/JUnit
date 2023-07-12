package pl.kurs.pracownik.firma.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithHighestSalaryException;
import pl.kurs.pracownik.firma.model.Employee;
import pl.kurs.pracownik.firma.model.Position;
import pl.kurs.pracownik.firma.model.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyServiceTest {
    private CompanyService companyService;
    private Employee e1;
    private Employee e2;
    private Employee e3;
    private Employee e4;
    private Employee e5;
    private Employee e6;

    private List<Employee> employees;

    @Before
    public void init() {
        companyService = new CompanyService();

        e1 = new Employee("Zofia", "Nowak", LocalDate.of(1990, 1, 1),
                Sex.FEMALE, Position.MANAGEMENT, 1);
        e2 = new Employee("Zuzanna", "Kowalski", LocalDate.of(1987, 2, 5),
                Sex.FEMALE, Position.MANAGEMENT, 2);
        e3 = new Employee("Laura", "Wisniewski", LocalDate.of(1995, 3, 9),
                Sex.FEMALE, Position.WORKER, 3);
        e4 = new Employee("Jakub", "Wojcik", LocalDate.of(1993, 4, 13),
                Sex.MALE, Position.WORKER, 5);
        e5 = new Employee("Franciszek", "Kowalczyk", LocalDate.of(2000, 5, 23),
                Sex.MALE, Position.WORKER, 3);
        e6 = new Employee("Antoni", "Kaminska", LocalDate.of(2001, 6, 29),
                Sex.MALE, Position.BOSS, 7);

        employees = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5, e6));

    }

    @Test
    public void shouldReturnPersonWithHighestSalaryOnPosition() {
        Employee result = companyService.highestSalaryOnPosition(employees, Position.BOSS);
        assertEquals(e6, result);
    }

    @Test (expected = NoEmployeeWithHighestSalaryException.class)
    public void shouldThrowNoEmployeeWithHighestSalaryException() {
        List<Employee> listForTest = new ArrayList<>(Arrays.asList(e6));
        companyService.highestSalaryOnPosition(listForTest,Position.WORKER);
    }

    @Test
    public void shouldCountEmpoloyeesHiredOnPosition() {
        int result = companyService.countEmpoloyeesHiredOnPosition(employees, Position.WORKER);
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnTotalEmployementCostInCompany() {
        double result = companyService.totalEmployementCostInCompany(employees);

        assertEquals(85000, result, 0.1);
    }
}