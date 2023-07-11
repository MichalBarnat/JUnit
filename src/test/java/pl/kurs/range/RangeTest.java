package pl.kurs.range;

import org.junit.*;
import pl.kurs.range.exceptions.InvalidRangeException;

import static org.junit.Assert.*;

public class RangeTest {

    /*

        test jednostkowy - dotyczy porawnosci dzialanoa pojedynczego elementu
        test jednostkowy - to metoda z @Test
        nie boimy sie dlugich nazw testow
        testy jednostkowe MUSZa byc od siebie niezalezne

     */

    private Range range;

    @Before
//    @After
//    @BeforeClass
//    @AfterClass
    public void init() {
        range = new Range(10, 20);
    }

    @Test
    public void shouldReturnTrueWhenNumberIsInTheRange() {
        assertTrue(range.isInTheRange(10));
    }

    @Test
    public void shouldReturnFalseWhenNumberIsOutOfTheRange() {
        assertFalse(range.isInTheRange(21));
    }

    @Test
    public void shouldReturnCorrectRangeFromOnGetRangeFrom() {
        int from = range.getRangeFrom();
        assertEquals(10, from);
    }

    @Test
    public void shouldNotReturnCorrectRangeFromOnGetRangeFrom() {
        int from = range.getRangeFrom();
        assertNotEquals(11, from);
    }

    @Test
    public void compareTwoDoubles() {
        double a = 3.45;
        double b = 3.43;
        assertEquals(a, b, 0.1);
    }

    @Test
    public void shouldRangeBeNull() {
        Range rangeForTest = null;
        assertNull(rangeForTest);
    }

    @Test
    public void shouldRangeNotBeNull() {
        assertNotNull(range);
    }

    @Test(expected = InvalidRangeException.class)
    public void shouldThrowInvalidRangeExceptionWhenRangeIsNotCorrect() {
        Range rangeForTest = new Range(20, 10);
    }
}