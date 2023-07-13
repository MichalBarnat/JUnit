package pl.kurs.pracownik.firma.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee extends Person {

    private int seniority;
    private double bonus;
    private Position position;
    
    private static List<Employee> extent = new ArrayList<>();

    private List<Company> companies = new ArrayList<>();

    private List<Branch> branches = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    public Employee(String name, String surname, LocalDate birthDate, Sex sex, Position position, int seniority) {
        super(name, surname, birthDate, sex);
        this.position = position;
        this.seniority = seniority;
        this.bonus = countBonus();

        extent.add(this);
    }

    public double countSalary() {
        return switch (position) {
            case BOSS -> 30000;
            case MANAGEMENT -> 20000;
            case WORKER -> 5000;
        };
    }

    public double countBonus() {
        return Math.pow((countSalary() * 0.1), seniority);
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
        return seniority == employee.seniority && Double.compare(employee.bonus, bonus) == 0 && position == employee.position && Objects.equals(companies, employee.companies) && Objects.equals(branches, employee.branches) && Objects.equals(cars, employee.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seniority, bonus, position, companies, branches, cars);
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
