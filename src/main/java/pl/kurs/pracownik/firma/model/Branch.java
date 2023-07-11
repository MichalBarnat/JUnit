package pl.kurs.pracownik.firma.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Branch {
    private String city;
    private Company company;

    private List<Employee> employees = new ArrayList<>();

    public Branch(String city, Company company) {
        if(company == null) {
            throw new IllegalArgumentException("Company is null");
        }
        this.city = city;
        this.company = company;
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
}
