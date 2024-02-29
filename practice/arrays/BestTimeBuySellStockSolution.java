package practice.arrays;

import java.util.Arrays;

/**
 * LC question - <a
 * href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class BestTimeBuySellStockSolution {

  /**
   * This BF impl tries to compare between two adjacent indexes. So we should find the max between
   * nums[j] - nums[i]
   * <p>
   * Analysis - This has a time complexity of O(n*2) since we are looping twice
   * <p>
   * It has a space complexity of O(1) since we are using the same data structure
   */
  private static int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }

  /**
   * Using this one pass approach we can achieve a linear time complexity and space complexity of
   * O(1) since no extra space was used.
   */
  private static int maxProfit1(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else if (price - minPrice > maxProfit) {
        maxProfit = price - minPrice;
      }
    }
    return maxProfit;
  }


  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
//    int[] prices = {7, 6, 4, 3, 1};

    System.out.println("Prices given as follows -> " + Arrays.toString(prices));

    System.out.print("Max Profit is  " + maxProfit1(prices));
  }

}
