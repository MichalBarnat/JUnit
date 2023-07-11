package pl.kurs.array.util;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.array.util.exceptions.ArrayIsNullException;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    ArrayUtil arrayUtil;
    private int[] array;

    @Before
    public void init() {
        arrayUtil = new ArrayUtil();
        array = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void shouldReturnCorrectSumOfArray() {
        int sum = arrayUtil.sumOfArray(array);
        assertEquals(15, sum);
    }

    @Test
    public void shouldReturnProductOfArray() {
        int product = arrayUtil.productOfArray(array);
        assertEquals(120, product);
    }

    @Test(expected = ArrayIsNullException.class)
    public void shouldThrowArrayIsNullExceptionOnSumOfArray() {
        int[] arr = null;
        arrayUtil.sumOfArray(arr);
    }

//    @Test(expected = ArrayIsNullException.class)
//    public void shouldThrowArrayIsNullExceptionOnPoroductOfArray() {
//        int[] arr = null;
//        arrayUtil.productOfArray(arr);
//    }
//
//    @Test(expected = ArrayIsNullException.class)
//    public void shouldThrowArrayIsNullExceptionOnMax() {
//        int[] arr = null;
//        arrayUtil.max(arr);
//    }
//
//    @Test(expected = ArrayIsNullException.class)
//    public void shouldThrowArrayIsNullExceptionOnMin() {
//        int[] arr = null;
//        arrayUtil.min(arr);
//    }

    @Test
    public void shouldReturnMaxOfArray() {
        assertEquals(5, arrayUtil.max(array));
    }

    @Test
    public void shouldReturnMinOfArray() {
        assertEquals(1, arrayUtil.min(array));
    }

    @Test
    public void shouldReturnMedianOfArray() {
        assertEquals(3, arrayUtil.median(array));
    }

    @Test
    public void shouldReturnSortedArray() {
        int[] arr = {5, 3, 1, 2, 4};
        assertEquals(arr, arrayUtil.sort(arr));
    }



}