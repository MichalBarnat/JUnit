package pl.kurs.pracownik.firma.model;

import pl.kurs.pracownik.firma.exceptions.EmployeeDoNotExistException;
import pl.kurs.pracownik.firma.exceptions.NoCarsExceptions;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String city;
    private Company company;

    private List<Employee> employees = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    public Branch(String city, Company company) {
        if(company == null) {
            throw new IllegalArgumentException("Company is null");
        }
        this.city = city;
        this.company = company;
    }

    public void setCarToEmployee(Car car, Employee employee) {
        if(car == null) {
            throw new NoCarsExceptions();
        }
        if(employee == null) {
            throw new EmployeeDoNotExistException();
        }
        if(!cars.contains(car) || !employees.contains(employee)) {
            throw new IllegalArgumentException("Car or employee is not a part of this branch!");
        }
        if(car.getEmployee() != null) {
            throw new IllegalArgumentException("Car already have set employee!");
        }
        car.setEmployee(employee);
        employee.getCars().add(car);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Car> getCars() {
        return cars;
    }
}
