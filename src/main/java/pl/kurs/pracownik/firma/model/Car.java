package pl.kurs.pracownik.firma.model;

import pl.kurs.pracownik.firma.exceptions.BranchDoNotExistException;
import pl.kurs.pracownik.firma.exceptions.CarAgeMustBeHigherThanZeroException;
import pl.kurs.pracownik.firma.exceptions.CompanyDoNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int age;
    private Company company;
    private Branch branch;
    private Employee employee;

    private static List<Car> extent = new ArrayList<>();


    public Car(String brand, String model, int age) {
        if(age < 0){
            throw new CarAgeMustBeHigherThanZeroException();
        }
        this.brand = brand;
        this.model = model;
        this.age = age;
        extent.add(this);
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
            throw new CompanyDoNotExistException();
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

    public static List<Car> getExtent() {
        return extent;
    }
}
