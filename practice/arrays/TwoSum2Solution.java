package practice.arrays;

import java.util.Arrays;

/**
 * LC Question - <a
 * href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class TwoSum2Solution {

  private static int[] findTwoSumIndices(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      int sum = nums[start] + nums[end];
      if (sum == target) {
        return new int[]{start + 1, end + 1};
      } else if (sum < target) {
        start++;
      } else {
        end--;
      }
    }
    return new int[]{-1, -1};
  }


  public static void main(String[] args) {
    //Test Case
    int[] nums = {2, 7, 11, 13};
    int target = 9;
    int[] result1 = findTwoSumIndices(nums, target);
    System.out.println(
        "Result using two pass hash table " + Arrays.toString(result1));
  }

}
