package practice.strings;


/**
 * LC Question  - <a
 * href="https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class ValidPalindromeSolution {

  /**
   * Brute force method uses String builder and reversal and then doing .equals() to the filtered
   * and reversed strings.
   * <p>
   * This has time complexity of O(n) and space complexity of O(n) since reversing and storing of
   * the string requires extra space
   */
  private static boolean isPalindrome(String s) {
    StringBuilder builder = new StringBuilder();

    for (char ch : s.toCharArray()) {

      if (Character.isLetterOrDigit(ch)) {
        builder.append(Character.toLowerCase(ch));
      }
    }

    String filteredString = builder.toString();
    String reverseString = builder.reverse().toString();

    return filteredString.equals(reverseString);
  }

  private static boolean isPalindrome1(String s) {

    //Init two pointers and start one from the start and the other from the end
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {

      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }

      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    String input = "A man, a plan, a canal: Panama";
//    String input = "race a car";
//    String input = " ";

    boolean isPalindrome = isPalindrome1(input);

    System.out.println("The given input -> " + input);
    System.out.println("Is a " + isPalindrome + " palindrome.");
  }

}
