package practice.searching;


import java.util.Arrays;

/**
 * LC Q - <a
 * href="https://leetcode.com/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Search2DMatrix {

  public static void main(String[] args) {
    int[][] inputMatrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int target = 3;
    System.out.println(Arrays.toString(inputMatrix));
    System.out.println("Target to find is " + target);

    boolean isTargetPresent = searchMatrix(inputMatrix, target);
    System.out.println(isTargetPresent);
  }

  /**
   * This has a TC of O(log m * n) and SC of O(1)
   */
  private static boolean searchMatrix(int[][] inputMatrix, int target) {
    int m = inputMatrix.length;
    if (m == 0) {
      return false;
    }

    int n = inputMatrix[0].length;
    int left = 0;
    int right = m * n - 1;
    int pivotIndex, pivotElement;

    while (left <= right) {
      pivotIndex = (left + right) / 2;
      pivotElement = inputMatrix[pivotIndex / n][pivotIndex % n];// this is the main meat

      if (target == pivotElement) {
        return true;
      } else if (target < pivotElement) {
        right = pivotIndex - 1;
      } else {
        left = pivotIndex + 1;
      }
    }
    return false;
  }

}
