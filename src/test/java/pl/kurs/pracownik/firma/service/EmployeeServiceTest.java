package pl.kurs.pracownik.firma.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithHighestSeniorityException;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithLowestSeniorityException;
import pl.kurs.pracownik.firma.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    private EmployeeService employeeService;
    private Employee e1;
    private Employee e2;
    private Employee e3;
    private Employee e4;
    private Employee e5;
    private Employee e6;

    private Company company1;
    private Branch branchC1a;
    private Branch branchC1b;
    private Company company2;
    private Branch branchC2a;
    private Branch branchC2b;
    private Company company3;
    private Branch branchC3a;
    private Branch branchC3b;




    private List<Employee> employees;

    @Before
    public void init() {
        employeeService = new EmployeeService();

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

        company1 = new Company("Company1", "Warsaw");
        branchC1a = new Branch("Gdansk");
        branchC1b = new Branch("Rzeszow");
        company2 = new Company("Company2", "Haiti");
        branchC2a = new Branch("Tokio");
        branchC2b = new Branch("Srilanka");
        company3 = new Company("Company3", "Honolulu");
        branchC3a = new Branch("Wroclaw");
        branchC3b = new Branch("Lublin");

        company1.hireEmployee(e1, branchC1a);
        company2.hireEmployee(e1, branchC2a);
        company3.hireEmployee(e1, branchC3a);

        company1.hireEmployee(e2, branchC1b);
        company2.hireEmployee(e2, branchC2b);

        company1.hireEmployee(e3, branchC1a);
        company2.hireEmployee(e3, branchC2b);




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

        assertEquals(30000, result, 0.1);
    }

    @Test
    public void shoudReturnLowestSalary() {
        double result = employeeService.lowestSalary(employees);

        assertEquals(5000, result, 0.1);
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

    @Test
    public void shouldReturnEmployeeWhoWorksFor3Companies() {
        assertEquals(e1, employeeService.workingInTheMostCompanies(employees));
    }

    @Test
    public void shouldReturnListOfEmployeesWhoWorkForMoreThanOneCompany() {
        //employeesWorkForMoreThanOneCompany
        assertEquals(Arrays.asList(e1,e2,e3),employeeService.employeesWorkForMoreThanOneCompany(employees));
    }

    @Test
    public void shouldReturnListOfEmployeesWhoWorksAsWorkers() {
        //employeesOnPositiona
        assertEquals(Arrays.asList(e3,e4,e5),employeeService.employeesOnPosition(employees,Position.WORKER));
    }


}