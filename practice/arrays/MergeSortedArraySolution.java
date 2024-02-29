package practice.arrays;


import java.util.Arrays;

/**
 * LC question - <a
 * href="https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * Merge two sorted arrays.
 * <p>
 * Assumptions - two sorted arrays, non- decreasing order, merge into single array sorted in
 * non-decreasing order
 * <p>
 * resultant array = nums1[m+n]
 */
@SuppressWarnings("CommentedOutCode")
public class MergeSortedArraySolution {

  public static void main(String[] args) {
    int[] nums1 = {1};
    int m = 1;
    int[] nums2 = {};
    int n = 0;

    /*
    int[] nums1 = {0};
    int m = 0;
    int[] nums2 = {1};
    int n = 1;
    */
    System.out.print("Merged resultant array ");
    merge(nums1, m, nums2, n);
  }

  private static void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;

    for (int w = m + n - 1; w >= 0; w--) {
      if (p1 >= 0 && p2 >= 0) {
        nums1[w] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
      } else if (p1 >= 0) {
        nums1[w] = nums1[p1--];
      } else {
        nums1[w] = nums2[p2--];
      }
    }
    System.out.print(Arrays.toString(nums1));
  }

}
