package com.example.testtasckreadfromfile.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.testtasckreadfromfile.util.ValidationUtil.checkInputData;


/**
 * Service for finding the N-th maximum number from an array of integers
 * using a custom implementation of the algorithm.
 */
@Service
public class MaxNumberService {

    public List<Integer> findNthMax(int[] numbers, int n) {
        checkInputData(numbers.length, n);

        List<Integer> maxNumbers = new ArrayList<>();

        bubbleSort(numbers);
         for (int i = numbers.length - n; i < numbers.length; i++) {
             maxNumbers.add(numbers[i]);
         }

        return maxNumbers;
    }

    private static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }

}
