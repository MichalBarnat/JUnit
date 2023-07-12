package pl.kurs.pracownik.firma.model;

import pl.kurs.pracownik.firma.exceptions.BranchDoNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int age;
    private Company company;
    private Branch branch;
    private Employee employee;


    public Car(String brand, String model, int age) {
        this.brand = brand;
        this.model = model;
        this.age = age;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        if(company == null) {
            throw new IllegalArgumentException("Company is null!");
        }
        this.company = company;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        if(branch == null) {
            throw new BranchDoNotExistException();
        }
        this.branch = branch;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
