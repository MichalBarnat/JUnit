package pl.kurs.pracownik.firma.service;

import pl.kurs.pracownik.firma.model.Employee;

import java.util.*;

public class EmployeeService {

    public Employee youngestEmployee(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public Employee oldestEmployee(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public double highestSalary(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .max(Comparator.comparing(Double::doubleValue))
                .orElseThrow();
    }

    public double lowestSalary(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .min(Comparator.comparing(Double::doubleValue))
                .orElseThrow();
    }

    public List<Employee> listOfEmployeesOlderThan(List<Employee> list, int age) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getAge() > age)
                .toList();
    }

    public List<Employee> listOfEmployeesYoungerThan(List<Employee> list, int age) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getAge() < age)
                .toList();
    }

    public Employee highestSeniority(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Employee::getSeniority))
                .orElseThrow();
    }

    public Employee lowestSeniority(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getSeniority))
                .orElseThrow();
    }


}
