package pl.kurs.pracownik.firma.service;

import pl.kurs.pracownik.firma.exceptions.BranchDoNotExistException;
import pl.kurs.pracownik.firma.model.Branch;
import pl.kurs.pracownik.firma.model.Car;
import pl.kurs.pracownik.firma.model.Employee;

import java.util.*;

public class BranchService {

    public Branch highestNumOfEmployees(List<Branch> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(b -> b.getEmployees().size()))
                .orElseThrow(BranchDoNotExistException::new);
    }

    public Branch lowestNumOfEmployees(List<Branch> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(b -> b.getEmployees().size()))
                .orElseThrow(BranchDoNotExistException::new);
    }

    public double monthlyCostForEmployees(Branch branch) {
        if(branch == null) {
            throw new BranchDoNotExistException();
        }
        int result = 0;
        for (Employee employee : branch.getEmployees()) {
            result += employee.countSalary();
        }
        return result;
    }

    public Branch highestAmountOfCars(List<Branch> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(b -> b.getCars().size()))
                .orElseThrow(BranchDoNotExistException::new);
    }

    public Branch lowestAmountOfCars(List<Branch> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(b -> b.getCars().size()))
                .orElseThrow(BranchDoNotExistException::new);
    }

    public Branch branchWithTheOldestCar(List<Branch> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(b -> b.getCars().stream())
                .min(Comparator.comparing(Car::getAge))
                .map(Car::getBranch)
                .orElseThrow(BranchDoNotExistException::new);
    }

    public Branch branchWithTheYoungesttCar(List<Branch> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .flatMap(b -> b.getCars().stream())
                .max(Comparator.comparing(Car::getAge))
                .map(Car::getBranch)
                .orElseThrow(BranchDoNotExistException::new);
    }



}
