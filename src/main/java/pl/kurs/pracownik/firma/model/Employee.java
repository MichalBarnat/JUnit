package pl.kurs.pracownik.firma.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee extends Person {
    private double salary;
    private int seniority;
    private double bonus;
    private Position position;
    
    private static List<Employee> extent = new ArrayList<>();

    private List<Company> companies = new ArrayList<>();

    private List<Branch> branches = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    public Employee(String name, String surname, LocalDate birthDate, Sex sex, double salary, Position position, int seniority) {
        super(name, surname, birthDate, sex);
        this.salary = salary;
        this.position = position;
        this.seniority = seniority;
        this.bonus = countBonus();
        extent.add(this);
    }

    public double countBonus() {
        return Math.pow((salary * 0.1), seniority);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static List<Employee> getExtent() {
        return extent;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public double getBonus() {
        return bonus;
    }

    public Position getPosition() {
        return position;
    }

    public int getSeniority() {
        return seniority;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(employee.salary, salary) == 0 && seniority == employee.seniority && Double.compare(employee.bonus, bonus) == 0 && position == employee.position && Objects.equals(companies, employee.companies) && Objects.equals(branches, employee.branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, seniority, bonus, position, companies, branches);
    }
}
