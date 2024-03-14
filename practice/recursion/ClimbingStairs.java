package practice.recursion;

/**
 * LC Q - <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 */
public class ClimbingStairs {

  /**
   * This would be the bruteforce which has a TC of O(2 ^ n), where n is the number of recursive
   * tree call. SC would be O(n) - Depth of the recursion tree can go up to n
   */
  public static int climbStairsRecursion(int n) {
    return climb_stairs_recursion(0, n);
  }

  private static int climb_stairs_recursion(int start, int end) {
    if (start > end) {
      return 0;
    }
    if (start == end) {
      return 1;
    }

    return climb_stairs_recursion(start + 1, end) + climb_stairs_recursion(start + 2, end);
  }

  /**
   * Memoization technique is used which stores the result at each step in memo[] and return the
   * result directly from the array TC - O(n) - size of the recursion can go up to n SC - O(n) -
   * depth of the recursion tree can go up to n
   */
  public static int climbStairsMemoization(int n) {
    int[] memo = new int[n + 1];
    return climb_stairs_memoization(0, n, memo);
  }

  private static int climb_stairs_memoization(int i, int n, int[] memo) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }

    memo[i] = climb_stairs_memoization(i + 1, n, memo) + climb_stairs_memoization(i + 2, n, memo);
    return memo[i];
  }


  /**
   * Dynamic programming
   */
  public static int climbStairsDp(int n) {
    if (n == 1) {
      return n;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int numberOfSteps = 5;
    System.out.println("Number of steps -> " + numberOfSteps);
    System.out.println(
        "Distinct ways to reach the top using brute force is-> " + climbStairsRecursion(
            numberOfSteps));

    System.out.println(
        "Distinct ways to reach the top using memoization is-> " + climbStairsMemoization(
            numberOfSteps));

    System.out.println(
        "Distinct ways to reach the top using DP is-> " + climbStairsDp(numberOfSteps));
  }

}
