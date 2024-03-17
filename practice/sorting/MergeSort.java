package practice.sorting;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MergeSort {

  public static int[] mergeSort(int[] array) {
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }

  private static void mergeSort(int[] array, int[] helper, int low, int high) {
    if (low < high) {
      int middle = low + (high - low) / 2;
      mergeSort(array, helper, low, middle);
      mergeSort(array, helper, middle + 1, high);
      merge(array, helper, low, middle, high);
    }
  }

  @SuppressWarnings("ManualArrayCopy")
  private static void merge(int[] array, int[] helper, int low, int middle, int high) {
    //Copy values from arr to tempArr
    for (int i = low; i <= high; i++) {
      helper[i] = array[i];
    }

    int helperLeft = low;
    int helperRight = middle + 1;
    int current = low;

    while (helperLeft <= middle && helperRight <= high) {

      if (helper[helperLeft] < helper[helperRight]) {
        array[current] = helper[helperLeft];
        helperLeft++;
      } else {
        array[current] = helper[helperRight];
        helperRight++;
      }

      current++;
    }

    int remaining = middle - helperLeft;
    for (int i = 0; i <= remaining; i++) {
      array[current + i] = helper[helperLeft + i];
    }
  }

  public static void main(String[] args) {
    long start = System.nanoTime();
    int[] inputArr = new int[]{1, 4, 7, 2, 8, 3, 9};

    System.out.println("Unsorted input list: " + Arrays.toString(inputArr));
    System.out.println();
    System.out.println("Sorted list using MERGE sort: " + Arrays.toString(mergeSort(inputArr)));
    endTime(start);
  }

  public static void endTime(long startInNanoSec) {
    long end = System.nanoTime();
    long execution = end - startInNanoSec;
    double nanoSeconds = TimeUnit.NANOSECONDS.convert(execution, TimeUnit.NANOSECONDS);
    double milliSeconds = TimeUnit.MILLISECONDS.convert(execution, TimeUnit.NANOSECONDS);
    double seconds = TimeUnit.SECONDS.convert(execution, TimeUnit.NANOSECONDS);

    System.out.println("Execution time: " + nanoSeconds + " nano sec");
    System.out.println("Execution time: " + milliSeconds + " ms");
    System.out.println("Execution time: " + seconds + " seconds");
  }

}
