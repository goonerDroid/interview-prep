package practice.sorting;

/**
 * LC Q - <a href="https://leetcode.com/problems/sort-colors/description/">...</a>
 */
public class SortColors {

  /**
   * Using Bucket sort algo we can sort the the int[]. Note using bucket sort when we've a value
   * within a specified range.
   * <p>
   * This has a TC of O(N) and SC of O(1) since its in place its constant SC
   */
  public static int[] sortColors(int[] nums) {
    int low = 0;
    int curr = 0;
    int high = nums.length - 1;

    int temp;
    while (curr <= high) {
      if (nums[curr] == 0) {
        temp = nums[low];
        nums[low] = nums[curr];
        nums[curr] = temp;
        low++;
        curr++;
      } else if (nums[curr] == 2) {
        temp = nums[curr];
        nums[curr] = nums[high];
        nums[high] = temp;
        high--;
      } else {
        curr++;
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] arr = {2, 0, 2, 1, 1, 0};
    for (int i : arr) {
      System.out.print(i);
    }
    System.out.println();
    int[] sortedColors = sortColors(arr);
    System.out.println("Sorted array using Bucket Sort ");
    for (int i : sortedColors) {
      System.out.print(i);
    }
  }
}
