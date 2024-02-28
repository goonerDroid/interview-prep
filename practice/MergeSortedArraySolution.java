package practice;


import java.util.Arrays;

/**
 * Merge two sorted arrays.
 * <p>
 * Assumptions - two sorted arrays, non- decreasing order, merge into single array sorted in
 * non-decreasing order
 * <p>
 * resultant array = nums1[m+n]
 */
public class MergeSortedArraySolution {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int m = 3;

    int[] nums2 = {2, 5, 6};
    int n = 3;

    System.out.print("Merged resultant array " + merge(nums1, m, nums2, n));
  }

  private static String merge(int[] nums1, int m, int[] nums2, int n) {
    int[] result = new int[]{};
    for (int i = 0; i <= m; i++) {
    }
    return Arrays.toString(result);
  }

}
