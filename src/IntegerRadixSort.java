/* 

 */

import java.util.*;

public class IntegerRadixSort {

    // Supporting process method that supports radix sorting.
    // Common radix utilizes a counting sort algorithm internally.
    private static void radixSortProcess(int[] array, int place, int stepCounter) {
        int size = array.length;
        // Stores the currently sorted numbers for this digit place.
        int[] tempSorted = new int[size];
        // Stores how many times each number appears initially.
        int[] countingArray = new int[10];

        // Count how many times each number appears at the current digit place.
        for (int j : array) {
            int number = (j / place) % 10;
            countingArray[number]++;
        }

        // Turn the array of value counts into cumulative totals where the value
        // is equal to how many numbers are <= to the index value at the current digit place.
        for (int j = 1; j < 10; j++) {
            countingArray[j] += countingArray[j - 1];
        }

        // Starting from the right hand side of the temp array, apply the number located at the
        // index position of the entry array into the temp array based on the associated value
        // of the counting index.
        for (int j = size - 1; j >= 0; j--) {
            int number = (array[j] / place) % 10;
            tempSorted[countingArray[number] - 1] = array[j];
            countingArray[number]--;
        }

        // Copy all elements of the temp array to the input array.
        System.arraycopy(tempSorted, 0, array, 0, size);
        System.out.println("Step: " + stepCounter + ", Digit Place: " + place + ", Output: " + Arrays.toString(array));
    }

    // Primary method used for processing the input array and for
    // defining starting bounds, while shifting the digit place and step counter.
    public static void radixSort(int[] array) {
        int maximumValue = Arrays.stream(array).max().getAsInt();
        int place = 1;
        int stepCounter = 1;

        while (maximumValue / place > 0) {
            radixSortProcess(array, place, stepCounter);
            place *= 10;
            stepCounter++;
        }
    }
}
