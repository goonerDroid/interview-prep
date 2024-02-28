package practice;

import java.util.HashSet;

public class ContainsDuplicateSolution {

  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int x : nums) {
      if (hashSet.contains(x)) {
        return true;
      }
      hashSet.add(x);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {0, 4, 5, 0, 3, 6};

    boolean result = containsDuplicate(nums);
    System.out.print("Is duplicate? ---> " + result);
  }

}
