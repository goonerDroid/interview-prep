package practice;

import java.util.Arrays;

public class RotateArraySolution {

  /**
   * This method has TC of O(n x k). where all numbers are shifted by one step O(n) k times and
   * Space complexity of O(1)
   */
  public static void rotate(int[] nums, int k) {
    /* to speed up the operation */
    k %= nums.length;
    int temp;
    int previous;
    for (int i = 0; i < k; i++) {
      previous = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        temp = nums[j];
        nums[j] = previous;
        previous = temp;
      }
    }
    System.out.print("Rotated array is -> " + Arrays.toString(nums));
  }

  public static void rotate1(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    System.out.print("Rotated array is -> " + Arrays.toString(nums));
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {

//    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int[] nums = {-1, -100, 3, 99};
    int k = 2;
    System.out.println("Input Array is -> " + Arrays.toString(nums));
    System.out.println("Rotate k times where k = " + k);

    rotate1(nums, k);


  }

}
