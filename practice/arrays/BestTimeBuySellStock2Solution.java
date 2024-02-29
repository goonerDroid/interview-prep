package practice.arrays;

import java.util.Arrays;

/**
 * LC Question - <a
 * href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class BestTimeBuySellStock2Solution {

  private static int maxProfitBF(int[] prices) {

    return calculateBF(prices, 0);
  }

  private static int calculateBF(int[] prices, int s) {
    if (s >= prices.length) {
      return 0;
    }

    int max = 0;
    for (int start = s; start < prices.length; start++) {
      int maxProfit = 0;
      for (int i = start + 1; i < prices.length; i++) {
        if (prices[start] < prices[i]) {
          int profit = calculateBF(prices, i + 1) + prices[i] - prices[start];
          if (profit > maxProfit) {
            maxProfit = profit;
          }
        }
      }

      if (maxProfit > max) {
        max = maxProfit;
      }

    }
    return max;
  }


  /**
   * Using peak/valley approach continuously check whether prices[i] and prices[i+1], First if ith
   * element is greater, then save the valley and otherwise
   * <p>
   * This has a time complexity of O(n) and space complexity of O(1) since no new dat struc was
   * used
   */
  private static int maxProfit(int[] prices) {
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxProfit = 0;

    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxProfit += peak - valley;
    }
    return maxProfit;
  }


  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println("Prices given as follows -> " + Arrays.toString(prices));

    System.out.print("Max Profit is  " + maxProfit(prices));
  }
}
