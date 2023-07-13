package pl.kurs.pracownik.firma.model;

import pl.kurs.pracownik.firma.exceptions.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String city;
    private Company company;

    private List<Employee> employees = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    public Branch(String city) {
        this.city = city;
    }

    // Car 1 -- * usage * -- 1 emp

    public void setCarToEmployee(Car car, Employee employee) {
        if(car == null) {
            throw new NoCarsExceptions();
        }
        if(employee == null) {
            throw new EmployeeDoNotExistException();
        }
        if(!employees.contains(employee)) {
            throw new EmployeeNotPartOfCompanyException();
        }
        if(!cars.contains(car)) {
            throw new CarNotPartOfBranchException();
        }
        if(car.getEmployee() != null) {
            throw new CarAlreadyHaveUserException();
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
