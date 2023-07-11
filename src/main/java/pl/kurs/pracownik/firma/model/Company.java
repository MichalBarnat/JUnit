package pl.kurs.pracownik.firma.model;

import pl.kurs.pracownik.firma.exceptions.EmployeeDoNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String city;

    private static List<Company> extent = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    private List<Branch> branches = new ArrayList<>();

    public Company(String name, String city) {
        this.name = name;
        this.city = city;
        extent.add(this);
    }

    public void hireEmployee(Employee employee, Branch branch) {
        if(employee == null || branch == null) {
            throw new EmployeeDoNotExistException();
        }
        employees.add(employee);
        employee.getCompanies().add(this);
        branch.getEmployees().add(employee);
        employee.getBranches().add(branch);
    }

    public void addBranch(Branch branch) {
        if(branch == null || branch.getCompany() != null) {
            throw new IllegalArgumentException("Branch is null or have Company already");
        }
        branches.add(branch);
        branch.setCompany(this);
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
}
