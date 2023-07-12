package pl.kurs.pracownik.firma.service;


import pl.kurs.pracownik.firma.exceptions.NoCarsExceptions;
import pl.kurs.pracownik.firma.model.Car;

import java.util.*;

public class CarService {
    public Car oldestCar(List<Car> cars) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Car::getAge))
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
}
