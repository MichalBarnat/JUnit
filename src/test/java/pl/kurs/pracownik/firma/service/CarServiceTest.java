package pl.kurs.pracownik.firma.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.pracownik.firma.exceptions.NoCarsExceptions;
import pl.kurs.pracownik.firma.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CarServiceTest {

    private CarService service;
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;

    private List<Car> cars;

    @Before
    public void init() {
        service = new CarService();
        car1 = new Car("bmw", "3", 19);
        car2 = new Car("audi", "a4", 25);
        car3 = new Car("bmw", "5", 38);
        car4 = new Car("polonez", "caro", 7);

        cars = new ArrayList<>(Arrays.asList(car1, car2, car3, car4));
    }

    @Test
    public void shouldReturnOldestCar() {
        Car oldest = car3;
        Car result = service.oldestCar(cars);

        assertEquals(oldest, result);
    }

    @Test(expected = NoCarsExceptions.class)
    public void shouldThrowNoOldestCarExceptionWhenListIsNull() {
        List<Car> listForTest = null;
        service.oldestCar(listForTest);
    }

    @Test
    public void shouldReturnAllBmws() {
        List<Car> bmwCars = new ArrayList<>(Arrays.asList(car1, car3));
        List<Car> result = service.carsWithProducer(cars, "bmw");
        assertEquals(bmwCars, result);
    }
}