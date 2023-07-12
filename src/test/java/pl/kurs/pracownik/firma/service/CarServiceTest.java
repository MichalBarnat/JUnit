package pl.kurs.pracownik.firma.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.pracownik.firma.exceptions.NoCarsExceptions;
import pl.kurs.pracownik.firma.model.*;

import java.time.LocalDate;
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

    private Employee e1;
    private Employee e2;

    private Company company;
    private Branch branch;

    @Before
    public void init() {
        service = new CarService();
        car1 = new Car("bmw", "3", 19);
        car2 = new Car("audi", "a4", 25);
        car3 = new Car("bmw", "5", 38);
        car4 = new Car("polonez", "caro", 7);

        cars = new ArrayList<>(Arrays.asList(car1, car2, car3, car4));

        e1 = new Employee("Jan"," Kowalski", LocalDate.parse("1995-01-01"), Sex.MALE, Position.BOSS, 10);
        e2 = new Employee("Maciej","Krzyzak", LocalDate.parse("1993-01-01"), Sex.MALE, Position.MANAGEMENT, 3);
        company = new Company("Budimex", "Warsaw");
        branch = new Branch("Gdansk");
        company.addBranch(branch);
        company.hireEmployee(e1, branch);
        company.hireEmployee(e2, branch);
        company.addCar(car1, branch);
        company.addCar(car2, branch);
        company.addCar(car3, branch);
        company.addCar(car4, branch);
        branch.setCarToEmployee(car1, e1);
        branch.setCarToEmployee(car2, e2);
    }

    @Test
    public void shouldReturnOldestCar() {
        Car result = service.oldestCar(cars);
        assertEquals(car3, result);
    }

    @Test
    public void shouldReturnYoungestCar() {
        Car result = service.youngestCar(cars);
        assertEquals(car4, result);
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


    @Test
    public void shouldReturnListOfFreeCars() {
        List<Car> freeCars = new ArrayList<>(Arrays.asList(car3, car4));
        assertEquals(freeCars, service.listOfFreeCars(cars));
    }


    @Test
    public void shouldReturnListOfUsedCars() {
        List<Car> usedCars = new ArrayList<>(Arrays.asList(car1,car2));
        assertEquals(usedCars,service.listOfUsedCars(cars));
    }

    @Test
    public void shouldReturnListOfCarsOlderThan10Years() {
        List<Car> olderThan = new ArrayList<>(Arrays.asList(car1,car2, car3));
        assertEquals(olderThan, service.listOfCarsOlderThan(cars, 10));
    }

    @Test
    public void shouldReturnListOfCarsYoungerThan15Years() {
        List<Car> youngerThan15 = new ArrayList<>(Arrays.asList(car4));
        assertEquals(youngerThan15,service.listOfCarsYoungerThan(cars,15));
    }

    @Test
    public void shouldReturnListOfCarsForBossPosition() {
        List<Car> carsForBosses = new ArrayList<>(Arrays.asList(car1));
        assertEquals(carsForBosses, service.listOfCarsForThatPosition(cars, Position.BOSS));
    }




}