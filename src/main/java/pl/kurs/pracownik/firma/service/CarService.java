package pl.kurs.pracownik.firma.service;


import pl.kurs.pracownik.firma.exceptions.NoCarsExceptions;
import pl.kurs.pracownik.firma.model.Car;
import pl.kurs.pracownik.firma.model.Employee;
import pl.kurs.pracownik.firma.model.Position;

import java.util.*;
import java.util.stream.Collectors;

public class CarService {

    public Car oldestCar(List<Car> cars) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Car::getAge))
                .orElseThrow(NoCarsExceptions::new);
    }

    public Car youngestCar(List<Car> cars) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Car::getAge))
                .orElseThrow(NoCarsExceptions::new);
    }

    public List<Car> carsWithProducer(List<Car> cars, String producer) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getBrand() != null)
                .filter(c -> c.getBrand().equalsIgnoreCase(producer))
                .toList();
    }

    public List<Car> listOfFreeCars(List<Car> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getEmployee() == null)
                .toList();
    }

    public List<Car> listOfUsedCars(List<Car> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getEmployee() != null)
                .toList();
    }

    public List<Car> listOfCarsOlderThan(List<Car> list, int age) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getAge() > age)
                .toList();
    }

    public List<Car> listOfCarsYoungerThan(List<Car> list, int age) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getAge() < age)
                .toList();
    }

    public List<Car> listOfCarsForThatPosition(List<Car> list, Position position) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(c -> c.getEmployee())
                .filter(Objects::nonNull)
                .filter(e -> e.getPosition().equals(position))
                .map(Employee::getCars)
                .flatMap(List::stream)
                .toList();


    }
}
