package pl.kurs.pracownik.firma.model;

import pl.kurs.pracownik.firma.exceptions.BranchDoNotExistException;
import pl.kurs.pracownik.firma.exceptions.EmployeeDoNotExistException;
import pl.kurs.pracownik.firma.exceptions.NoCarsExceptions;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String city;

    private static List<Company> extent = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    private List<Branch> branches = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    public Company(String name, String city) {
        this.name = name;
        this.city = city;
        extent.add(this);
    }

    public void hireEmployee(Employee employee, Branch branch) {
        if(employee == null || branch == null) {
            throw new IllegalArgumentException("Employee or branch do not exist!");
        }
        if(employee.getCompanies().contains(this)) {
            throw new IllegalArgumentException("EMployee is already hired in this company!");
        }
        employees.add(employee);
        employee.getCompanies().add(this);
        branch.getEmployees().add(employee);
        employee.getBranches().add(branch);
    }

    public void fireEmployee(Employee employee) {
        if(employee == null) {
            throw new EmployeeDoNotExistException();
        }
        if(!employee.getCompanies().contains(this) || employee.getCompanies().isEmpty()) {
            throw new IllegalArgumentException("Employee can not be fired!");
        }
        employees.remove(employee);
        employee.getCompanies().remove(this);
        extent.add(this);
    }

    public void addBranch(Branch branch) {
        if(branch == null || branch.getCompany() != null) {
            throw new IllegalArgumentException("Branch is null or have Company already");
        }
        branches.add(branch);
        branch.setCompany(this);
    }

    public void addCar(Car car, Branch branch) {
        if(car == null) {
            throw new NoCarsExceptions();
        }
        if(branch == null) {
            throw new BranchDoNotExistException();
        }
        cars.add(car);
        car.setCompany(this);
        car.setBranch(branch);
        branch.getCars().add(car);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Company> getExtent() {
        return extent;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public String getCity() {
        return city;
    }

    public List<Car> getCars() {
        return cars;
    }
}
