package practice.searching;

import java.util.Arrays;

public class Search2DMatrix2 {

  private static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    int shorterDim = Math.min(matrix.length, matrix[0].length);
    for (int i = 0; i < shorterDim; i++) {
      boolean verticalFound = binarySearch(matrix, target, i, true);
      boolean horizontalFound = binarySearch(matrix, target, i, false);
      if (verticalFound || horizontalFound) {
        return true;
      }
    }
    return false;
  }

  private static boolean binarySearch(int[][] matrix, int target, int start, boolean isVertical) {

    int low = start;
    int high = isVertical ? matrix[0].length - 1 : matrix.length - 1;

    while (high >= low) {
      int mid = (low + high) / 2;
      if (isVertical) {
        if (matrix[start][mid] < target) {
          low = mid + 1;
        } else if (matrix[start][mid] > target) {
          high = mid - 1;
        } else {
          return true;
        }
      } else {
        if (matrix[mid][start] < target) {
          low = mid + 1;
        } else if (matrix[mid][start] > target) {
          high = mid - 1;
        } else {
          return true;
        }
      }
    }
    return false;
  }


  public static void main(String[] args) {
    int[][] inputMatrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
    int target = 5;
    System.out.println(Arrays.toString(inputMatrix));
    System.out.println("Target to find is " + target);

    boolean isTargetPresent = searchMatrix(inputMatrix, target);
    System.out.println(isTargetPresent + " using binary search");
  }

}
