package practice.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * LC - Q - <a href="https://leetcode.com/problems/fibonacci-number/">...</a>
 */
public class FibonacciNumber {

  public static int fibRecursive(int n) {
    if (n <= 1) {
      return n;
    }

    return fibRecursive(n - 1) + fibRecursive(n - 2);
  }

  /**
   * This improves the above recursive method by iteration solving for all of the sub-problems and
   * returning the answer for N, using already computed Fibonacci values.While using a bottom-up
   * approach, we can iteratively compute and store the values, only returning once we reach the
   * result.
   * <p>
   * TC - O(n). Each number N is visited and computed,(however retrieval of values is quicker with
   * O(1))
   */
  public static int fibBottomUp(int n) {
    if (n <= 1) {
      return n;
    }

    int[] cache = new int[n + 1];
    cache[1] = 1;
    for (int i = 2; i <= n; i++) {
      cache[i] = cache[i - 1] + cache[i - 2];
    }

    return cache[n];
  }

  /**
   * Notice that during each recursive call in the top-down approach and each iteration in the
   * bottom-up approach, we only needed to look at the results of fib(N-1) and fib(N-2) to determine
   * the result of fib(N). Therefore, we can achieve O(1) space complexity by only storing the value
   * of the two previous numbers and updating them as we iterate to N.
   */

  public static int fibBottomUp1(int n) {
    if (n <= 1) {
      return n;
    }
    int current = 0;
    int prev1 = 1;
    int prev2 = 0;

    for (int i = 2; i <= n; i++) {
      current = prev1 + prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return current;
  }


  /**
   * Using memoization and Hash map use memoization to store the pre-computed answers, then return
   * the answer for N. We will leverage recursion, but in a smarter way by not repeating the work to
   * calculate existing values.
   * <p>
   * TC- O(n) SC-O(n)
   */
  public static int fibMemoization(int n) {
    HashMap<Integer, Integer> cacheMap = new HashMap<>(Map.of(0, 0, 1, 1));
    if (cacheMap.containsKey(n)) {
      return cacheMap.get(n);
    }

    cacheMap.put(n, fibMemoization(n - 1) + fibMemoization(n - 2));
    return cacheMap.get(n);
  }

  public static void main(String[] args) {
    long start = System.nanoTime();
    System.out.println("Recursion");
    for (int i = 0; i <= 25; i++) {
      System.out.println("Fibonacci of (" + i + ") is--> " + fibRecursive(i));
    }
    endTime(start);

    System.out.println();
    long start1 = System.nanoTime();
    System.out.println("Iteration");
    for (int i = 0; i <= 25; i++) {
      System.out.println("Fibonacci of (" + i + ") is--> " + fibBottomUp(i));
    }
    endTime(start1);

    System.out.println();
    long start2 = System.nanoTime();
    System.out.println("Iteration");
    for (int i = 0; i <= 25; i++) {
      System.out.println("Fibonacci of (" + i + ") is--> " + fibBottomUp1(i));
    }
    endTime(start2);

    System.out.println();
    long start3 = System.nanoTime();

    System.out.println("Memoization");
    for (int i = 0; i <= 25; i++) {
      System.out.println("Fibonacci of (" + i + ") is--> " + fibMemoization(i));
    }
    endTime(start3);
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
