package pl.kurs.pracownik.firma.service;

import pl.kurs.pracownik.firma.exceptions.EmployeeDoNotExistException;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithHighestSeniorityException;
import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithLowestSeniorityException;
import pl.kurs.pracownik.firma.model.Employee;
import pl.kurs.pracownik.firma.model.Position;

import java.util.*;

public class EmployeeService {

    public Employee youngestEmployee(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getAge))
                .orElseThrow(EmployeeDoNotExistException::new);
    }

    public Employee oldestEmployee(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Employee::getAge))
                .orElseThrow(EmployeeDoNotExistException::new);
    }

    public double highestSalary(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::countSalary)
                .max(Comparator.comparing(Double::doubleValue))
                .orElseThrow(EmployeeDoNotExistException::new);
    }

    public double lowestSalary(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::countSalary)
                .min(Comparator.comparing(Double::doubleValue))
                .orElseThrow(EmployeeDoNotExistException::new);
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
                .orElseThrow(NoEmployeeWithHighestSeniorityException::new);
    }

    public Employee lowestSeniority(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getSeniority))
                .orElseThrow(NoEmployeeWithLowestSeniorityException::new);
    }

    public Employee workingInTheMostCompanies(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(e -> e.getCompanies().size()))
                .orElseThrow(EmployeeDoNotExistException::new);
    }

    public List<Employee> employeesWorkForMoreThanOneCompany(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getCompanies().size() > 1)
                .toList();
    }

    public List<Employee> employeesOnPosition(List<Employee> list, Position position) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getPosition().equals(position))
                .toList();
    }



}
