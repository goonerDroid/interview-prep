package practice.searching;

import java.util.Arrays;

/**
 * LC Q - <a href="https://leetcode.com/problems/binary-search/">...</a>
 */
public class BinarySearch {

  public static int search(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {5};
    int target = 5;
    System.out.println("Input Array " + Arrays.toString(arr) + " & Target is " + target);
    System.out.println();
    int resultIndex = search(arr, target);
    System.out.println("The target is found at " + resultIndex);
  }

}
