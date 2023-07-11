package pl.kurs.array.util;

import pl.kurs.array.util.exceptions.ArrayIsNullException;

import java.util.Arrays;

public class ArrayUtil {
    // napisz metody które
    // sumuja tablice liczb
    // licza iloczyn tablicy liczb
    // obsluz przypadki gdy tablica jest nullem

    public int sumOfArray(int[] arr) {
        if (arr == null) {
            throw new ArrayIsNullException("Arrays is null!");
        }
        int result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }

    public int productOfArray(int[] arr) {
        if (arr == null) {
            throw new ArrayIsNullException("Arrays is null!");
        }
        int result = 1;
        for (int i : arr) {
            result *= i;
        }
        return result;
    }

    public int min(int[] arr) {
        if (arr == null) {
            throw new ArrayIsNullException("Arrays is null!");
        }
        int result = Integer.MAX_VALUE;
        for (int i : arr) {
            if(i < result) {
                result = i;
            }
        }
        return result;
    }

    public int max(int[] arr) {
        if (arr == null) {
            throw new ArrayIsNullException("Arrays is null!");
        }
        int result = Integer.MIN_VALUE;
        for (int i : arr) {
            if(i > result) {
                result = i;
            }
        }
        return result;
    }

    public int median(int[] arr) {
        if (arr == null) {
            throw new ArrayIsNullException("Arrays is null!");
        }
        Arrays.sort(arr);
        int middle = arr.length/2;
        int medianValue = 0;
        if (arr.length % 2 == 1) {
            medianValue = arr[middle];
        } else {
            medianValue = (arr[middle-1] + arr[middle]) / 2;
        }

        return medianValue;
    }

    public int[] sort(int[] arr) {
        if (arr == null) {
            throw new ArrayIsNullException("Arrays is null!");
        }
        int[] result = arr;
        Arrays.sort(result);
        return result;
    }

}
