package practice.sorting;

public class kLargestElement {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 2, 1, 5, 6, 4};
    int k = 2;

    System.out.println("Given unsorted array");
    for (int i : arr) {
      System.out.print(i + ", ");
    }
    System.out.println();
    int[] tempArr = new int[arr.length];
    System.arraycopy(arr, 0, tempArr, 0, arr.length);

    int kthLargestElement = getKthLargestElement(tempArr, k, 0, arr.length - 1);
    System.out.println("Index"+ kthLargestElement);
    System.out.println(
        "Kth Largest Element index is : " + arr[kthLargestElement]);
  }

  private static int getKthLargestElement(int[] arr, int k, int low, int high) {
    int pivotPoint = getPivotPoint(arr, low, high);
    if (pivotPoint == k) {
      return arr[pivotPoint];
    } else if (pivotPoint < k) {
      return getKthLargestElement(arr, k, pivotPoint + 1, high);
    } else {
      return getKthLargestElement(arr, k, low, pivotPoint - 1);
    }
  }

  private static int getPivotPoint(int[] arr, int low, int high) {
    int pivotElement = arr[high];
    int pivotPoint = low;

    for (int i = low; i < high; i++) {
      if (arr[i] < pivotElement) {
        int tmp = arr[i];
        arr[i] = arr[pivotPoint];
        arr[pivotPoint] = tmp;
        pivotPoint++;
      }

    }
    int tmp = arr[pivotPoint];
    arr[pivotPoint] = arr[high];
    arr[high] = tmp;

    return pivotPoint;
  }

}
