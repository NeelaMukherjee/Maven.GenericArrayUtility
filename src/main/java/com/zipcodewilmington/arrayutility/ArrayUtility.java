package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        Integer a1 = getNumberOfOccurrences(valueToEvaluate);
        Integer count = 0;

        for (T num : arrayToMerge) {
            if (num.equals(valueToEvaluate)) {
                count++;
            }
        }
        return a1 + count;
    }

    public T[] removeValue(T valueToRemove) {

        int count = getNumberOfOccurrences(valueToRemove);

        return Arrays.copyOf(Arrays.stream(inputArray).filter(val -> !val.equals(valueToRemove))
                .collect(Collectors.toList()).toArray(inputArray), inputArray.length - count);

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        Integer count = 0;

        for (T num : inputArray) {
            if (num.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        T mostCommon = arrayToMerge[0];

        for (T element : arrayToMerge) {

            if (getNumberOfOccurrences(element) > getNumberOfOccurrences(mostCommon)) {
                mostCommon = element;
            }
        }

        return mostCommon;
    }
}

