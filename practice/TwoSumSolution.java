package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given is int[], along with a target, return indices of two numbers that add up to target
    Assumptions
    It should have one solution
    Cannot use the same element twice
    Can return answer in any order*/


public class TwoSumSolution {

  public static void main(String[] args) {
    //Test Case
    int[] nums = {3, 2, 4};
    int target = 6;

    //Option 2 using two pass hash table
    long startTime1 = System.nanoTime();
    int[] result1 = findTwoSumIndicesHashTable(nums, target);
    long endTime1 = System.nanoTime() - startTime1;
    System.out.println(
        "Result using two pass hash table " + Arrays.toString(result1) + " took " + endTime1
            + " ms");
    //Option 1 using bruteforce
    long startTime = System.nanoTime();
    int[] result = findTwoSumIndices(nums, target);
    long endTime = System.nanoTime() - startTime;
    System.out.print(
        "Result using bruteforce " + Arrays.toString(result) + " took " + endTime + " ms");

  }

  /**
   * This has a TC of O(n2) and SC of O(1).
   */
  private static int[] findTwoSumIndices(int[] nums, int target) {//BruteForce
    int[] result = new int[2];
    for (int i = 0; i <= nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  /**
   * While we are iterating and inserting elements into the hash table, we also look back to check
   * if current element's complement already exists in the hash table. If it exists, we have found a
   * solution and return the indices immediately.
   */
  private static int[] findTwoSumIndicesHashTable(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

}
