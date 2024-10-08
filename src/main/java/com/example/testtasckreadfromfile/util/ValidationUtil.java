package com.example.testtasckreadfromfile.util;


import com.example.testtasckreadfromfile.exaptions.InvalidNthMaxException;

/**
 * Utility class for validating input data.
 * Contains static methods for checking the correctness
 * of data used in calculations of the N-th maximum number.
 */
public class ValidationUtil {
    private ValidationUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void checkInputData(int arrayLength, int n) {
        if (n <= 0) {
            throw new InvalidNthMaxException("The value of N must be greater than 0.");
        }
        if (arrayLength == 0) {
            throw new InvalidNthMaxException("The array is empty, it is impossible to find the N-th maximal number.");
        }
        if (arrayLength < n) {
            throw new InvalidNthMaxException("The value of N must be less than the length of the array. Array length = " + arrayLength);
        }
    }

    public static void checkQueue(boolean isEmptyQueue) {
        if (isEmptyQueue) {
            throw new InvalidNthMaxException("The queue is empty, it is impossible to find the N-th maximal number.");
        }
    }
}
