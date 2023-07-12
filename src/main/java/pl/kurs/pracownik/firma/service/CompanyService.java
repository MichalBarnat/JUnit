package pl.kurs.pracownik.firma.service;

import pl.kurs.pracownik.firma.exceptions.NoEmployeeWithHighestSalaryException;
import pl.kurs.pracownik.firma.model.Employee;
import pl.kurs.pracownik.firma.model.Position;

import java.util.*;

public class CompanyService {

    public int countEmpoloyeesHiredOnPosition(List<Employee> list, Position position) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getPosition().equals(position))
                .toList()
                .size();
    }


    //druga metoda do Mapy <Posiotion, Integer>

    public Employee highestSalaryOnPosition (List<Employee> list, Position position) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getPosition().equals(position))
                .toList()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoEmployeeWithHighestSalaryException::new);
    }

    public double totalEmployementCostInCompany(List<Employee> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Employee::getSalary)
                .sum();
    }




}
