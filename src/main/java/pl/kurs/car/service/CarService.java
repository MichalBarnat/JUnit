package pl.kurs.car.service;

import pl.kurs.car.exceptions.NoOldestCarException;
import pl.kurs.car.model.Car;

import java.util.*;

public class CarService {

    public Car oldestCar(List<Car> cars) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Car::getAge))
                .orElseThrow(NoOldestCarException::new);
    }

    public List<Car> carsWithProducer(List<Car> cars, String producer) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getProducer() != null)
                .filter(c -> c.getProducer().equalsIgnoreCase(producer))
                .toList();
    }
}
