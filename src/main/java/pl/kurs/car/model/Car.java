package pl.kurs.car.model;

public class Car {
    private String producer;
    private int age;

    public Car(String producer, int age) {
        this.producer = producer;
        this.age = age;
    }

    public String getProducer() {
        return producer;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return producer + " " + age;
    }
}
