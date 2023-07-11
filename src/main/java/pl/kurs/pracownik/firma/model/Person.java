package pl.kurs.pracownik.firma.model;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String surname;
    private final LocalDate birthDate;
    private Sex sex;
    private int age;

    public Person(String name, String surname, LocalDate birthDate, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.sex = sex;
        age = countAge();
    }

    private int countAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }
}
