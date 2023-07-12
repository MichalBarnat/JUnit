package pl.kurs.pracownik.firma.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {
    Company company;

    @Before
    public void init() {
        company = new Company("Microsoft", "Redmond");
    }

    @Test
    public void shouldReturnValidLengthOfCompanyName() {
        assertEquals(9, company.getName().length());
    }
}